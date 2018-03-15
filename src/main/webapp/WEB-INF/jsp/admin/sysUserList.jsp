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
<!-- 表单弹窗 -->
	<script type="text/html" id="addModel">
	<form id="editForm" class="layui-form modal-form" action="">
		<input name="id" type="hidden" value=""/>
		<input name="action" type="hidden" value=""/>
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
 			<div class="layui-input-block">
				<input name="animeName" placeholder="请输入名称" type="text" class="layui-input"  lay-verify="required" required />
			</div>
		</div>
		<div class="layui-form-item">
        	<label class="layui-form-label">封面</label>
        	<div class="layui-input-block">
                <input type="hidden" class="layui-input" name="animeCover" value="" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="animeCover_showPic_upload">上传显示图片</button>
                    <div class="layui-upload-list pro-pic">
                        <img class="layui-upload-img" name="animeCover" src="" >
                        <p id="animeCover_showPic_retry"></p>
                    </div>
                </div>
        	</div>
   		 </div>

		<div class="layui-form-item">
        	<label class="layui-form-label">动漫图片</label>
        	<div class="layui-input-block">
                <input type="hidden" class="layui-input" name="animeVerticalCover" value="" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="animeVerticalCover_showPic_upload">上传显示图片</button>
                    <div class="layui-upload-list pro-pic">
                        <img class="layui-upload-img" name="animeVerticalCover" src="" >
                        <p id="animeVerticalCover_showPic_retry"></p>
                    </div>
                </div>
        	</div>
   		 </div>
		<div class="layui-form-item">
			<label class="layui-form-label">播放日期</label>
 			<div class="layui-input-block">
				<input name="animePlayDate" placeholder="请输入播放日期" type="text" class="layui-input"  />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">国内播放时间</label>
 			<div class="layui-input-block">
				<input name="animePlayTime" placeholder="请输入国内播放时间" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">制作国家播放时间</label>
 			<div class="layui-input-block">
				<input name="animeOriginTime" placeholder="请输入制作国家播放时间" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">国内播放网站</label>
 			<div class="layui-input-block">
				<input name="animePlaySite" placeholder="请输入国内播放网站" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">制作国家播放电视台</label>
 			<div class="layui-input-block">
				<input name="animeOriginStation" placeholder="请输入制作国家播放电视台" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">播放集数</label>
 			<div class="layui-input-block">
				<input name="animePlayEpisode" placeholder="请输入播放集数" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">国内播放网址</label>
 			<div class="layui-input-block">
				<input name="animePlayUrl" placeholder="请输入国内播放网址" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item modal-form-footer" style="float:right;">
			<button class="layui-btn layui-btn-primary" type="button" id="btnCancel">取消</button>
			<button class="layui-btn" lay-filter="btnSubmit" lay-submit>保存</button>
		</div>
	</form>
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
			    ,url:'${baseUrl}/admin/anime/sysuser/list'
			    ,request: {
	    		   pageName: 'pageNumber', //页码的参数名称，默认：page
	    		   limitName: 'limit' //每页数据量的参数名，默认：limit
			    } 
			    ,limits:[5,10,15]
			    ,cols: [[
			      {type: 'checkbox',width:"5%",}
			      ,{field:'animeName', title:'名称',width:"10%",align:"center",unresize: true, sort: true}
			      ,{field:'animeCover', title:'封面',width:"10%",align:"center", unresize: true,templet:'#showAnimeCover'}
			      ,{field:'animeVerticalCover', title:'动漫图片',width:"10%",align:"center",templet:'#showAnimeVerticalCover'}
			      ,{field:'animePlayDate', title: '播放日期',width:"10%",align:"center", sort: true}
			      ,{field:'animePlayTime', title:'国内播放时间',width:"10%",align:"center",}
			      ,{field:'animeOriginTime', title:'制作国家播放时间',width:"8%",align:"center",}
			      ,{field:'animePlaySite', title:'国内播放网站',width:"8%",align:"center", }
			      ,{field:'animeOriginStation', title:'制作国家播放电视台', width:"8%", align:"center",}
			      ,{field:'animePlayEpisode', title:'播放集数', width:"8%", align:"center",}
			      ,{field:'animePlayUrl', title:'国内播放网址', width:"8%", align:"center",}
			      ,{title:'操作', align:'center',width:"21%",align:"center", toolbar: '#barDemo',}
			    ]]
			    ,page: true
			  });
		});
	</script> 
</html>