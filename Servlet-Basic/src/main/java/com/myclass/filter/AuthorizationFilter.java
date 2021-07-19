package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.UserDto;
import com.myclass.entity.NewEntity;
import com.myclass.utils.SessionUtils;

public class AuthorizationFilter implements Filter {
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String path = request.getRequestURI();
		if (path.startsWith("/admin")) {
			UserDto userDto = (UserDto) SessionUtils.getInstance().getValue(request, "USER");
			if (userDto != null) {
				if (userDto.getRoleName().equals("ADMIN")) {
					chain.doFilter(servletRequest, servletResponse);
				} else if (userDto.getRoleName().equals("USER")) {
					response.sendRedirect(
							request.getContextPath() + "login?action=login&message=Not Permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "login?action=login&message=Not Login&alert=danger");
			}
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
