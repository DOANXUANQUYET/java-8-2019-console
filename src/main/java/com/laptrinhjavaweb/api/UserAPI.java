package com.laptrinhjavaweb.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.utils.HttpUtil;
@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO userDTO =  HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userDTO = userService.insert(userDTO);
		mapper.writeValue(response.getOutputStream(), userDTO);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserDTO userDTO =  HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userDTO = userService.update(userDTO);
		mapper.writeValue(response.getOutputStream(), userDTO);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String[]  idString =  request.getParameterValues("id");
		int cnt = userService.delete(idString);
		mapper.writeValue(response.getOutputStream(), cnt);
	}
}
