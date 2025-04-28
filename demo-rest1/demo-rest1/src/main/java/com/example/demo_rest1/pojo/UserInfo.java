package com.example.demo_rest1.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserInfo {
	List<User> userInfo = new ArrayList<>();
//
//	public List<User> getUserInfo() {
//		return userInfo;
//	}
//
//	public void setUserInfo(List<User> userInfo) {
//		this.userInfo = userInfo;
//	}
}
