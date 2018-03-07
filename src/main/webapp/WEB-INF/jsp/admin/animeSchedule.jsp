<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html>
<html>
     <body>
     <head>
	  <title>开始使用layui</title>
	  <link rel="stylesheet" href="${baseResPath}/layui/css/layui.css" media="screen,projection">
	  <link type="text/css" rel="stylesheet" href="${baseResPath}/css/style.css" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
	</head>
	<div>
		<div class="demoTable">
		  输入动漫名称：
		  <div class="layui-inline">
		    <input class="layui-input" type="text"  id="searchValue" autocomplete="off">
		  </div>
		  <button id="searchBtn" class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
		  <button id="addBtn" class="layui-btn"><i class="layui-icon">&#xe654;</i>添加</button>
		</div>
		
		<table id="animeTable" class="layui-table" lay-filter="animetab"></table>
	</div>
    </body>
    <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	
	<script type="text/html" id="showAnimeCover">
  		<span class="layer-photos-demo" id="animeCover_{{d.id}}"><img title="点击看原图" style="width: 40px" style="cursor:pointer" layer-src="{{ d.animeCover }}" src="{{d.animeCover}}" lay-event="imageEvent"><span>
	</script>
	
	<script type="text/html" id="showAnimeVerticalCover">
  		<span class="layer-photos-demo" id="animeVerticalCover_{{d.id}}"><img title="点击看原图" style="width: 40px" style="cursor:pointer" layer-src="{{ d.animeVerticalCover }}" src="{{d.animeVerticalCover}}" lay-event="imageEvent"><span>
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
			    elem: '#animeTable'
			    ,url:'${baseUrl}/anime/schedule/list'
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
			  
			 //监听工具条
		  table.on('tool(animetab)', function(obj){
		    var data = obj.data;
		     if(obj.event === 'del'){
		      layer.confirm('确认删除？', function(index){
		      	layer.close(index);
				layer.load(2);
		      	$.ajax({
						type :'post',
				        url : '${baseUrl}/anime/schedule/del',
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
                    photos: '#animeCover_'+data.id,
                    anim: 5
                });
			}
		  });
		 
		//搜索按钮点击事件
		$("#searchBtn").click(function(){
			var value = $("#searchValue").val();
			console.log(value)
			table.reload('animeTable', {  
       		 where: {
       		 	key: {
	            	searchValue: value
	          	}
	          }
       		});
		});
		
		
		//表单提交事件
		form.on('submit(btnSubmit)', function(data) {
			data.field._method = $("#editForm").attr("method");
			var action = $("#editForm input[name=action]").attr("value");
			layer.load(2);
			if(action === "ADD"){
				$.post("${baseUrl}/anime/schedule/add", data.field, function(json){
					layer.closeAll('loading');
					if(!json.success){
						layer.msg(json.data)
						return
					}else{
						layer.closeAll('page');
						table.reload('animeTable');
						layer.msg(json.data)
						return
					}
				}, "JSON");
			}else if(action === "MODIFY"){
				$.post("${baseUrl}/anime/schedule/modify", data.field, function(json){
					layer.closeAll('loading');
					if(!json.success){
						layer.msg(json.data)
						return
					}else{
						layer.closeAll('page');
						table.reload('animeTable');
						layer.msg(json.data)
						return
					}
				}, "JSON");
			}
			return false;
		});
		 //添加按钮点击事件
		$("#addBtn").click(function(){
			showEditModel(null);
		});
		  //显示表单弹窗
		function showEditModel(data){
			var index =layui.layer.open({
	                title : data==null ? "添加动漫播放信息" :"修改动漫播放信息",
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
                 url: '${base}/file/upload/',
                 field:'test',
                 before: function(obj){
                     //预读本地文件示例，不支持ie8
                     obj.preview(function(index, file, result){
                         $("#editForm img[name=animeCover]").attr("src",result);//图片链接（base64）
                     });
                     imageIndex = layer.load(2, {
                         shade: [0.3, '#333']
                     });
                 },
                 done: function(res){
                     layer.close(imageIndex);
                     //如果上传失败
                     if(res.success == false){
                         return layer.msg('上传失败');
                     }
                     $("#editForm input[name=animeCover]").val(res.data.url);
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