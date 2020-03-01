package com.library.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.library.util.UserRoleEnum;

public class SuccessHandler implements AuthenticationSuccessHandler {
	 
    /**
     * 注意:要认证用户成功后才会调用这个方法
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String role = null;
        //项目根地址
        String path = request.getContextPath();
        System.out.println("path:======"+path);
           //主机+端口号+项目根路径
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        System.out.println("basePath:----------"+basePath);
        UserDetails principal =(UserDetails) authentication.getPrincipal();
        //权限是我手动赋予的，每一个认证成功的用户只有一个权限
        Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
        for (GrantedAuthority  authority:authorities) {
            //所以authorities的size为1，直接赋予
            role = authority.getAuthority();
        }
        //通过不同的角色转到不同的页面
        if(UserRoleEnum.Admin.getName().equals(role)) {
            response.sendRedirect(basePath+"web/admin/index.jsp");
        } else if(UserRoleEnum.User.getName().equals(role)) {
           response.sendRedirect(basePath+"web/user/index.jsp");
        } else {
            System.out.println("其他");
            response.sendRedirect(basePath+"index.jsp");
        }
    }
}
