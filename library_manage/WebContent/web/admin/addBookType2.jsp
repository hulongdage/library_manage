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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/xadmin.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="formSubmit" action="${pageContext.request.contextPath }/book/updateBooktypeDetail.do" method="post">
                  <input type="hidden" name="id" value="${booktype.id }">
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>图书类别名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputTypename" name="typename" value="${booktype.typename }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>将匹配图书类别名称
                      </div>
                  </div>                
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                      </label>
                      <input type="button"  onclick="BookFormSubmit();" class="layui-btn" value="提交">
                  </div>
              </form>
            </div>
        </div>
        <script>
        layui.use(['jquery', 'layer','laydate','form'], function(){
        	  var $ = layui.$; //重点处
              var layer = layui.layer;
              var laydate = layui.laydate;
              var form = layui.form;
            
            //执行一个laydate实例
            laydate.render({
              elem: '#inputPublishdate' , //指定元素
             trigger: 'click'
            });
            
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });

            });</script>
            
        <script>
       
     
      
        function BookFormSubmit(){
        	var inputTypename=$("#inputTypename").val();

        	if(inputTypename ==null || inputTypename == ''){
        		alert("图书类别名称为空");
        		return ;
        	}
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
