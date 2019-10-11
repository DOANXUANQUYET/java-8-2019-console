package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface ICustomerRepository extends IGennericRepository<CustomerEntity>{
	List<CustomerEntity> findAll(Map<String, Object> properties,Pageable pageable,CustomerSearchBuilder customerSearchBuilder);
}
