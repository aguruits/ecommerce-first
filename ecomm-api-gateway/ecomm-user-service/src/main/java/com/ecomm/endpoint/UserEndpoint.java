package com.ecomm.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.EcommException;
import com.ecomm.model.User;
import com.ecomm.model.UserResponse;
import com.ecomm.service.UserService;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

		@Autowired
		UserService userService;
		
		@GetMapping("/getUsers")
		public List<User> getUserList() {
			return userService.getUserList();
		}

		@GetMapping("/getUser/{userId}")
		public UserResponse getUser(@PathVariable("userId") int userId) {
			
			User user = new User();
			
			user = userService.getUser(userId);
			
			UserResponse responseMessage = new UserResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("User Found.");
			responseMessage.setUser(user);
			
			return responseMessage;
		}

		@PostMapping("/addUser")
		public UserResponse addUser(@RequestBody User userDetailModel) {
			
			try { 
				this.userService.saveUser(userDetailModel);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while inserting user details into the Table");
			}
			
			UserResponse responseMessage = new UserResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("User hase been inserted successfully.");
			return responseMessage;
		}
		
		@PutMapping("/updateUser")
		public UserResponse updateUser(@RequestBody User userDetailModel) {
			
			try { 
				this.userService.updateUser(userDetailModel);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while updating user details.");
			}
			
			UserResponse responseMessage = new UserResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("User details updated successfully.");
			return responseMessage;
		}

		@DeleteMapping("/deleteUser/{userId}")
		public UserResponse deleteUser(@PathVariable("userId") int userId) {
			
			try { 
				this.userService.deleteUser(userId);;
			} catch (Exception e) {
				e.printStackTrace();
				throw new EcommException("Error occurred while deleting user details.");
			}
			
			UserResponse responseMessage = new UserResponse();
			responseMessage.setResponeStatus("Success");
			responseMessage.setResponseCode("00");
			responseMessage.setResponseDesc("User details has been deleted successfully.");
			return responseMessage;
		}
	}

