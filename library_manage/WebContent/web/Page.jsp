<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery.pager.js Test</title>
 <script src="${pageContext.request.contextPath }/js/jquery-1.8.2.js" type="text/javascript"></script>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pag.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loading.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cover.css" />
<script src="${pageContext.request.contextPath }/js/pag.js"></script>    
<script type="text/javascript">
$(function(){
	loading(1);
});

function loading(pagenum){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/user/queryUsersList.do",
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
			displayData(data.tUser);
		},
		error:function(){
			alert("用户信息获取失败！");
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

function displayData(data){
	var str="";
	var tbody = window.document.getElementById("tbody");
	for( i in data ){	
		str += '<tr class="text-c">'+
		       '<td>'+data[i].id+'</td>'+
		       '<td>'+data[i].name+'</td>'+		       		     		       
		       '<td>'+data[i].password+'</td>'+
		       '<td>'+data[i].sex+'</td>'+
		       '<td>'+data[i].dept+'</td>'+
		       '<td>'+data[i].roleid+'</td>'+
		       '<td class="f-14 td-manage">'+
		       '<a style="text-decoration:none" class="ml-5" onClick="edit(\'招聘信息编辑\',\'edit.jsp\','+data[i].id+')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'+
		       '<a style="text-decoration:none" class="ml-5" onclick="del(this,'+data[i].id+')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'+
		       '</td>'+
		       '</tr>';
	}
	tbody.innerHTML = str;
}
</script>
</head>
<body>
<div>
    <div class="mt-20">
	        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
	            <thead>
	            	<tr>
						<th scope="col" colspan="11">用户信息列表</th>
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
    	<div class="box" id="box"></div>

</body>
</html>