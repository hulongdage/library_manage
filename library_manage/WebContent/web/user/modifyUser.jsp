<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"> 
      <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">修改密码</a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
         <form class="layui-form" id="updateAdminPasswordForm" onsubmit="return submitForm(this);" action="${pageContext.request.contextPath }/user/updateUserPassword.do" method="post">
		   <div class="layui-form-item" style="margin-top:15px;width:500px;">
		     <label class="layui-form-label">新密码</label>
		     <div class="layui-input-block">
		       <input type="password" id="newPassword1" name="password"  placeholder="请输入新密码"  class="layui-input">
		     </div>  
		   </div>
		   <div class="layui-form-item" style="margin-top:15px;width:500px;">
		     <label class="layui-form-label">确认密码</label>
		     <div class="layui-input-block">
		       <input type="password" id="newPassword2"   placeholder="请再次输入新密码"  class="layui-input">
		     </div>  
		   </div>
		   <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" class="layui-btn"></input>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
    </form> 
 
    </body>
    <script>
    layui.use(['jquery', 'layer','form'], function(){
  	    var $ = layui.$; //重点处
        var layer = layui.layer;
        var form = layui.form;
    });
      
    function submitForm(){
    	var newPassword1=$("#newPassword1").val();
    	var newPassword2=$("#newPassword2").val();     	
    	if(newPassword1 ==null || newPassword1 == ''){
    		alert("新密码为空");
    		return false;
    	}
    	if(newPassword2 ==null || newPassword2 == ''){
    		alert("确认密码为空");
    		return false;
    	}
    	if(newPassword1.length<6 || newPassword1.length>12 || newPassword2.length<6 || newPassword2.length>12){
    		alert("密码长度位6到12位");
    		return false;
    	}
    	if(newPassword1 !=newPassword2){
    		alert("密码不一致");
    		return false;
    	}
    	alert("密码修改成功,请重新登录");     	        	
    	return true;
    	 
    }
      
      
     
    </script>
    
</html>
