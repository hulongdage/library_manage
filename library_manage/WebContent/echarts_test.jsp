<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
    <head>
        <meta charset="UTF-8">
        <title>后台登录-X-admin2.2</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
    </head>
    <body>
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="main" style="width: 100%;height:400px;"></div>         
        
        <script type="text/javascript">
      //第一种：主动加载jquery模块
        layui.use(['jquery', 'layer'], function(){ 
          var $ = layui.$ //重点处
          ,layer = layui.layer;
          
          //后面就跟你平时使用jQuery一样
          
        });
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
     //   myChart.showLoading();
        
        // 指定图表的配置项和数据	
            function showChart(){
            	 $.ajax({
 		            type: 'GET',
 		            url: '${pageContext.request.contextPath}/book/getBookListByBorrowNum.do',
 		            dataType: 'json',
 		            success:function(data){
 		         //   	myChart.hideLoading();
 		            	myChart.setOption({
 		        	        title: {
 		        	            text: '异步数据加载示例'
 		        	        },
 		        	        tooltip: {},
 		        	        legend: {
 		        	            data:['图书借阅次数']
 		        	        },
 		        	        xAxis: {
 		        	            data: data.bookName
 		        	        },
 		        	        yAxis: {},
 		        	        series: [{
 		        	            name: '图书借阅次数',
 		        	            type: 'bar',
 		        	            data: data.borrownum
 		        	        }]
 		        	    });
 		    		},
 		        });	
        }  
 			 
            showChart();
      
    	    
    	

        // 使用刚指定的配置项和数据显示图表。
     //   myChart.setOption(option);
    </script>
    </body>
</html>