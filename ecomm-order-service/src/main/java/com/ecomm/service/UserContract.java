package com.ecomm.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomm.model.user.User;
import com.ecomm.model.user.UserResponse;

@FeignClient(name="ecomm-user-service")
@RibbonClient(name="ecomm-user-service")
public interface UserContract {

	@GetMapping("/user/getUsers")
	public List<User> getUserList();

	@GetMapping("/user/getUser/{userId}")
	public UserResponse getUser(@PathVariable("userId") int userId);

	@PostMapping("/user/addUser")
	public UserResponse addUser(@RequestBody User userDetailModel);
	
	@PutMapping("/user/updateUser")
	public UserResponse updateUser(@RequestBody User userDetailModel);

	@DeleteMapping("/user/deleteUser/{userId}")
	public UserResponse deleteUser(@PathVariable("userId") int userId);
}

