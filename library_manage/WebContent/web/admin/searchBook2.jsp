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
                <form class="layui-form" id="formSubmit"  action="${pageContext.request.contextPath }/book/updateBookDetail.do" method="post">
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>ISBN
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputISBN" name="isbn" value="${book.isbn }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>将匹配图书编号
                      </div>
                  </div>
                <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>书名
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputBookname" name="bookname" value="${book.bookname }"
                          autocomplete="off" class="layui-input">
                      </div>
                        <div class="layui-form-mid layui-word-aux">
                               <span class="x-red">* </span>将匹配图书名称
                      </div>
                  </div> 
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>图书种类
                      </label>
                      <div class="layui-input-inline">
                       
                    					<select id="bookTypeList" name="typename">
                    					    <c:forEach var="bookType" items="${bookTypeList }">	                    					     
                    					       <c:if test="${bookType.typename==book.typename }">
                    					          <option value="${bookType.typename }" selected="selected">${bookType.typename }</option>
                    					       </c:if>
                    					       <c:if test="${bookType.typename!=book.typename}">
                    					          <option value="${bookType.typename}">${bookType.typename}</option>
                    					       </c:if>
                    					    </c:forEach>
                    					</select>
                      </div>
                        <div class="layui-form-mid layui-word-aux">
                                <span class="x-red">* </span> 将匹配图书种类名称                
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>作者
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputAuthor" name="author" value="${book.author }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配作者名称
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label"><span class="x-red">*</span>出版社</label>
                        <div class="layui-input-inline">
                          <input type="text" id="inputPublish" name="publish" value="${book.publish }"
                          autocomplete="off" class="layui-input">
                          <!-- <input type="password" id="inputPublish" name="publish" required="" lay-verify="pass"
                          autocomplete="off" class="layui-input"> -->
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配出版社名称
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_pass" class="layui-form-label">
                          <span class="x-red">*</span>出版时间
                      </label>
                      <div class="layui-input-inline">
                      <input type="hidden" id="inputHiddenPublishdate"   value="${book.publishdate }">
                         
                          <input type="text" id="inputPublishdate" name="publishdate"  value="${book.publishdate }"
                           class="layui-input">
                      </div>
                               
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配出版时间
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                          <span class="x-red">*</span>价格
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputUnitprice" name="unitprice" value="${book.unitprice }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配价格
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                          <span class="x-red">*</span>印刷次数
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputPrintnum" name="printnum" value="${book.printnum }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配印刷次数
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                          <span class="x-red">*</span>库存数目
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="inputNum" name="num" value="${book.num }"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将匹配库存数目
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
        $(function(){
        	var inputHiddenPublishdate=$("#inputHiddenPublishdate").val();
        	$("#inputPublishdate").val(dateFmt(inputHiddenPublishdate));
        	
          });
      //日期格式化
        function dateFmt(date){
       	 var fmt=new Date(date);
       	 var year = fmt.getFullYear();
   		 var month =fmt.getMonth()+1;
   		 var date = fmt.getDate();
   		 var fmtDate=year+"-"+month+"-"+date;
   		 return fmtDate;
        }
      
      
        function BookFormSubmit(){
        	var inputISBN=$("#inputISBN").val();
        	var inputBookname=$("#inputBookname").val(); 
        	var inputAuthor=$("#inputAuthor").val();
        	var inputPublish=$("#inputPublish").val();
        	var inputPublishdate=$("#inputPublishdate").val();
        	var inputUnitprice=$("#inputUnitprice").val();
        	var inputPrintnum=$("#inputPrintnum").val();
        	var inputNum=$("#inputNum").val();

        	if(inputISBN ==null || inputISBN == ''){
        		alert("图书编号为空");
        		return ;
        	}
        	if(inputBookname ==null || inputBookname == ''){
        			alert("图书名称为空");
        			return ;
        	}
        	if(inputAuthor ==null || inputAuthor == ''){
    			alert("作者名称为空");
    			return ;
    	    }     
        	if(inputPublish ==null || inputPublish == ''){
    			alert("出版社名称为空");
    			return ;
    	    }
        	if(inputPublishdate ==null || inputPublishdate == ''){
    			alert("出版日期为空");
    			return ;
    	    }
        	if(inputUnitprice ==null || inputUnitprice == ''){
    			alert("图书价格为空");
    			return ;
    	    }
        	if(inputPrintnum ==null || inputPrintnum == ''){
    			alert("印刷次数为空");
    			return ;
    	    }
        	if(inputNum ==null || inputNum == ''){
    			alert("库存数量为空");
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
