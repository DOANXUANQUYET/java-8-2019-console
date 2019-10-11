package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/api-customer"})
public class CustomerAPI extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
		
	private static ICustomerService customerService = new CustomerService();
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			CustomerDTO customer =  FormUtil.toModel(CustomerDTO.class, request);
			
			Pageable pageable = new PageRequest(customer.getPage(), customer.getLimit());
			
			CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder.Builder(customer.getCustomerName(), customer.getPhoneNumber())
														.setEmail(customer.getEmail())
														.setStaffId(customer.getStaffId())
														.build();
			
			List<CustomerDTO> customerModels = customerService.findAll(customerSearchBuilder,pageable);
			mapper.writeValue(response.getOutputStream(), customerModels);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		}
}
