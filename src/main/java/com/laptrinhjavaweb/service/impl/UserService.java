package com.laptrinhjavaweb.service.impl;

import java.util.Date;

import com.laptrinhjavaweb.converter.UserConvert;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{
	
	private static UserConvert UserConvert = new UserConvert();
	private static IUserRepository userRepository = new UserRepository();

	@Override
	public UserDTO findById(Long id) {
		UserEntity userEntity = userRepository.findById(id);
		return UserConvert.convertToDTO(userEntity);
	}

	@Override
	public UserDTO insert(UserDTO userDTO) {
		UserEntity customerEntity = UserConvert.convertToEntity(userDTO);
		customerEntity.setCreatedDate(new Date());
		customerEntity.setCreatedBy("quyet dep trai");
		Long id = userRepository.insert(customerEntity);
		return UserConvert.convertToDTO(userRepository.findById(id));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserEntity userEntity = UserConvert.convertToEntity(userDTO);
		userEntity.setModifiedDate(new Date());
		userEntity.setModifiedBy("quyet dep trai part 2");
		Long isSuccess = userRepository.update(userEntity);
		if(isSuccess > 0) {
			return UserConvert.convertToDTO(userRepository.findById(userDTO.getId()));
		}
		return new UserDTO();
	}

	@Override
	public int delete(String[] idString) {
		// TODO Auto-generated method stub
		return 0;
	}

}
