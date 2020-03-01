package com.library.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.entity.Dept;
import com.library.entity.Users;
import com.library.service.UserService;
import com.library.util.Pag;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 用户头像上传
		@RequestMapping("/uploadHeadImage")
		@ResponseBody
		public JSONObject uploadHeadImage(@RequestParam(value="file",required=false) MultipartFile file, @ModelAttribute Users user, HttpServletRequest request, InputStream stream)
				throws IOException {
			Assert.notNull(file, "上传文件不能为空");
			String src="/library_manage/images/";
			//String path = request.getSession().getServletContext().getRealPath("/"+src);
			String path="D:/SystemImages";
			JSONObject json = new JSONObject();
			//System.currentTimeMillis()根据系统时间产生随机数，保证上传的图片名字不一样
			String name=System.currentTimeMillis()+file.getOriginalFilename();
			File dir = new File(path, name);
			src=src+name;
			if (!dir.exists()) {
				dir.mkdirs();
				json.put("msg","上传成功");
				json.put("code",0);
				json.put("src",src);
			} else {
				json.put("msg","上传失败");
				json.put("code",1);
			}
			file.transferTo(dir);
			return json;
		}
	
	@RequestMapping("/queryByUserName")
	@ResponseBody
	public Users queryByUserName(String name) {
		Users users = userService.queryByUserName(name);
		return users;
	}
	
	@RequestMapping("/addUser")
	public String addUser(Users user){
		//密码加密
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("123456");  //加密		
		user.setPassword(password);
		user.setRoleid(2);
		userService.insertUser(user);
		return "admin/addUser3";		
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public void deleteUser(Integer id){			
		userService.deleteUser(id);		
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(Users user){
		//密码加密
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());  //加密		
		user.setPassword(password);
		user.setRoleid(2);
		userService.insertUser(user);
		return "admin/addUser";		
	}
	
	@RequestMapping("/updateUserDetail")
	public String updateUserDetail(Users user,Model model){
		user.setRoleid(2);
		userService.updateUser(user);
		Users users2 = userService.getUserById(user.getId());	
		model.addAttribute("user", users2);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		return "user/user_info1" ;
	}
	
	@RequestMapping("/updateAdminDetail")
	public String updateAdminDetail(Users user,Model model){
		user.setRoleid(1);
		userService.updateUser(user);
		Users users2 = userService.getUserById(user.getId());	
		model.addAttribute("user", users2);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		return "admin/admin_info1" ;
	}
	
	@RequestMapping("/updateAdminPassword")
	public String updateAdminPassword(Users user){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();		
		Users users = userService.queryByUserName(name);		
		//密码加密
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());  //加密
		users.setPassword(password);
		userService.updateUser(users);		
		return "admin/index1";		
	}
	@RequestMapping("/updateUserPassword")
	public String updateUserPassword(Users user){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();		
		Users users = userService.queryByUserName(name);		
		//密码加密
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());  //加密
		users.setPassword(password);
		userService.updateUser(users);		
		return "user/index1";		
	}
	
	@RequestMapping("/queryUsersList")
	@ResponseBody
	public String selectUsersList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Users> list = userService.selectUsersList(pagenum, pageSize);
		PageInfo<Users> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settUser(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryUserListByUserName")
	@ResponseBody
	public String queryUserListByUserName(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String name){
		PageHelper.startPage(pagenum, pageSize);
		List<Users> list = userService.queryUserListByUserName(pagenum, pageSize,name);
		PageInfo<Users> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settUser(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryUsersListByCriteria")
	@ResponseBody
	public PageInfo<Users> selectUsersListByCriteria(Integer pageNum, Integer pageSize, Users users){
		PageHelper.startPage(pageNum, pageSize);
		List<Users> list = userService.selectUsersListByCriteria(pageNum, pageSize, users);
		return null;		
	}
	
	@RequestMapping("/queryDeptList")
	public String queryDeptList(Model model){
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		return "admin/addUser2" ;
	}
	
	@RequestMapping("/showModifyUser")
	public String showModifyUser(Model model){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return "user/modifyUser1" ;
	}
	
	@RequestMapping("/showUserDetail")
	public String showReaderDetail(Model model){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return "user/user_info";		
	}
	
	@RequestMapping("/showAdminDetail")
	public String showAdminDetail(Model model){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return "admin/admin_info";		
	}
	
	@RequestMapping("/toModifyUser")
	@ResponseBody
	public Users toModifyUser(){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		return user ;
	}
	
}
