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
              <cite>借阅记录</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                            <input type="hidden" id="loadNum" value=1>                               
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="selectSafe(1)"><i class="layui-icon"></i>未超期</button>
                            <button class="layui-btn layui-btn-danger" onclick="selectDanger(1)"><i class="layui-icon"></i>超期未归还</button>
                            <button class="layui-btn layui-btn-danger" onclick="selectReturn(1)"><i class="layui-icon"></i>已归还</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>                                 
                                  <!-- <th>ID</th> -->
                                  <th>ISBN</th> 
                                  <th>书名</th>
                                  <th>读者编号</th> 
                                  <th>读者姓名</th>                               
                                  <th>读者类别</th>
                                  <th>借书日期</th>
                                  <th>归还日期</th>                                
                                  <th>罚金</th>
                                  <th>状态</th>
                                  <th>操作</th>
                              </thead>
                              <tbody id="tbody"></tbody>             	
							 	
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
    		url:"${pageContext.request.contextPath}/reader/queryAllBorrowBookList.do",
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
    			displayData(data.tBorrowbook);
    		},
    		error:function(){
    			alert("图书借阅信息获取失败！");
    		}
    	});
    }
    //查询未归还借阅记录
    function selectSafe(pagenum){
    	$("#loadNum").val(2);
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/reader/querySafeBorrowBookList.do",
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
    			displayData(data.tBorrowbook);
    		},
    		error:function(){
    			alert("未归还图书借阅信息获取失败！");
    		}
    	});
    }
    
  //查询超期借阅记录
    function selectDanger(pagenum){
    	$("#loadNum").val(3);
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/reader/queryDangerBorrowBookList.do",
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
    			displayData(data.tBorrowbook);
    		},
    		error:function(){
    			alert("超期借阅信息获取失败！");
    		}
    	});
    }
  
  //查询已归还借阅记录
    function selectReturn(pagenum){
    	$("#loadNum").val(4);
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/reader/queryReturnBorrowBookList.do",
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
    			displayData(data.tBorrowbook);
    		},
    		error:function(){
    			alert("已归还借阅信息获取失败！");
    		}
    	});
    }
    
    //查询图书
    function showBook(){
	  //发异步查询数据
      $.ajax({
          url:"${pageContext.request.contextPath }/book/queryByBookName.do" , // 请求路径
          type:"POST" , //请求方式
          dataType:"json",
          data:$('#searchBookForm').serialize(),
          success:function (data) {  
          	displayData(data);
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
    	var loadNum=$("#loadNum").val();
    	if(loadNum==1){
    		loading(pagenum);
    	}
    	if(loadNum==2){
    		selectSafe(pagenum);
    	}
    	if(loadNum==3){
    		selectDanger(pagenum);
    	}
    	if(loadNum==4){
    		selectReturn(pagenum);
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
    		if(data[i].realreturndate==null){
    			str += '<tr>'+       
      		  /*  '<td>'+data[i].id+'</td>'+ */
       		   '<td>'+data[i].isbn+'</td>'+
   		       '<td>'+data[i].bookname+'</td>'+		       		     		       
   		       '<td>'+data[i].readerkey+'</td>'+
   		       '<td>'+data[i].name+'</td>'+
   		       '<td>'+data[i].typename+'</td>'+
   		       '<td>'+data[i].borrowdate+'</td>'+
   		       '<td class="td-manage"> 未归还</td>'+
   		       '<td>'+data[i].fine+'</td>'+
   		       '<td>'+data[i].statename+'</td>'+
   		      /* '<td><a style="text-decoration:none" class="ml-5" onclick="returnBook(this,'+data[i].id+')" href="javascript:;">归还</a></td>'+  */                                                        		             
   		     '<td class="td-manage">'+
               '<button class="layui-btn" onclick="del(this,'+data[i].id+')">' +             
  		       '<i class="layui-icon"></i>删除</button> '+
                '</td>'+
   		      '</tr>';   
    		}else{
    			str += '<tr>'+       
      		  /*  '<td>'+data[i].id+'</td>'+ */
       		   '<td>'+data[i].isbn+'</td>'+
   		       '<td>'+data[i].bookname+'</td>'+		       		     		       
   		       '<td>'+data[i].readerkey+'</td>'+
   		       '<td>'+data[i].name+'</td>'+
   		       '<td>'+data[i].typename+'</td>'+
   		       '<td>'+data[i].borrowdate+'</td>'+
   		       '<td>'+data[i].realreturndate+'</td>'+
   		       '<td>'+data[i].fine+'</td>'+
   		       '<td>'+data[i].statename+'</td>'+
   		      /* '<td><a style="text-decoration:none" class="ml-5" onclick="returnBook(this,'+data[i].id+')" href="javascript:;">归还</a></td>'+  */                                                        		             
   		     '<td class="td-manage">'+
               '<button class="layui-btn" onclick="del(this,'+data[i].id+')">' +             
  		       '<i class="layui-icon"></i>删除</button> '+
                '</td>'+
   		      '</tr>';   
    		}
    				    		
    	}
    	tbody.innerHTML = str;
    }
    
    function modify(obj,isbn){
    	window.location.href="${pageContext.request.contextPath}/book/modifyBook.do?isbn="+isbn;
    }
    
     /*删除借阅记录*/
	 function del(obj,id) {	 
		if(confirm("确定删除吗")){
			  $.ajax({
		            type: 'POST',
		            url: '${pageContext.request.contextPath}/book/delBorrowBookById.do',
		            dataType: 'json',
		            data:{
		            	id:id
		            },
		            success:function(data){
		            	alert(data.message);
		    			window.location.reload();
		    		},
		        });
		}
	} 

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要归还吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已归还!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要归还吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('归还成功', {icon: 1});
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
