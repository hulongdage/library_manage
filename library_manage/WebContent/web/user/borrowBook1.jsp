<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
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
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">图书借阅管理</a>
            <a>
              <cite>图书借阅</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" id="searchBookForm" onsubmit="return false" action="##" method="post">
                                <input type="hidden" id="loadNum" value=1>
                                <input type="hidden" id="inputPagenum" name="pagenum" >
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" id="requireBookname" name="bookname" required="required"  placeholder="请输入图书名称" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  onclick="showBook(1);"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>                      
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>                                                             
                                <th>图书编号</th>
                    			<th>图书类型</th>
                    			<th>书名</th>
                    			<th>作者</th>
                    			<th>出版社</th>
                    			<th>出版时间</th>
                    			<th>印刷次数</th>
                    			<th>图书价格</th>
                    			<th>库存数量</th>
                                <th>操作</th>
                                </tr>
                              </thead>
                              <tbody id="tbody"></tbody>             	
							 	
							   <tfoot>
							      	<tr>
								        <td colspan="11"><div class="box" id="box"></div></td></td>
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
      		url:"${pageContext.request.contextPath}/book/queryBookList.do",
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
      			displayData(data.tBook);
      		},
      		error:function(){
      			alert("图书信息获取失败！");
      		}
      	});
      }
      //查询图书
      function showBook(pagenum){
    	  $("#loadNum").val(2);
    	var requireBookname = $("#requireBookname").val();
    	if(requireBookname==null || requireBookname==''){
    		alert("请输入图书名称");
    	}else{
    		$("#inputPagenum").val(pagenum);
    		//发异步查询数据
            $.ajax({
                url:"${pageContext.request.contextPath }/book/queryByBookName.do" , // 请求路径
                type:"POST" , //请求方式
                dataType:"json",
                data:{
          			pagenum:pagenum
          		  },
                data:$('#searchBookForm').serialize(),
                success:function (data) {  
                	if( pagenum == 1){
        				paging(data.totalData,data.totalPage,pagenum);
        			  }      			
                	displayData(data.tBook);               
                },
          		error:function(){
          			alert("图书信息获取失败！");
          		}
            });
    	}
  	  
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
    	  var loadNum=$("#loadNum").val();
  		if(loadNum==1){
  			loading(pagenum);
  		}
  		if(loadNum==2){
  			showBook(pagenum);
  		}
      }
      
      function selectBook(){
      	var BName=$("#selectBookName").val();
      	selctBookAjax(BName);
      }
      

      function displayData(data){
      	var str="";
      	var tbody = window.document.getElementById("tbody");
      	for( i in data ){	
      		if(data[i].num<=0){
      			str += '<tr>'+
       		   '<td>'+data[i].isbn+'</td>'+
   		       '<td>'+data[i].typename+'</td>'+		       		     		       
   		       '<td>'+data[i].bookname+'</td>'+
   		       '<td>'+data[i].author+'</td>'+
   		       '<td>'+data[i].publish+'</td>'+
   		       '<td>'+data[i].publishdate+'</td>'+
   		       '<td>'+data[i].printnum+'</td>'+
   		       '<td>'+data[i].unitprice+'</td>'+
   		       '<td>'+data[i].num+'</td>'+
   		       '<td class="td-manage"> 库存不足</td>'+                                                          		             
       		   '</tr>';
      		}else{
      			str += '<tr>'+
       		   '<td>'+data[i].isbn+'</td>'+
   		       '<td>'+data[i].typename+'</td>'+		       		     		       
   		       '<td>'+data[i].bookname+'</td>'+
   		       '<td>'+data[i].author+'</td>'+
   		       '<td>'+data[i].publish+'</td>'+
   		       '<td>'+data[i].publishdate+'</td>'+
   		       '<td>'+data[i].printnum+'</td>'+
   		       '<td>'+data[i].unitprice+'</td>'+
   		       '<td>'+data[i].num+'</td>'+
   		       '<td class="td-manage">'+
                '<button class="layui-btn" onclick="xadmin.open('+
             	"'借阅图书','./borrowBook2.jsp?isbn="+data[i].isbn+"',600,400)"   +
                 '">' +
   		       '<i class="layui-icon"></i>借阅</button> '+
                 '</td>'+  		             
       		   '</tr>';
      		}
      		
      	}
      	tbody.innerHTML = str;
      }
      
      function modify(obj,isbn){
      	window.location.href="${pageContext.request.contextPath}/book/modifyBook.do?isbn="+isbn;
      }
      
      
  	/*图书删除*/
  	function del(obj,isbn) {	 
  		if(confirm("确定删除吗")){
  			  $.ajax({
  		            type: 'POST',
  		            url: '${pageContext.request.contextPath}/book/deleteBook.do',
  		            dataType: 'json',
  		            data:{
  		            	isbn:isbn
  		            },
  		            success:function(data){
  		            	console.log(data.message);
  		    			window.location.reload();
  		    		},
  		        });
  		}
  	}

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
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
