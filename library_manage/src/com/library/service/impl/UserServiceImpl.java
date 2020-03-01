package com.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.entity.Dept;
import com.library.entity.DeptExample;
import com.library.entity.Users;
import com.library.entity.UsersExample;
import com.library.entity.UsersExample.Criteria;
import com.library.mapper.DeptMapper;
import com.library.mapper.UsersMapper;
import com.library.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public Users queryByUserName(String name) {		
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<Users> list = usersMapper.selectByExample(example );
		if(list != null && list.size()>0) {			
			return list.get(0);
		}else {
			return null;
		}		
	}
	@Override
	public List<Users> selectUsersList(Integer pageNum, Integer pageSize) {		
			UsersExample example = new UsersExample();
			Criteria criteria = example.createCriteria();
			criteria.andRoleidEqualTo(2);
			List<Users> list = usersMapper.selectByExample(example);
			if(list != null && list.size()>0) {
				return list;
			}else {
				return null;
			}
	}
	@Override
	public List<Users> queryUserListByUserName(Integer pageNum, Integer pageSize,String name) {
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(2);
		criteria.andNameLike("%"+name+"%");                                     
		List<Users> list = usersMapper.selectByExample(example);
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	@Override
	public List<Users> selectUsersListByCriteria(Integer pageNum, Integer pageSize, Users users) {		
			UsersExample example = new UsersExample();
			List<Users> list = usersMapper.selectByExample(example);
			if(list != null && list.size()>0) {
				return list;
			}else {
				return null;
			}
	}
	@Override
	public void insertUser(Users user) {
		usersMapper.insert(user);		
	}
	@Override
	public List<Dept> selectDeptList() {
		DeptExample example = new DeptExample();
		List<Dept> deptList = deptMapper.selectByExample(example );
		if(deptList != null && deptList.size()>0) {
			return deptList;
		}else {
			return null;
		}
	}
	@Override
	public void updateUser(Users user) {
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(user.getName());
		usersMapper.updateByExample(user, example);		
	}
	@Override
	public void deleteUser(int id) {
		usersMapper.deleteByPrimaryKey(id);		
	}
	@Override
	public Users getUserById(Integer id) {
		Users users = usersMapper.selectByPrimaryKey(id);
		return users;
	}
	
	

}
