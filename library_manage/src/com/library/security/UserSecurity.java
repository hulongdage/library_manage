package com.library.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.library.entity.Users;
import com.library.service.UserService;
import com.library.util.UserRoleEnum;

public class UserSecurity implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("�����û���");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //���ݲ�ѯ�����û��������Ľ�ɫ��������ɫ�б�
        //��������һ���Զ����User�࣬����id,name,role_id�ֶ�
        Users user = userService.queryByUserName(username);
        if(user != null && user.getRoleid() != null) { 
           //�и��Զ����ö���࣬�ֶ�: Admin(1, "ROLE_ADMIN")
           if(user.getRoleid() == UserRoleEnum.Admin.getIndex()) {
               //�����ǰ�û����ڹ���Ա����ôΪ��������Ӧ��Ȩ��
               authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           } else if(user.getRoleid() == UserRoleEnum.User.getIndex()) {
               authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
           }else {
               return null;
           }
        } else {
            return null;
        }
        //return null������֤ʧ��,��֤�ɹ�����spring-security�Զ����User�࣬����Ӧ���ֶ���Ϣ
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
