<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/font-awesome.min.css" />       		       
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"/> 
        <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"/> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"/>
        <script src="<%=request.getContextPath()%>/js/comm.js" type="text/javascript"></script>
       </head>		
<body>
<div class="layui-carousel" id="test1">
  <div carousel-item>
    <div><img src="<%=request.getContextPath()%>/images/11.jpg"  style="opacity: 87;"/></div>
    <div><img src="<%=request.getContextPath()%>/images/22.jpg"  style="opacity: 87;"/></div>
    <div><img src="<%=request.getContextPath()%>/images/33.jpg"  style="opacity: 87;"/></div>
  </div>
</div>
<!-- 条目中可以是任意内容，如：<img src=""> -->
 
<script>
layui.use('carousel', function(){
  var carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
    ,height:'500px'
    ,arrow: 'always' //始终显示箭头
    //,anim: 'updown' //切换动画方式
  });
});
</script>
</body>
</html>
 