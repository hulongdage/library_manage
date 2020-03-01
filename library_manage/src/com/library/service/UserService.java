package com.library.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.library.entity.Dept;
import com.library.entity.Users;

public interface UserService {
   
	/**
	 * 
	 * @param username  用户名
	 * @return  用户
	 */
	public Users queryByUserName(String username);
	public List<Users> queryUserListByUserName(Integer pageNum, Integer pageSize,String name);
	/**
	 *  查询用户列表
	 * @param pageNum  当前页
	 * @param pageSize   每页显示条数
	 * @return   用户列表
	 */
	List<Users> selectUsersList(Integer pageNum, Integer pageSize);
	 /**
	  * 根据条件查询用户列表
	  * @param pageNum  当前页
	  * @param pageSize  每页显示条数
	  * @param users  用户条件
	  * @return
	  */
	List<Users> selectUsersListByCriteria(Integer pageNum, Integer pageSize,Users users);
	/**
	 * 添加用户
	 * @param user  用户信息
	 */
	public void insertUser(Users user);
	/**
	 * 更新用户
	 * @param user  用户信息
	 */
	public void updateUser(Users user);
	/**
	 * 删除用户
	 * @param id 用户id
	 */
	public void deleteUser(int id);
	/**
	 * 查询学院列表
	 * @return
	 */
	public List<Dept> selectDeptList();
    public Users getUserById(Integer id);

}
