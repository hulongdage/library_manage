<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <%-- <script src="<%=request.getContextPath()%>/js/jquery.js"type="text/javascript"></script> --%>
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>

 
<script src="<%=request.getContextPath()%>/js/comm.js"type="text/javascript"></script>
		<link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
        	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/font-awesome.min.css" />
        <link href="${pageContext.request.contextPath }/assets/css/codemirror.css" rel="stylesheet">
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath }/assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath }/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/respond.min.js"></script>
		<![endif]-->
        		<!--[if !IE]> -->
		        
		<!-- <![endif]-->
           	<script src="${pageContext.request.contextPath }/assets/dist/echarts.js"></script>
        <script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>            
       <title></title>    
     <!-- jia  -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css"rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/pic.css"> 
       

				
		    
		<script>
			$(function() {
				new ZoomPic("jswbox");
		
			});
		</script>      
       
   
       <!--  -->
       </head>		
<body>
<div class="page-content clearfix">
 <div class="alert alert-block alert-success">
  <button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>
  <i class="icon-ok green"></i>欢迎使用<strong class="green">萍乡学院图书借阅管理系统<small>(v1.2)</small></strong>
 </div>
 <div class="state-overview clearfix">
               
			<div class="span9">
			 	<div id="jswbox"> 
					<pre class="prev">prev</pre>
					<pre class="next">next</pre>
					<ul>
	<li style="display: block; width: 262px; height: 300px; left: 0px;   z-index: 1; top: 152px; "><img src="<%=request.getContextPath()%>/images/c.jpg"  style="opacity: 87; "></li>
    <li style="display: block; width: 262px; height: 389px; left: 0px;   z-index: 2; top: 152px;"><img src="<%=request.getContextPath()%>/images/java.jpg"  style="opacity: 87; "></li>
    <li style="display: block; width: 262px; height: 389px; left: 200px; z-index: 3; top: 152px;"><img src="<%=request.getContextPath()%>/images/jsj.jpg"  style="opacity: 87; "></li>
    <li style="display: block; width: 320px; height: 389px; left: 388px; z-index: 4; top: 124px; "><img src="<%=request.getContextPath()%>/images/jsjjc.gif"  style="opacity: 87; "></li>
    <li style="display: block; width: 262px; height: 389px; left: 668px; z-index: 3; top: 152px; "><img src="<%=request.getContextPath()%>/images/sjjg.jpg"  style="opacity: 87; "></li>
    <li style="display: block; width: 262px; height: 389px; left: 834px; z-index: 2; top: 152px; "><img src="<%=request.getContextPath()%>/images/jsjwl.jpg"  style="opacity: 87; "></li>
    
					
					</ul>
				</div>

</body>
</html>
<script type="text/javascript">
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.no-radius').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});
     $(document).ready(function(){
		 
		  $(".t_Record").width($(window).width()-640);
		  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
		 $(".t_Record").width($(window).width()-640);
		});
 });
	 
	 
 </script>   