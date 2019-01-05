package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.dao.UserEntity;
import com.ecomm.dao.UserRepository;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.ResourceNotException;
import com.ecomm.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public List<User> getUserList() {
		
		logger.info("*****getUserList*****");
		
		List<UserEntity> userEntities = userRepository.findAll();
		
		List<User> users = new ArrayList<User>();
		if(userEntities != null && userEntities.size()>0) {
			users = userEntities.stream()
						.map(pe -> new User(pe.getUserId(), pe.getUserName(), pe.getActive(), pe.getPassword(), pe.getUserRole()))
						.collect(Collectors.toList());
		}
		
		return users;		
	}
	
	public User getUser(Integer userId) {
		
		logger.info("*****UserRepository***** userId: " + userId);
		User user = new User();
		
		if(userId == null) {
			logger.info("*****getUser***** userId is null: ");
			throw new EcommException("User Id should not be null.");
		} else {
		
			UserEntity userEntity = userRepository.findOne(userId);
			if(userEntity != null) {
				BeanUtils.copyProperties(userEntity, user);
			} else if(userEntity == null) {	
				logger.info("*****UserRepository***** No User found for given userId: " + userId);
				throw new ResourceNotException("User has not found for give user id: " + userId);
			} 
		}
		return user;
	}
	
	public void saveUser(User user) throws Exception {
		logger.info("*****saveUser*****");
		if(user == null) {
			logger.info("*****userEntity should not be null*****");
			throw new EcommException("UserEntity should not be null.");
		} else {
			UserEntity pe = new UserEntity();
			BeanUtils.copyProperties(user, pe);
			this.userRepository.save(pe);
			logger.info("*****updateUser***** User inserted successfully ");
		}
		
	}
	
	public void updateUser(User user) {
		
		logger.info("*****updateUser*****");
		
		Integer userId = user.getUserId();
		logger.info("*****updateUser***** userId: " + userId);
		if(userId == null) {
			logger.info("*****getUser***** userId is null: ");
			throw new EcommException("User Id should not be null.");
		} else {
			UserEntity userEntityDB = userRepository.findOne(userId);
			if(userEntityDB == null)	{	
				logger.info("*****updateUser***** No User found for given userId: " + userId);
				throw new ResourceNotException("User has not found for give user id: " + userId);
			} else {
				UserEntity userEntity = new UserEntity();
				BeanUtils.copyProperties(user, userEntity);
				
				this.userRepository.save(userEntity);
				logger.info("*****updateUser***** User updated successfully ");
			}
		}
		
	}
	
	public void deleteUser(Integer userId) {
		
		logger.info("*****deleteUser***** userId: " + userId);
		
		if(userId == null) {
			logger.info("*****getUser***** userId is null: ");
			throw new EcommException("User Id should not be null.");
		} else {
			UserEntity userEntity = userRepository.findOne(userId);
			if(userEntity == null) {
				logger.info("*****UserRepository***** No User found for given userId: " + userId);
				throw new ResourceNotException("User has not found for give user id: " + userId);
			}
				
			this.userRepository.delete(userId);
			logger.info("*****updateUser***** User deleted successfully ");
		}
	}
}
