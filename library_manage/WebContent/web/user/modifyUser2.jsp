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
                <form class="layui-form" id="formSubmit"  action="${pageContext.request.contextPath }/user/updateUserDetail.do" method="post">                
                  <input type="hidden" name="id" value=${user.id }>
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>用户名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="name" id="inputName" value="${user.name }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为用户的名称
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>用户密码
                      </label>
                      <div class="layui-input-inline">
                          <input type="password"  name="password" id="password1" value="${user.password }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为用户的密码
                      </div>
                  </div>                                
                      <c:if test="${user.sex=='男'}">           
                     <div class="layui-form-item">
                         <label class="layui-form-label"><span class="x-red">*</span>读者性别</label>
                      <div class="layui-input-block">
                        <input type="radio" value="男" name="sex" lay-skin="primary" title="男" checked="checked">
                        <input type="radio" value="女" name="sex" lay-skin="primary" title="女" >
                      </div>                   
                    </div>                                                                                                  
                  </c:if>
                  <c:if test="${user.sex=='女'}">           
                     <div class="layui-form-item">
                         <label class="layui-form-label"><span class="x-red">*</span>读者性别</label>
                      <div class="layui-input-block">
                        <input type="radio" value="男" name="sex" lay-skin="primary" title="男" >
                        <input type="radio" value="女" name="sex" lay-skin="primary" title="女" checked="checked">
                      </div>
                      
                    </div>                                                                                                  
                  </c:if>
                  <div class="layui-form-item">
                      <label for="L_pass" class="layui-form-label">
                          <span class="x-red">*</span>所在系部
                      </label>
                      <div class="layui-input-inline"> 
                           <select id="selectList" name="dept">
                    					    <c:forEach var="dept" items="${deptList }">	                    					     
                    					       <c:if test="${dept.name==user.dept }">
                    					          <option value="${dept.name }" selected="selected">${dept.name }</option>
                    					       </c:if>
                    					       <c:if test="${dept.name!=user.dept }">
                    					          <option value="${dept.name }">${dept.name }</option>
                    					       </c:if>
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
                      <input type="button"  onclick="UserFormSubmit();" class="layui-btn" value="提交">                     
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
        function UserFormSubmit(){
        	var inputName=$("#inputName").val();
        	var password1=$("#password1").val();       	
        	if(inputName ==null || inputName == ''){
        		alert("用户名为空");
        		return ;
        	}
        	if(password1 ==null || password1 == ''){
        			alert("请输入密码");
        			return ;
        	}
        	if(password1.length<6 || password1.length>12){
        		
        		alert("密码长度为6到12位");
    			return ;
        	}        	        	
        	$("#formSubmit").submit();
        	var index = parent.layer.getFrameIndex(window.name);
        	parent.layer.close(index);
        	parent.location.reload();
        	
        	 
        }
        </script>
        
    </body>

</html>
