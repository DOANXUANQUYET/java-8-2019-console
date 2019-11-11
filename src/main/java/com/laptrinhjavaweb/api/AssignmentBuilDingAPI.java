package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import com.laptrinhjavaweb.service.impl.AssignmentBuildingService;

@WebServlet(urlPatterns = {"/api-assigment-building"})
public class AssignmentBuilDingAPI extends HttpServlet {
	
	private static final IAssignmentBuildingService sevice = new AssignmentBuildingService();
	private static final long serialVersionUID = -915988021506484384L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json");
//		BuildingDTO building =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
//		building = buildingService.insert(building);
//		mapper.writeValue(response.getOutputStream(), building);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		List<AssignmentBuildingDTO> assignmentBuildingModels = sevice.getAssignmentStaff();
		mapper.writeValue(response.getOutputStream(), assignmentBuildingModels);
	}
	
}
