package com.library.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.entity.Dept;
import com.library.entity.Users;
import com.library.service.UserService;
import com.library.util.ResponseResult;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showName")
	@ResponseBody
	public ResponseResult<Users> name(){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		ResponseResult<Users> rr = new ResponseResult<>();
		try {
			Users user = userService.queryByUserName(name);		
			rr.setState(1);
			rr.setData(user);
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr ;
	}	
	
	@RequestMapping("/queryName")
	public String queryName(Model model){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return "admin/updatePassword" ;
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(Model model){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return "admin/addUser" ;
	}
	
}