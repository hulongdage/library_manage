<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
       <script src="${pageContext.request.contextPath }/js/json3.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
        <script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
       <script type="text/javascript">
       //第一种：主动加载jquery模块
       layui.use(['jquery', 'layer'], function(){ 
         var $ = layui.$ //重点处
         ,layer = layui.layer;        
         //后面就跟你平时使用jQuery一样         
       });
var dom = document.getElementById("container");
var myChart = echarts.init(dom);

//指定图表的配置项和数据	
function showChart(){
	 $.ajax({
         type: 'GET',
         url: '${pageContext.request.contextPath}/book/getBorrowbookListBetweenDay.do',
         dataType: 'json',
         success:function(data){   
        	 console.log(data);
        
        	 myChart.setOption({
        		 title : {
        		        text: '图书借阅种类分布',
        		        subtext: '近7天',
        		        x:'center'
        		    },
        		    tooltip : {
        		        trigger: 'item',
        		        formatter: "{a} <br/>{b} : {c} ({d}%)"
        		    },
        		    legend: {
        		        orient: 'vertical',
        		        left: 'left',
        		        data: data.name
        		    },
        		    series : [
        		        {
        		            name: '图书类型',
        		            type: 'pie',
        		            radius : '45%',
        		            center: ['50%', '45%'],
        		            data:data.EchartsEntitys,
        		            itemStyle: {
        		                emphasis: {
        		                    shadowBlur: 10,
        		                    shadowOffsetX: 0,
        		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
        		                }
        		            }
        		        }
        		    ]
        	 });
         	
 		},
     });	
}  
showChart();
       </script>
   </body>
</html>