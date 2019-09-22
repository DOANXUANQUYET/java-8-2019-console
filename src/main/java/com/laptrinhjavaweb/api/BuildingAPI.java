package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-building"})
public class BuildingAPI extends HttpServlet {
	
	
	private static final long serialVersionUID = -915988021506484384L;
	static private BuildingService buildingService = new BuildingService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO building =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		mapper.writeValue(response.getOutputStream(), building);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO building =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		//map vao builder phan trang
		Pageable pageable = new PageRequest(building.getPage(), building.getLimit());
		
		//map cac gia tri vao builder tao sqlwhere
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder(building.getName(), building.getDistrict())
				.setBuildingArea(building.getBuildingArea())
				.setNumberOfBasement(building.getNumberOfBasement())
				.build();
		
		//search buiding duoi DB
		List<BuildingDTO> buildingsBuildingModels = buildingService.findAll(buildingSearchBuilder,pageable);
		mapper.writeValue(response.getOutputStream(), buildingsBuildingModels);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
