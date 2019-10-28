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
import com.laptrinhjavaweb.utils.FormUtil;
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
		building = buildingService.insert(building);
		mapper.writeValue(response.getOutputStream(), building);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO building =  FormUtil.toModel(BuildingDTO.class, request);
		//map vao builder phan trang
		Pageable pageable = new PageRequest(building.getPage(), building.getLimit());
		
		//map cac gia tri vao builder tao sqlwhere
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder(building.getName(), building.getDistrict())
				.setBuildingArea(building.getBuildingArea())
				.setNumberOfBasement(building.getNumberOfBasement())
				.setWard(building.getWard())
				.setBuildingTypes(building.getBuildingTypes())
				.setAreaRentFrom(building.getAreaRentFrom())
				.setAreaRentTo(building.getAreaRentTo())
				.setCostRentFrom(building.getCostRentFrom())
				.setCostRentTo(building.getCostRentTo())
				.setStaffId(building.getStaffId())
				.build();
		
		//search buiding duoi DB
		List<BuildingDTO> buildingModels = buildingService.findAll(buildingSearchBuilder,pageable);
		mapper.writeValue(response.getOutputStream(), buildingModels);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String[]  idString =  request.getParameterValues("id");
		int cnt = buildingService.delete(idString);
		mapper.writeValue(response.getOutputStream(), cnt);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO building =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		building = buildingService.update(building);
		mapper.writeValue(response.getOutputStream(), building);
	}
}
