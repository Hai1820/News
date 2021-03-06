package com.myclass.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.UserDto;
import com.myclass.entity.RoleEntity;
import com.myclass.entity.UserEntity;
import com.myclass.service.UserService;
import com.myclass.service.impl.UserServiceImpl;

@WebServlet(name = "user", urlPatterns = { UrlConstants.URL_USER_LIST, UrlConstants.URL_USER_ADD,
		UrlConstants.URL_USER_EDIT, UrlConstants.URL_USER_DELETE })
public class UserController extends HttpServlet {

	/**
	 * @author Hoàng Hải
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {

		userService = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		List<RoleEntity> roles = userService.findAllRole();
		switch (path) {
		case UrlConstants.URL_USER_LIST:
			List<UserDto> userList = userService.findAllByJoin();
			req.setAttribute("users", userList);
			req.getRequestDispatcher("/views/admin/user/list.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_EDIT:
			long id = Long.parseLong(req.getParameter("id"));
			UserEntity userEntity = userService.findOne(id);
			req.setAttribute("user", userEntity);
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/views/admin/user/edit.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_ADD:
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/views/admin/user/add.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_USER_DELETE:
			long idDelete = Long.parseLong(req.getParameter("id"));
			userService.delete(idDelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER_LIST);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Long roleId = Long.parseLong(req.getParameter("roleid"));
		String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		switch (path) {
		case UrlConstants.URL_USER_ADD:
			UserEntity user = new UserEntity();
			user.setFullName(fullname);
			user.setUserName(username);
			user.setPassword(passwordHash);
			user.setRoleId(roleId);
			int result = userService.save(user);
			if (result != -1) {
				System.out.println("Thêm mới thành công");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER_LIST);
			break;
		case UrlConstants.URL_USER_EDIT:
			Long id = Long.parseLong(req.getParameter("id"));
			UserEntity userEdit = userService.findOne(id);
			userEdit.setCreatedDate(userEdit.getCreatedDate());
			userEdit.setCreatedBy(userEdit.getCreatedBy());
			userEdit.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			userEdit.setPassword(userEdit.getPassword());
			userEdit.setFullName(fullname);
			userEdit.setUserName(username);
			userEdit.setRoleId(roleId);
			int resultEdit = userService.update(userEdit);
			if (resultEdit != -1) {
				System.out.println("Sửa thành công");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER_LIST);
			break;
		default:
			break;
		}

	}

}
