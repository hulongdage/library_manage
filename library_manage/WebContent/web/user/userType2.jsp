<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>      
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="formSubmit"  action="${pageContext.request.contextPath }/reader/modifyReaderType.do" method="post">
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>读者类型id
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="readertypeid" name="readertypeid"  value="${readertype.readertypeid }" 
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配读者类型id
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>读者类型名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="readertypename" name="readertypename" value="${readertype.readertypename }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配读者类型名称
                      </div>
                  </div>  
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>最大借书数量
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="maxborrownum" name="maxborrownum" value="${readertype.maxborrownum }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配最大借书数量
                      </div>
                  </div> 
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>最长借书时间
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="booklimit" name="booklimit" value="${readertype.booklimit }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配最长借书时间
                      </div>
                  </div>                                                                                  
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                      </label>
                      <input type="button"  onclick="BorrowBookFormSubmit();" class="layui-btn" value="确认">
                  </div>
              </form>
            </div>
        </div>
        <script>layui.use(['jquery', 'layer','form'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;             

            });</script>
        <script>
	       
	       function BorrowBookFormSubmit(){
	        	$("#formSubmit").submit();
	        	var index = parent.layer.getFrameIndex(window.name);
	        	parent.layer.close(index);
	        	parent.location.reload();
	        	
	        	 
	        }
              
        var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>
