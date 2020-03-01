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
        System.out.println("检验用户名");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //根据查询到的用户名所属的角色来构建角色列表
        //这里我有一个自定义的User类，包含id,name,role_id字段
        Users user = userService.queryByUserName(username);
        if(user != null && user.getRoleid() != null) { 
           //有个自定义的枚举类，字段: Admin(1, "ROLE_ADMIN")
           if(user.getRoleid() == UserRoleEnum.Admin.getIndex()) {
               //如果当前用户属于管理员，那么为他赋予相应的权限
               authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           } else if(user.getRoleid() == UserRoleEnum.User.getIndex()) {
               authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
           }else {
               return null;
           }
        } else {
            return null;
        }
        //return null就是认证失败,认证成功返回spring-security自定义的User类，包含应有字段信息
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
