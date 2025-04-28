package com.example.demo_rest1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.example.demo_rest1.pojo.User;

@Controller
@RequestMapping(value = "/users")
public class UserInfoContoller {
	private List<User> userInfo = new ArrayList<>();
	
	@GetMapping
	@ResponseBody
	public String getUsers() {
//		return JSON.toJSONString(userInfo);
		return userInfo.toString();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public String getUser(@PathVariable(value = "id") Long id) {
		List<User> user = new ArrayList<>();
		userInfo.forEach(us -> {
			if(us.getId() == id) {
				user.add(us);
			}
		});
		
		return user.toString();
	}
	
	@PostMapping
	@ResponseBody
	public String addUser(@RequestBody User user) {
		userInfo.add(user);
		return "OK";
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable(value = "id") Long id) {
		userInfo.removeIf(user -> user.getId() == id);
		System.out.println(userInfo.toString());
		return "Delete Success!";
	}
	
	@PutMapping(value = "/{id}")
	@ResponseBody
	public String updateUser(@PathVariable("id") Long id ,@RequestBody User user) {
		System.out.println(user.toString());
		userInfo.forEach(us -> {
			if(us.getId() == id) {
				us.setName(user.getName());
				us.setEmail(user.getEmail());
				us.setAge(user.getAge());
			}
		});
		return "Update Success!";
	}
	
}
