<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />       
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />       
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"> 
       <script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
      <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
         <script src="<%=request.getContextPath()%>/js/comm.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pag.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loading.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cover.css" />
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">修改个人信息</a>
            
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>       
        <div class="layui-form-item"> 
  <div class="layui-input-block">
  <form class="layui-form" id="updateAdminDetailForm" onsubmit="return submitForm(this);" action="${pageContext.request.contextPath }/user/updateAdminDetail.do" method="post">
  <div class="layui-form-item" style="margin-top:15px;width:500px;">
      <input type="hidden" id="userimage" name="userimage" value="${user.userimage }" />
      <input type="hidden" id="inputName" name="name"   value="${user.name }">
      <input type="hidden" name="id" value="${user.id }" />
      <label class="layui-form-label">头像</label>
      <div class="layui-upload">
      <div class="layui-upload-list">
      <div class="upload-img">
       <%-- <c:if test="${user.userimage }== null"> 
         <img class="layui-upload-img" style="width:80px;height:100px" src="${pageContext.request.contextPath }/images/moren.jpg" id="userImageDemo">
       </c:if> 
       <c:if test="${user.userimage }!=null">   --%>
         <img class="layui-upload-img" style="width:80px;height:100px" src="${user.userimage }" id="userImageDemo">
       <%-- </c:if>  --%>
      </div>
            <p id="demoText"></p>
		    <button type="button" class="layui-btn layui-btn-img" lay-verify="required" id="test1">上传头像</button>
        </div> 
    </div>
    </div>     
      <input type="hidden" name="password"  placeholder="请输入密码" autocomplete="off" class="layui-input" value="${user.password }"> 
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
                  </div>        
    <div class="layui-form-item" style="margin-top:15px;width:500px;">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-block">
        <input type="text" id="inputPhonenumber" name="phonenumber"  placeholder="请输入手机号"  class="layui-input" value="${user.phonenumber }">
      </div>  
    </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" class="layui-btn"></input>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>

  </div>
</div>               
    </body>
    <script type="text/javascript">
   layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
	  //日期
	  laydate.render({
	    elem: '#date'
	  });
	  laydate.render({
	    elem: '#date1'
	  });
  
   });
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,method:'post'
    ,url: '${pageContext.request.contextPath }/user/uploadHeadImage.do'   
    ,accept: 'file'
    ,multiple:true
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
      if(res.code==0){  
    	  $("#userimage").val(res.src);
        $('#userImageDemo').attr("src",res.src);
        $('.layui-btn-img').css({"margin-left":"104px","width":"90px","margin-top":"6px"});
        $('.layui-btn-img').text("重新上传"); 
        return layer.msg('上传成功',{time:1000});
      }
    }
  }); 
 });
 
function submitForm(){
	var inputPhonenumber=$("#inputPhonenumber").val();     	
	if(inputPhonenumber ==null || inputPhonenumber == ''){
		alert("电话号码为空");
		return false;
	}else if(!(/^1[34578]\d{9}$/.test(inputPhonenumber))){
		alert("手机号码有误，请重填"); 
		return false;
	}else{
		alert("修改成功");
		return true;
		
	}	     	        		 
}
</script>
</html>
