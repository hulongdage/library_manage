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
            <form class="layui-form" id="addUserForm" onsubmit="return submitForm(this);" action="${pageContext.request.contextPath }/reader/updateReader.do" method="post">               
                  <input type="hidden"  name="readerkey" value="${reader.readerkey }"
                          autocomplete="off" class="layui-input">
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>读者姓名
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="name" value="${reader.name }" id="inputName"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为读者的姓名
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>读者年龄
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="age"  value="${reader.age }" id="inputAge"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为读者的年龄
                      </div>
                  </div>
                  
                  <c:if test="${reader.sex=='男' }">
	                      <div class="layui-form-item">
	                          <label class="layui-form-label"><span class="x-red">*</span>读者性别</label>
		                      <div class="layui-input-block">
		                        <input type="radio" value="男" name="sex" lay-skin="primary" title="男" checked="checked">
		                        <input type="radio" value="女" name="sex" lay-skin="primary" title="女">
		                      </div>
	                     </div>
                  </c:if>
                  
                  <c:if test="${reader.sex=='女' }">
	                      <div class="layui-form-item">
	                          <label class="layui-form-label"><span class="x-red">*</span>读者性别</label>
		                      <div class="layui-input-block">
		                        <input type="radio" value="男" name="sex" lay-skin="primary" title="男" >
		                        <input type="radio" value="女" name="sex" lay-skin="primary" title="女" checked="checked">
		                      </div>
	                     </div>
                  </c:if>
                  
                  <c:if test="${reader.typename=='普通读者' }">
	                      <div class="layui-form-item">
	                          <label class="layui-form-label"><span class="x-red">*</span>读者类型</label>
		                      <div class="layui-input-block">
		                        <input type="radio" value="普通读者" name="typename" lay-skin="primary" title="普通读者" checked="checked">
		                        <input type="radio" value="高级读者" name="typename" lay-skin="primary" title="高级读者">
		                        <input type="radio" value="老师" name="typename" lay-skin="primary" title="老师">
		                      </div>
	                     </div>
                  </c:if>
                  <c:if test="${reader.typename=='高级读者' }">
	                      <div class="layui-form-item">
	                          <label class="layui-form-label"><span class="x-red">*</span>读者类型</label>
		                      <div class="layui-input-block">
		                        <input type="radio" value="普通读者" name="typename" lay-skin="primary" title="普通读者" >
		                        <input type="radio" value="高级读者" name="typename" lay-skin="primary" title="高级读者" checked="checked">
		                        <input type="radio" value="老师" name="typename" lay-skin="primary" title="老师">
		                      </div>
	                     </div>
                  </c:if>
                  <c:if test="${reader.typename=='老师' }">
	                      <div class="layui-form-item">
	                          <label class="layui-form-label"><span class="x-red">*</span>读者类型</label>
		                      <div class="layui-input-block">
		                        <input type="radio" value="普通读者" name="typename" lay-skin="primary" title="普通读者" >
		                        <input type="radio" value="高级读者" name="typename" lay-skin="primary" title="高级读者">
		                        <input type="radio" value="老师" name="typename" lay-skin="primary" title="老师" checked="checked">
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
                    					       <c:if test="${dept.name==reader.dept }">
                   					          <option value="${dept.name }" selected="selected">${dept.name }</option>
                    					       </c:if>
                    					       <c:if test="${dept.name!=reader.dept }">
                    					          <option value="${dept.name }">${dept.name }</option>
                    					       </c:if>
                    					    </c:forEach>
                    					</select>
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                                                              读者所在系部
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                          <span class="x-red">*</span>联系电话
                      </label>
                      <div class="layui-input-inline">
                          <input type="text"  name="phone" value="${reader.phone }" id="inputPhone"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为读者的联系电话
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
        	var inputAge=$("#inputAge").val(); 
        	var inputPhone=$("#inputPhone").val();       	
        	if(inputName ==null || inputName == ''){
        		alert("读者姓名为空"); 
        		return false;
        	}else if(inputName.length<2 || inputName.length>6){
        		alert("读者姓名为2到6位"); 
        		return false;
        	}else if(inputAge ==null || inputAge == ''){
        		alert("读者年龄为空"); 
        		return false;
        	}else if(inputAge.length<1 || inputAge.length>2){
        		alert("年龄长度为1到2位"); 
        		return false;
        	}else if(inputPhone ==null || inputPhone == ''){
        		alert("手机号码为空"); 
        		return false;
        	}else if(!(/^1[34578]\d{9}$/.test(inputPhone))){
        		alert("手机号码有误，请重填"); 
        		return false;
        	}else{
        		alert("修改成功");
        		return true;
        		
        	}	     	        		 
        }   
        </script>
        
    </body>

</html>
