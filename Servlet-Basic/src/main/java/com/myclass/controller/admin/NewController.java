package com.myclass.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constant.UrlConstants;
import com.myclass.dto.NewsDto;
import com.myclass.entity.CategoryEntity;
import com.myclass.entity.NewEntity;
import com.myclass.service.CategoryService;
import com.myclass.service.NewsServices;
import com.myclass.service.impl.CategoryServiceImpl;
import com.myclass.service.impl.NewsServiceImpl;

@WebServlet(name = "news", urlPatterns = { UrlConstants.URL_LIST_NEWS, UrlConstants.URL_NEWS_EDIT,
		UrlConstants.URL_NEWS_ADD, UrlConstants.URL_NEWS_DELETE })
public class NewController extends HttpServlet {

	/**
	 * @author Hoang Hai
	 */
	private static final long serialVersionUID = 1L;

	private NewsServices newsServices;
	private CategoryService categoryService;

	@Override
	public void init() throws ServletException {
		newsServices = new NewsServiceImpl();
		categoryService = new CategoryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		List<CategoryEntity> categories = categoryService.findAll();

		switch (path) {
		case UrlConstants.URL_LIST_NEWS:
			List<NewsDto> newsList = newsServices.findAllByJoin();
			req.setAttribute("news", newsList);
			req.getRequestDispatcher("/views/admin/news/list.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_NEWS_EDIT:
			long id = Long.parseLong(req.getParameter("id"));
			NewEntity newEntity = newsServices.findOne(id);
			req.setAttribute("news", newEntity);
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/news/list-edit.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_NEWS_ADD:
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/news/add.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_NEWS_DELETE:
			long idDelete = Long.parseLong(req.getParameter("id"));
			newsServices.delete(idDelete);
			req.getRequestDispatcher("/views/admin/news/add.jsp").forward(req, resp);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		String title = req.getParameter("title");
		String thumbnail = req.getParameter("thumbnail");
		String shortdescription = req.getParameter("shortdescription");
		String content = req.getParameter("content");
		long categoryId = Long.parseLong(req.getParameter("categoryId"));
		switch (path) {
		case UrlConstants.URL_NEWS_ADD:
			NewEntity newEntity = new NewEntity();
			newEntity.setTitle(title);
			newEntity.setThumbnail(thumbnail);
			newEntity.setContent(content);
			newEntity.setCategoryId(categoryId);
			newEntity.setShortDescription(shortdescription);
			int result = newsServices.save(newEntity);
			if (result != -1) {
				System.out.println("Insert successfully");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LIST_NEWS);
			break;
		case UrlConstants.URL_NEWS_EDIT:
			long id = Long.parseLong(req.getParameter("id"));
			NewEntity newsEdit = newsServices.findOne(id);
			newsEdit.setCreatedDate(newsEdit.getCreatedDate());
			newsEdit.setCreatedBy(newsEdit.getCreatedBy());
			newsEdit.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			newsEdit.setTitle(title);
			newsEdit.setThumbnail(thumbnail);
			newsEdit.setContent(content);
			newsEdit.setCategoryId(categoryId);
			newsEdit.setShortDescription(shortdescription);
			int resultSave = newsServices.update(newsEdit);
			if (resultSave != -1) {
				System.out.println("Update successfully");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LIST_NEWS);
			break;
		default:
			break;
		}

	}
}
