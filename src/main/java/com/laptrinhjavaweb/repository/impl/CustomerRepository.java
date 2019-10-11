package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.ICustomerRepository;

public class CustomerRepository extends GenericRepository<CustomerEntity> implements ICustomerRepository{

	@Override
	public List<CustomerEntity> findAll(Map<String, Object> properties,Pageable pageable,CustomerSearchBuilder customerSearchBuilder) {
		if(StringUtils.isNotBlank(customerSearchBuilder.getStaffId())) {
			StringBuilder sql = new StringBuilder("SELECT * FROM customer C INNER JOIN assinmentcustomer AC ON AC.customerid = C.id  WHERE 1 = 1 ");
			sql.append(" AND staffid = " + customerSearchBuilder.getStaffId() + "");
			sql = this.createSQLfindAll(properties, sql);
			return this.findAll(sql.toString(), pageable);
		}
		return this.findAll(properties, pageable);
	}

}
