<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>读者信息查询与修改页面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <!-- <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" /> -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css"> 
       <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
        <script src="<%=request.getContextPath()%>/js/comm.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pag.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loading.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cover.css" />
	<script src="${pageContext.request.contextPath }/js/pag.js"></script>
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">读者信息管理</a>
            <a>
              <cite>读者信息查询与修改</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                           <form class="layui-form layui-col-space5" id="searchReaderForm" onsubmit="return false" action="##" method="post">
                                <!-- <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div> -->
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" id="inputReaderkey" name="readerkey"  placeholder="请输入读者编号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  onclick="showReader(1);"><i class="layui-icon">&#xe615;</i></button>
                                </div> 
                            </form>                        
                        </div>
                        
                       
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <!--  <th>
                                    <input type="checkbox" name=""  lay-skin="primary">
                                  </th> -->
                                  <th>读者编号</th>
                                  <th>读者类型</th>
                                  <th>读者姓名</th>
                                  <th>性别</th>
                                  <th>所在系部</th>
                                  <th>修改</th>
                                  <th>删除</th>
                              </thead>
                              <tbody id="tbody">
                                
                              </tbody>
                              <tfoot>
							      	<tr>
								        <td colspan="11"><div class="box" id="box"></div></td>								        
								    </tr>
								    
							   </tfoot>	
                            </table>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      layui.use(['jquery', 'layer','laydate','form'], function(){
    	  var $ = layui.$; //重点处
          var layer = layui.layer;
          var laydate = layui.laydate;
          var form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
      
      $(function(){
      	loading(1);
      });
      
      
      function loading(pagenum){
      	$.ajax({
      		type:"POST",
      		url:"${pageContext.request.contextPath}/reader/selectReaderList.do",
      		dataType:"json",
      		data:{
      			pagenum:pagenum
      		},
      		success:function(data){
      			console.log(data);
      			/*totalData 总数据 totalPage 总页数*/
      			/* pagenum == 1 的时候，才需要对分页插件进行初始化 */
      			if( pagenum == 1){
      				paging(data.totalData,data.totalPage,pagenum);
      			}      			
      			displayData(data.tReader);
      		},
      		error:function(){
      			alert("读者信息获取失败！");
      		}
      	});
      }
      
      function paging(totalData,totalPage,pagenum){
      	$('#box').paging({
              initPageNo: pagenum, // 初始页码
              totalPages: totalPage, //总页数
              totalCount: '合计' + totalData + '条数据', // 条目总数
              slideSpeed: 600, // 缓动速度 单位毫秒
              jump: true, //是否支持跳转
              callback: function(page) { 
              	// 回调函数
              }
          });
      }

      function JumpToPage(pagenum){
      	loading(pagenum);
      }
      
      function displayDataForOne(data){
      	var str="";
      	var tbody = window.document.getElementById("tbody");	
      	str += '<tr>'+
      	   /* '<td><input type="checkbox" name=""  lay-skin="primary"></td>'+  */
	       '<td>'+data.readerkey+'</td>'+
	       '<td>'+data.typename+'</td>'+		       		     		       
	       '<td>'+data.name+'</td>'+
	       '<td>'+data.sex+'</td>'+
	       '<td>'+data.dept+'</td>'+
	       '<td class="td-manage">'+
	       '<div class="layui-card-header">'+
	       '<button class="layui-btn" onclick="xadmin.open('+"'修改读者信息'"+','+"'${pageContext.request.contextPath}/reader/showReaderDetail.do?readerkey="+data.readerkey+"'"+',600,400)">'+
	       '<i class="layui-icon"></i>修改</button></div></td>'+ 
	       '<td><a title="删除" onclick="member_del(this,'+data.readerkey+')" href="javascript:;"><i class="layui-icon">&#xe640;</i></a></td>'+   
	       '</tr>';
      	tbody.innerHTML = str;
      }
      
      function displayData(data){
      	var str="";
      	var tbody = window.document.getElementById("tbody");
      	for( i in data ){	
      		str += '<tr>'+
      		       /* '<td><input type="checkbox" name=""  lay-skin="primary"></td>'+  */                       
      		       '<td>'+data[i].readerkey+'</td>'+
      		       '<td>'+data[i].typename+'</td>'+		       		     		       
      		       '<td>'+data[i].name+'</td>'+
      		       '<td>'+data[i].sex+'</td>'+
      		       '<td>'+data[i].dept+'</td>'+
      		       '<td class="td-manage">'+
      		       '<div class="layui-card-header">'+
      		       '<button class="layui-btn" onclick="xadmin.open('+"'修改读者信息'"+','+"'${pageContext.request.contextPath}/reader/showReaderDetail.do?readerkey="+data[i].readerkey+"'"+',600,400)">'+
      		       '<i class="layui-icon"></i>修改</button></div></td>'+ 
      		       '<td><a title="删除" onclick="member_del(this,'+data[i].readerkey+')" href="javascript:;"><i class="layui-icon">&#xe640;</i></a></td>'+   
      		       '</tr>';
      	}
      	tbody.innerHTML = str;
      }
      
      function showReader(pagenum){
      	  var inputReaderkey=$("#inputReaderkey").val();
      	if(inputReaderkey==null || inputReaderkey==''){
    		alert("请输入读者编号");
    	}else{
    		 //发异步查询数据
            $.ajax({
                url:"${pageContext.request.contextPath }/reader/selectReaderByKey.do" , // 请求路径
                type:"POST" , //请求方式
                dataType:"json",
                data:{
        			pagenum:pagenum
        		},
                data:$('#searchReaderForm').serialize(),
                success:function (data) {  
                	if( pagenum == 1){
        				paging(data.totalData,data.totalPage,pagenum);
        			} 
                	displayData(data.tReader);
                	$("#inputReaderkey").val('');
                }
            });
    	}
      	 
        }


      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
        	  //发异步删除数据
              $.ajax({
                  url:"${pageContext.request.contextPath }/reader/delReader.do" , // 请求路径
                  type:"POST" , //请求方式
                  dataType:"json",
                  data:{
                	  readerkey:id
          		  },
                  success:function (obj) {         	  
                      $(obj).parents("tr").remove();
                      alert("删除成功")
                      parent.location.reload();
                  }
              });
             
          });
      }

      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
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
