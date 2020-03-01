package com.library.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.library.entity.Dept;
import com.library.entity.Users;

public interface UserService {
   
	/**
	 * 
	 * @param username  �û���
	 * @return  �û�
	 */
	public Users queryByUserName(String username);
	public List<Users> queryUserListByUserName(Integer pageNum, Integer pageSize,String name);
	/**
	 *  ��ѯ�û��б�
	 * @param pageNum  ��ǰҳ
	 * @param pageSize   ÿҳ��ʾ����
	 * @return   �û��б�
	 */
	List<Users> selectUsersList(Integer pageNum, Integer pageSize);
	 /**
	  * ����������ѯ�û��б�
	  * @param pageNum  ��ǰҳ
	  * @param pageSize  ÿҳ��ʾ����
	  * @param users  �û�����
	  * @return
	  */
	List<Users> selectUsersListByCriteria(Integer pageNum, Integer pageSize,Users users);
	/**
	 * ����û�
	 * @param user  �û���Ϣ
	 */
	public void insertUser(Users user);
	/**
	 * �����û�
	 * @param user  �û���Ϣ
	 */
	public void updateUser(Users user);
	/**
	 * ɾ���û�
	 * @param id �û�id
	 */
	public void deleteUser(int id);
	/**
	 * ��ѯѧԺ�б�
	 * @return
	 */
	public List<Dept> selectDeptList();
    public Users getUserById(Integer id);

}
