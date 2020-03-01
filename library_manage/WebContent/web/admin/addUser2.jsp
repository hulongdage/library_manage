<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">   
    <head>
        <meta charset="UTF-8">
        <title>修改读者信息页面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
            <form class="layui-form" id="addUserForm" onsubmit="return submitForm(this);" action="${pageContext.request.contextPath }/user/addUser.do" method="post">             
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>用户名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="name" id="inputName" required="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为用户的名称
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>电话号码
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="phonenumber" id="inputPhonenumber" required="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为用户的电话号码
                      </div>
                  </div>                                                                 
                     <div class="layui-form-item">
                         <label class="layui-form-label"><span class="x-red">*</span>读者性别</label>
                      <div class="layui-input-block">
                        <input type="radio" value="男" name="sex" lay-skin="primary" title="男" checked="checked">
                        <input type="radio" value="女" name="sex" lay-skin="primary" title="女" >
                      </div>
                    </div>                                                                                                                   
                  <div class="layui-form-item">
                      <label for="L_pass" class="layui-form-label">
                          <span class="x-red">*</span>所在系部
                      </label>
                      <div class="layui-input-inline"> 
                           <select id="selectList" name="dept">   
                                  <c:forEach var="dept" items="${deptList }">               					    
          					          <option value="${dept.name }" selected="selected">${dept.name }</option>                  				
          					      </c:forEach>   
          					</select>
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                                                              用户所在系部
                      </div>
                  </div>                
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                      </label>
                      <input type="submit" class="layui-btn"></input>                    
                  </div>
              </form>
            </div>
        </div>
        <script>
        layui.use(['jquery', 'layer','form'], function(){
      	    var $ = layui.$; //重点处
            var layer = layui.layer;
            var form = layui.form;
        });
        function submitForm(){
        	var inputName=$("#inputName").val(); 
        	var inputPhonenumber=$("#inputPhonenumber").val();  
        	if(inputName ==null || inputName == ''){
        		alert("用户名称为空");
        		return false;
        	}else if(inputName.length<2 || inputName.length>6){
        		alert("用户名称长度为2到6位");
        		return false;
        	}else if(inputPhonenumber ==null || inputPhonenumber == ''){
        		alert("电话号码为空");
        		return false;
        	}else if(!(/^1[34578]\d{9}$/.test(inputPhonenumber))){
        		alert("手机号码有误，请重填"); 
        		return false;
        	}else{
        		alert("添加成功");       		
        		return true;        		
        	}	     	        		 
        }
        </script>
        
    </body>

</html>
