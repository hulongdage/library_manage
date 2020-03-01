<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
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
     <%  
        String isbn = request.getParameter("isbn");   
      %>       
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="formSubmit"  action="${pageContext.request.contextPath }/reader/borrowBook.do" method="post">
                  <input type="hidden" id="borrownum" name="borrownum">
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>ISBN
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="isbn" name="isbn"  value=<%=isbn %> 
                          autocomplete="off" class="layui-input" readonly="readonly">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配图书编号
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>读者编号
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="readerkey" name="readerkey"  onBlur="isAllowBorrowBook(this.value)"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配你的读者编号
                      </div>
                  </div>  
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>读者姓名
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="name" name="name"  readonly="readonly"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配你的读者姓名
                      </div>
                  </div> 
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>读者类型
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="typename" name="typename"  readonly="readonly"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配你的读者类型
                      </div>
                  </div>    
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>借书日期
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="borrowdate" name="borrowdate"  readonly="readonly"
                          autocomplete="off" class="layui-input">                         
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配你的借书日期
                      </div>
                  </div> 
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>还书日期
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="returndate" name="returndate"  readonly="readonly"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配你的还书日期
                      </div>
                  </div>                                                               
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                      </label>
                      <input type="button"  onclick="BorrowBookFormSubmit();" class="layui-btn" value="借阅">
                  </div>
              </form>
            </div>
        </div>
        <script>layui.use(['jquery', 'layer','form'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

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
        //日期格式化
         function dateFmt(date){
        	 var fmt=new Date(date);
        	 var year = fmt.getFullYear();
    		 var month =fmt.getMonth()+1;
    		 var date = fmt.getDate();
    		 var fmtDate=year+"-"+month+"-"+date;
    		 return fmtDate;
         }
        
         function isAllowBorrowBook(readerkey){
             	var isbn=$("#isbn").val(); 
             	$.ajax({                
                     url:"${pageContext.request.contextPath}/reader/borrowUserDetail.do",
                     type:"POST" , //请求方式
                     dataType:"json",
                     data:{
                     	readerkey:readerkey,
                     	isbn:isbn
             		},                
                     success:function (result) {                   	
                     if(result.message=="已到最大数量"){
                    	 $("#readerkey").val('');
                    	 alert("该读者借书数量已到上限,不能再借阅");
                     }else{
                    	 if(result.state==1){              		
                       		$("#readerkey").val('');
                       		alert("该读者已借阅此书,不能重复借阅");
     	                  }else{                		
     	                  		alert("该读者可以借阅此书");
     	                  		 $("#borrownum").val(result.borrowNum);
     	                  		 $("#name").val(result.data.name);
     	                		 $("#typename").val(result.data.typename);
     	                		 $("#borrowdate").val(dateFmt(result.data.borrowdate));
     	                		 $("#returndate").val(dateFmt(result.data.returndate)); 
     	                  } 
                     }
                                         	                    	
                     },
                	  error:function(){
                   			alert("无此读者信息");
                   			$("#name").val('');
                   			$("#typename").val('');
                   			$("#borrowdate").val('');
                   			$("#returndate").val('');
                   		}
                 }); 
             }
        	       	              
	       
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
