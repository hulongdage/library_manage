<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  
<base href="<%=basePath%>">
    
    <title>萍乡学院图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jigsaw.css">
	
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
	body {
            padding-top: 50px;
            padding-bottom: 40px;
            color: #5a5a5a;
        }
	 /* 轮播广告 */

        .carousel {
            height: 900px;
            margin-bottom: 60px;
        }

        .carousel .item {
            height: 900px;
            background-color: #000;
        }
         .carousel .item img {
            width: 100%;
        }
         .carousel-caption {
            z-index: 10;
        }
         .carousel-caption p {
            margin-bottom: 20px;
            font-size: 20px;
            line-height: 1.8;
        }
        
          /* 简介 */

        .summary {
            padding-right: 15px;
            padding-left: 15px;
        }

        .summary .col-md-4 {
            margin-bottom: 20px;
            text-align: center;
        }
          /* 特性 */

        .feature-divider {
            margin: 40px 0;
        }

        .feature {
            padding: 30px 0;
        }

        .feature-heading {
            font-size: 50px;
            color: #2a6496;
        }

        .feature-heading .text-muted {
            font-size: 28px;
        }
        .container {
      width: 310px;
      margin: 100px auto;
    }
    input {
      display: block;
      width: 290px;
      line-height: 40px;
      margin: 10px 0;
      padding: 0 10px;
      outline: none;
      border:1px solid #c8cccf;
      border-radius: 4px;
      color:#6a6f77;
    }
    #msg {
      width: 100%;
      line-height: 40px;
      font-size: 14px;
      text-align: center;
    }
    a:link,a:visited,a:hover,a:active {
      margin-left: 100px;
      color: #0366D6;
    }
    
  
    
  

        
	</style>
  </head>
  
  <body>
  <%-- <%
	 if ((boolean)((Object)request.getParameter("error"))) {
	 %>
	 <script>
	   alert("用户名或密码错误 ！");
	 </script>
	 <%
	 }
	 %> --%>
    <!-- 顶部导航 -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="menu-nav" style="height: 50px;">
	<div id="denglu">
	
	              <div id="dao1"
     style=" 50px;
    margin-top: 10px;"
	              >
                  
                  
                <a href="#ad-carousel"><font style="color:  #999 " size="6" >萍乡学院图书管理系统</font> </a>
           
             
                <a href="#ad-carousel"><font style="color: white" size="3">首页</font></a>
                  <a href="#" data-toggle="modal" data-target="#about-modal"><font style="color: white" size="3">关于</font></a>
                   &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp;&nbsp;  &nbsp; &nbsp;  &nbsp;
               &nbsp;  &nbsp; &nbsp;  &nbsp;&nbsp;  &nbsp; &nbsp;  &nbsp;&nbsp;  &nbsp; &nbsp;  &nbsp;
                 <a href="#" data-toggle="modal" data-target="#login"><font style="color: white" size="3">登录</font> </a> 
                 
                  
                  </div>
	
	
	</div>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- <a class="navbar-brand" href="#">萍乡学院图书管理系统</a> -->
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
               
               
            </ul>
           
        </div>
    </div>
</div>
		
		<!-- 广告轮播 -->
		<div id="ad-carousel" class="carousel slide" data-ride="carousel">
		    <ol class="carousel-indicators">
		        <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
		        <li data-target="#ad-carousel" data-slide-to="1"></li>
		        <li data-target="#ad-carousel" data-slide-to="2"></li>
		        <li data-target="#ad-carousel" data-slide-to="3"></li>
		        <li data-target="#ad-carousel" data-slide-to="4"></li>
		    </ol>
		    <div class="carousel-inner">
		        <div class="item active">
		            <img src="images/33.jpg" alt="1 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <!--  <h1>JAVA编程语言</h1>
		
		                    <p>Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。</p> 
		
		                   <p><a class="btn btn-lg btn-primary" href="http://www.google.cn/intl/zh-CN/chrome/browser/"
		                          role="button" target="_blank">立即借阅</a></p>  -->
		                </div>
		            </div>
		        </div>
		        
		        
		        <div class="item">
		            <img src="images/22.jpg" alt="2 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <!-- <h1>Linux操作系统</h1>
		
		                    <p>Linux是一套免费使用和自由传播的类Unix操作系统，是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。</p>
		
		                    <p><a class="btn btn-lg btn-primary" href="http://www.firefox.com.cn/download/" target="_blank"
		                          role="button">立即借阅</a></p> -->
		                </div>
		            </div>
		        </div>
		        <div class="item">
		            <img src="images/11.jpg" alt="3 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <!-- <h1>Photoshop</h1>
		
		                    <p>Photoshop主要处理以像素所构成的数字图像。使用其众多的编修与绘图工具，可以有效地进行图片编辑工作。ps有很多功能，在图像、图形、文字、视频、出版等各方面都有涉及。</p>
		
		                    <p><a class="btn btn-lg btn-primary" href="http://www.apple.com/cn/safari/" target="_blank"
		                          role="button">立即借阅</a></p> -->
		                </div>
		            </div>
		        </div>
		        <div class="item">
		            <img src="images/11.jpg" alt="4 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                   <!--  <h1>软件测试</h1>
		
		                    <p>软件测试（英语：Software Testing），描述一种用来促进鉴定软件的正确性、完整性、安全性和质量的过程。</p>
		
		                    <p><a class="btn btn-lg btn-primary" href="http://www.opera.com/zh-cn" target="_blank"
		                          role="button">立即借阅</a></p> -->
		                </div>
		            </div>
		        </div>
		        <div class="item">
		            <img src="images/22.jpg" alt="5 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <!-- <h1>web编程</h1>
		
		                    <p>超文本标记语言（标准通用标记语言下的一个应用、外语缩写：HTML）可以规定网页中信息陈列格式，指定需要显示的图片，嵌入其他浏览器支持的描述性语言，以及指定超文本连接对象，如其他网页、JAVA、CGI程序等。</p>
		
		                    <p><a class="btn btn-lg btn-primary" href="http://ie.microsoft.com/" target="_blank"
		                          role="button">立即借阅</a></p> -->
		                </div>
		            </div>
		        </div>
		    </div>
		    <a class="left carousel-control" href="#ad-carousel" data-slide="prev"  
    style="width:  0px;"
		    ><span
		            class="glyphicon glyphicon-chevron-left"></span></a>
		    <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
		            class="glyphicon glyphicon-chevron-right"></span></a>
		</div>

<!-- 主要内容 -->
<div class="container summary">
    <!-- 关于 -->
    <div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label">关于</h4>
                </div>
                <div class="modal-body">
                    <p>图书馆收藏着大量的文献信息资源，积极地开发，广泛地利用这些文献资源是图书馆的重要职能之一，它也是图书馆承担各种职能的基础。由于当今社会文献的生产数量大、增长快；社会文献的类型复杂、形式多样; 文献的时效性强；文献的传播速度加快;文献的内容交叉重复；文献所用语种在扩大，质量下降等特点,使人们普遍感到利用起来十分不容易。图书馆通过对文献信息资源进行加工整理、科学分析综合指引，形成有秩序、有规律、源源不断的信息流，进行更加广泛的交流与传递，使读者更好地利用它们。图书馆的文献资源开发包括下面几项内容：第一，对到馆的文献进行验收、登记、分类、编目、加工，最后调配到各借阅室，以便科学排架，合理的流通；第二，对馆外文献信息资源进行搜索、过滤，成为虚拟馆藏，形成更加宽广、快捷的信息通道；第三，通过最现代化的手段—计算机网络操作技术使馆藏文献走向数字化。</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">了解了</button>
                </div>
            </div>
        </div>
    </div>
    
     <!-- 登录 -->
    
    <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="modal-label"aria-hidden="true"    >
         
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label" align="center">用户登录</h4>
                </div>
                
                <div class="modal-body">
                  <c:if test="${param.error }">
                     <span style="color:red" >用户名或密码错误</span>
                  </c:if> 
                   <form class="form-horizontal" id="loginForm" role="form" method="post" action='${pageContext.request.contextPath }/login'>
							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label" style="margin-top: 10px;">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="firstname" name="username"placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label" style="margin-top: 10px;">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="lastname" name="password"placeholder="请输入密码">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">滑动验证</label>
								<div class="col-sm-10">
									<div id="captcha" style="position: relative"></div>
								</div>
							</div>

                            <!-- <div id="msg"></div> -->
							<!-- <div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success" >登录</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div> -->
					</form>
                </div>
              
            </div>
        </div>
    </div>
    
    <footer>
        <p class="pull-right"><a href="#top">回到顶部</a></p>

        <p>&copy; 2018 江西省萍乡市萍乡学院 </p>
    </footer>

</div>
<script>
    $(function () {
        $('#ad-carousel').carousel();
        $('#menu-nav .navbar-collapse a').click(function (e) {
            var href = $(this).attr('href');
            var tabId = $(this).attr('data-tab');
            if ('#' !== href) {
                e.preventDefault();
                $(document).scrollTop($(href).offset().top - 70);
                if (tabId) {
                    $('#feature-tab a[href=#' + tabId + ']').tab('show');
                }
            }
        });
    });
</script>
<script src="${pageContext.request.contextPath}/js/jigsaw.js"></script>
	<script>
	  jigsaw.init(document.getElementById('captcha'), function () {
	    $("#loginForm").submit();
	  })
	</script>
  </body>
</html>
