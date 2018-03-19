<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <title>动漫世界管理系统</title>
	  <link rel="stylesheet" href="${baseResPath}/layui/css/layui.css" media="screen,projection">
	  <link type="text/css" rel="stylesheet" href="${baseResPath}/css/style.css" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
	</head>
<body>
	<div>
		<div class="demoTable">
		  输入用户名称：
		  <div class="layui-inline">
		    <input class="layui-input" type="text"  id="searchValue" autocomplete="off">
		  </div>
		  <button id="searchBtn" class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
		  <button id="addBtn" class="layui-btn"><i class="layui-icon">&#xe654;</i>添加</button>
		</div>
		
		<table id="sysUserTable" class="layui-table" lay-filter="sysUsertab"></table>
	</div>
</body>
 <script type="text/html" id="barDemo">
  	<a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
</script>
<script type="text/html" id="showPortraitCover">
  		<span class="layer-photos-demo" id="portraitCover_{{d.id}}"><img title="点击看原图" style="width: 40px" style="cursor:pointer" layer-src="{{ d.portraitUrl }}" src="{{d.portraitUrl}}" lay-event="imageEvent"><span>
</script>
	<script>
		layui.use(['layer','jquery','table','form','upload'], function(){
			var table = layui.table,
			 layer=layui.layer,
			 form =layui.form,
			 $=layui.jquery,
			 upload = layui.upload;
			 
			 table.render({
			    elem: '#sysUserTable'
			    ,url:'${baseUrl}/admin/sysuser/list'
			    ,request: {
	    		   pageName: 'pageNumber', //页码的参数名称，默认：page
	    		   limitName: 'limit' //每页数据量的参数名，默认：limit
			    } 
			    ,limits:[5,10,15]
			    ,cols: [[
			      {type: 'checkbox',width:"5%",}
			      ,{field:'loginname', title:'登录名称',width:"10%",align:"center",unresize: true}
			      ,{field:'portraitUrl', title:'头像',width:"10%",align:"center", unresize: true,templet:'#showPortraitCover'}
			      ,{field:'mobile', title:'手机号码',width:"10%",align:"center"}
			      ,{field:'nickname', title: '昵称',width:"10%",align:"center"}
			      ,{field:'gender', title:'性别',width:"10%",align:"center",}
			      ,{field:'status', title:'状态',width:"8%",align:"center",}
			      ,{field:'email', title:'邮箱',width:"8%",align:"center", }
			      ,{field:'createTimestamp', title:'创建时间戳', width:"8%", align:"center",sort: true}
			      ,{title:'操作', align:'center',width:"21%",align:"center", toolbar: '#barDemo',}
			    ]]
			    ,page: true
			  });
			  //监听工具条
		  table.on('tool(sysUsertab)', function(obj){
		    var data = obj.data;
		     if(obj.event === 'del'){
		      layer.confirm('确认删除？', function(index){
		      	layer.close(index);
				layer.load(2);
		      	$.ajax({
						type :'post',
				        url : '${baseUrl}/admin/sysuser/del',
				        dataType : 'json',
				        data :{id:data.id},
				        success :  function(json){
				        	layer.closeAll('loading');
				        	if(!json.success){
				        		layer.alert(json.data)
				        		return
				        	}else{
				        		obj.del();
				        		layer.close(index);
				        		layer.alert(json.data)
				        		return
				        	}
						}
				   });
		      });
		    } else if(obj.event === 'edit'){
		      /* layer.alert('编辑行：<br>'+ JSON.stringify(data)) */
		      if(obj.event === 'edit'){
                var editIndex = layer.open({
                    title : "编辑系统用户",
                    type : 2,
                    content : "${baseUrl}/admin/sysuser/edit?id="+data.id,
                    success : function(layer, index){
                        setTimeout(function(){
                            layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(editIndex);
                });
                layer.full(editIndex);
		      }
		    }else if(obj.event === 'imageEvent'){
		    	layer.photos({
                    photos: '#portraitCover_'+data.id,
                    anim: 5
                });
			}
		     return false;
		    });
	 });
	</script> 
</html>