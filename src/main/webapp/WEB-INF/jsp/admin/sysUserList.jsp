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
		      	showEditModel(data)
		    }else if(obj.event === 'imageEvent'){
		    	layer.photos({
                    photos: '#portraitCover_'+data.id,
                    anim: 5
                });
			}
		  });
		//显示表单弹窗
			function showEditModel(data){
				var index =layui.layer.open({
		                title : data==null ? "添加系统用户信息" :"修改系统用户信息",
		                type : 1,
		                maxmin: true,
		                content : $("#addModel").html(),
		                success : function(layer,index){
		                    setTimeout(function(){
		                        layui.layer.tips('这里是关闭窗口', '.layui-layer-setwin .layui-layer-close', {
		                            tips: 3
		                        });
		                    },500)
		                }
		            });
		         $("#editForm")[0].reset();
				 $("#editForm").attr("method","POST");
				 $("#editForm input[name=action]").val("ADD");
				 if(data!=null){
				 	$("#editForm input[name=id]").val(data.id);
				 	$("#editForm input[name=action]").val("MODIFY");
					$("#editForm input[name=animeName]").val(data.animeName);
					$("#editForm input[name=animeCover]").val(data.animeCover);
					$("#editForm img[name=animeCover]").attr("src",data.animeCover);
					$("#editForm input[name=animeVerticalCover]").val(data.animeCover);
					$("#editForm img[name=animeVerticalCover]").attr("src",data.animeVerticalCover);
					$("#editForm input[name=animePlayDate]").val(data.animePlayDate);
					$("#editForm input[name=animePlayTime]").val(data.animePlayTime);
					$("#editForm input[name=animeOriginTime]").val(data.animeOriginTime);
					$("#editForm input[name=animePlaySite]").val(data.animePlaySite);
					$("#editForm input[name=animeOriginStation]").val(data.animeOriginStation);
					$("#editForm input[name=animePlayEpisode]").val(data.animePlayEpisode);
					$("#editForm input[name=animePlayUrl]").val(data.animePlayUrl);
				}
				 layui.layer.full(index);
	           	$(window).on("resize",function(){
	                layui.layer.full(index);
	            })
	           	 //普通图片上传
	             var upload_showPic = layui.upload.render({
	                 elem: '#animeCover_showPic_upload',
	                 url: '${baseUrl}/file/uploadPic?directory=PORTRAIT',
	                 field:'photo',
	                 before: function(obj){
	                     //预读本地文件示例，不支持ie8
	                     obj.preview(function(index, file, result){
	                         $("#editForm img[name=animeCover]").attr("src",result);//图片链接（base64）
	                     });
	                     imageIndex = layer.load(2, {
	                         shade: [0.3, '#333']
	                     });
	                 },
	                 done: function(json){
	                     layer.close(imageIndex);
	                     //如果上传失败
	                     if(!json.success){
	                         return layer.msg(json.data);
	                     }
	                     $("#editForm input[name=animeCover]").val(json.data);
	                 },
	                 error: function(){
	                     //演示失败状态，并实现重传
	                     var demoText = $('#animeCover_showPic_retry');
	                     demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
	                     demoText.find('.demo-reload').on('click', function(){
	                         upload_showPic.upload();
	                     });
	                 }
	             });
	           
	           	 $("#btnCancel").click(function(){
	           		layui.layer.closeAll('page');
				});
			}
		});
	</script> 
</html>