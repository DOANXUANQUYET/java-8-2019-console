package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	UserDTO findById(Long id);
	UserDTO insert(UserDTO userDTO);
	UserDTO update(UserDTO userDTO);
	int delete(String[] idString);
}
