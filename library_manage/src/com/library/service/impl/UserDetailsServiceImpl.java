package com.library.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.library.entity.Users;
import com.library.mapper.UsersMapper;
import com.library.service.UserService;
/**
 * ��֤��
 * @author Administrator
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//������ɫ�б�
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_User"));
		//�õ��û�����
		Users user = userService.queryByUserName(username);
		if(user != null) {
			return new User(username, user.getPassword(), authorities);
		}else {
			return null;
		}
		
	}

}

