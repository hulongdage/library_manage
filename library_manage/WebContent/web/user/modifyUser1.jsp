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
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"> 
      <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">基础信息维护</a>
            <a>
              <cite>修改个人信息</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">                                           
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>                                 
                                  <th>ID</th>
                                  <th>用户名称</th>
                                  <th>密码</th>
                                  <th>性别</th>
                                  <th>所在学院</th>                                
                                  <th>操作</th>
                              </thead>
                             <tbody id="tbody"></tbody>
                            </table>
                        </div>
                     
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
    layui.use(['jquery', 'layer','form'], function(){
  	    var $ = layui.$; //重点处
        var layer = layui.layer;
        var form = layui.form;
    });
      
      $(function(){
  //    	window.location.href="${pageContext.request.contextPath }/user/showModifyUser.do";
    	  $.ajax({
      		type:"GET",
      		url:"${pageContext.request.contextPath}/user/toModifyUser.do",
      		dataType:"json",     		
      		success:function(data){   
      			console.log(data);
      			displayDataForOne(data);
      		},
      		error:function(){
      			alert("用户信息获取失败！");
      		}
      	});
      }); 
      
      function displayDataForOne(data){
      	var str="";
      	var tbody = window.document.getElementById("tbody");	
      		str += '<tr>'+     	
      		       '<td>'+data.id+'</td>'+
      		       '<td>'+data.name+'</td>'+	
      		       '<td><input type="password" style="border:none" value='+data.password+'></td>'+
      		       /* '<td>'+data.password+'</td>'+ */
      		       '<td>'+data.sex+'</td>'+
      		       '<td>'+data.dept+'</td>'+
      		     '<td class="td-manage">'+
     	       	'<button class="layui-btn" onclick="xadmin.open('+"'修改个人信息'"+','+"'${pageContext.request.contextPath}/user/showUserDetail.do?id="+data.id+"'"+',600,400)">'+
     		       '<i class="layui-icon"></i>修改</button></div></td>'+     		      
      	 		      '</tr>'; 
      	tbody.innerHTML = str;
      }

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要修改吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已修改!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要修改吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('修改成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</html>
