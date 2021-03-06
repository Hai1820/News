package com.myclass.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.entity.CategoryEntity;
import com.myclass.service.CategoryService;
import com.myclass.service.impl.CategoryServiceImpl;

@WebServlet(name = "category", urlPatterns = { UrlConstants.URL_CATEGORY_LIST, UrlConstants.URL_CATEGORY_ADD,
		UrlConstants.URL_CATEGORY_EDIT, UrlConstants.URL_CATEGORY_DELETE })
public class CategoryController extends HttpServlet {

	/**
	 * @author Hoàng Hải
	 */
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_CATEGORY_LIST:
			req.setAttribute("categories", categoryService.findAll());
			req.getRequestDispatcher("/views/admin/category/list.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_CATEGORY_ADD:
			req.getRequestDispatcher("/views/admin/category/list-add.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_CATEGORY_EDIT:
			long id = Long.parseLong(req.getParameter("id"));
			CategoryEntity categoryEntity = categoryService.findById(id);
			req.setAttribute("category", categoryEntity);
			req.getRequestDispatcher("/views/admin/category/list-edit.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_CATEGORY_DELETE:
			long idDelete = Long.parseLong(req.getParameter("id"));
			categoryService.delete(idDelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_CATEGORY_LIST);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String categoryName = req.getParameter("name");
		String categoryCode = req.getParameter("code");
		switch (path) {

		case UrlConstants.URL_CATEGORY_ADD:
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setName(categoryName);
			categoryEntity.setCode(categoryCode);
			int result = categoryService.save(categoryEntity);
			if (result != -1) {
				System.out.println("Save successfully");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_CATEGORY_LIST);
			break;
		case UrlConstants.URL_CATEGORY_EDIT:
			long id = Long.parseLong(req.getParameter("id"));
			CategoryEntity categoryEdit = categoryService.findById(id);
			categoryEdit.setCreatedDate(categoryEdit.getCreatedDate());
			categoryEdit.setCreatedBy(categoryEdit.getCreatedBy());
			categoryEdit.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			categoryEdit.setName(categoryName);
			categoryEdit.setCode(categoryCode);
			int resultEdit = categoryService.update(categoryEdit);
			if (resultEdit != -1) {
				System.out.println("Update successfully");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_CATEGORY_LIST);
			break;
		default:
			break;
		}
	}

}
