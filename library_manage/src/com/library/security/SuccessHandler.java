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
     * ע��:Ҫ��֤�û��ɹ���Ż�����������
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String role = null;
        //��Ŀ����ַ
        String path = request.getContextPath();
        System.out.println("path:======"+path);
           //����+�˿ں�+��Ŀ��·��
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        System.out.println("basePath:----------"+basePath);
        UserDetails principal =(UserDetails) authentication.getPrincipal();
        //Ȩ�������ֶ�����ģ�ÿһ����֤�ɹ����û�ֻ��һ��Ȩ��
        Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
        for (GrantedAuthority  authority:authorities) {
            //����authorities��sizeΪ1��ֱ�Ӹ���
            role = authority.getAuthority();
        }
        //ͨ����ͬ�Ľ�ɫת����ͬ��ҳ��
        if(UserRoleEnum.Admin.getName().equals(role)) {
            response.sendRedirect(basePath+"web/admin/index.jsp");
        } else if(UserRoleEnum.User.getName().equals(role)) {
           response.sendRedirect(basePath+"web/user/index.jsp");
        } else {
            System.out.println("����");
            response.sendRedirect(basePath+"index.jsp");
        }
    }
}
