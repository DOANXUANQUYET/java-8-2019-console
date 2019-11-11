package com.laptrinhjavaweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/building-list" })
public class BuildingControllerList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static private BuildingService buildingService = new BuildingService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//BuildingDTO building =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		String url = "";
		BuildingDTO building = FormUtil.toModel(BuildingDTO.class, request);
		String action = request.getParameter("action");
		if (action != null && action.equals("LIST") ) {
			Pageable pageable = new PageRequest(0, 10);
			// map cac gia tri vao builder tao sqlwhere
			BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder(building.getName(),
					building.getDistrict()).setBuildingArea(building.getBuildingArea())
							.setNumberOfBasement(building.getNumberOfBasement()).setWard(building.getWard())
							.setBuildingTypes(building.getBuildingTypes()).setAreaRentFrom(building.getAreaRentFrom())
							.setAreaRentTo(building.getAreaRentTo()).setCostRentFrom(building.getCostRentFrom())
							.setCostRentTo(building.getCostRentTo()).setStaffId(building.getStaffId()).build();

		// search buiding duoi DB
			List<BuildingDTO> buildingModels = buildingService.findAll(buildingSearchBuilder, pageable);
			request.setAttribute("buildingModels", buildingModels);
			url = "/views/admin/buildingList.jsp";
		}else if(action != null && action.equals("EDIT")) {
			url = "/views/admin/buildingEdit.jsp";
		}
		// map vao builder phan trang
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
