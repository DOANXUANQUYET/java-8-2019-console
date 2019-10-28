package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface ICustomerService {
	List<CustomerDTO> findAll(CustomerSearchBuilder builder,Pageable pageable);
	CustomerDTO findById(Long id);
	CustomerDTO insert(CustomerDTO customerDTO);
	CustomerDTO update(CustomerDTO customerDTO);
	int delete(String[] idString);
}
