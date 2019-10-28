package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

public class CustomerConvert {
	public CustomerDTO convertToDTO(CustomerEntity customerEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customerEntity,CustomerDTO.class);
	}
	
	public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customerDTO,CustomerEntity.class);
	}
}
