package com.myclass.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.UserDto;
import com.myclass.service.CategoryService;
import com.myclass.service.UserService;
import com.myclass.service.impl.CategoryServiceImpl;
import com.myclass.service.impl.UserServiceImpl;
import com.myclass.utils.SessionUtils;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeServlet extends HttpServlet {

	/**
	 * @author Hoang Hai
	 */
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = null;
	private UserService userService = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		categoryService = new CategoryServiceImpl();
		userService = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
		if (action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if (message != null && alert != null) {
				req.setAttribute("message", "Username or Password is invalid");
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/decorators/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtils.getInstance().removeValue(req, "USER");
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			req.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (action != null && action.equals("login")) {
			UserDto userDto = userService.checkLogin(username, password);
			if (userDto != null) {
				SessionUtils.getInstance().putValue(req, "USER", userDto);
				if (userDto.getRoleName().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ADMIN);
				} else if (userDto.getRoleName().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			} else {
				resp.sendRedirect(req.getContextPath()
						+ "/login?action=login&message=Username or Password is invalid&alert=danger");
			}
		}
	}
}
