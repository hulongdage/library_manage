<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"> 
       <script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
      <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
         <script src="<%=request.getContextPath()%>/js/comm.js" type="text/javascript"></script>
<title>Insert title here</title>

</head>
<body>
</body>
<script type="text/javascript">
layui.use(['jquery', 'layer','laydate','form'], function(){
	  var $ = layui.$; //重点处
      var layer = layui.layer;
      var laydate = layui.laydate;
      var form = layui.form;
  });
$(function(){ 	
	parent.location.reload();
});
 
</script>
</html>