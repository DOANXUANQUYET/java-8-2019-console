package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConvert;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.impl.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;

public class CustomerService implements ICustomerService{
	
	private static CustomerRepository customerRepository;
	private static CustomerConvert customerConvert;
	
	public CustomerService() {
		customerConvert = new CustomerConvert();
		customerRepository = new CustomerRepository();
	}

	@Override
	public List<CustomerDTO> findAll(CustomerSearchBuilder builder, Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(builder);
		return customerRepository.findAll(properties, pageable, builder).stream()
				.map(item -> customerConvert.convertToDTO(item)).collect(Collectors.toList());
	}
	
	private Map<String, Object> convertToMapProperties(CustomerSearchBuilder fieldSearch) {
		Map<String, Object> properties = new HashMap<String, Object>();
		try {
			Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().equals("staffId")) {
					field.setAccessible(true);		
					if (field.get(fieldSearch) instanceof String) {
						if(StringUtils.isNotBlank((String) field.get(fieldSearch))) {							
							properties.put(field.getName().toLowerCase(), field.get(fieldSearch));
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return properties;

	}

	@Override
	public CustomerDTO findById(Long id) {
		CustomerEntity customerEntity = customerRepository.findById(id);
		return customerConvert.convertToDTO(customerEntity);
	}

	@Override
	public CustomerDTO insert(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = customerConvert.convertToEntity(customerDTO);
		customerEntity.setCreatedDate(new Date());
		customerEntity.setCreatedBy("quyet dep trai");
		Long id = customerRepository.insert(customerEntity);
		return customerConvert.convertToDTO(customerRepository.findById(id));
	}

	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = customerConvert.convertToEntity(customerDTO);
		customerEntity.setModifiedDate(new Date());
		customerEntity.setModifiedBy("quyet dep trai part 2");
		Long isSuccess = customerRepository.update(customerEntity);
		if(isSuccess > 0) {
			return customerConvert.convertToDTO(customerRepository.findById(customerDTO.getId()));
		}
		return new CustomerDTO();
	}

	@Override
	public int delete(String[] idString) {
		return customerRepository.delete(idString);
	}

}
