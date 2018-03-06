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
		  搜索ID：
		  <div class="layui-inline">
		    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
		  </div>
		  <button class="layui-btn" data-type="reload">搜索</button>
		</div>
		
		<table id="animeTable" class="layui-table" lay-filter="animetab"></table>
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
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
 			<div class="layui-input-block">
				<input name="animeName" placeholder="请输入名称" type="text" class="layui-input"  lay-verify="required" required />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">封面</label>
 			<div class="layui-input-block">
				<input name="animeCover" placeholder="请上传封面" type="text" class="layui-input" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">动漫图片</label>
 			<div class="layui-input-block">
				<input name="animeVerticalCover" placeholder="请上传动漫图片" type="text" class="layui-input" />
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
		<div class="layui-form-item modal-form-footer">
			<button class="layui-btn layui-btn-primary" type="button" id="btnCancel">取消</button>
			<button class="layui-btn" lay-filter="btnSubmit" lay-submit>保存</button>
		</div>
	</form>
	</script>
	<script>
		layui.use(['layer','table','form'], function(){
			var table = layui.table;
			var layer=layui.layer;
			var form =layui.form;
			var $=layui.jquery;
			
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
			      ,{field:'animeCover', title:'封面',width:"10%",align:"center",event: 'imageEvent' , unresize: true,templet:'<div><img title="点击看原图" width="50px" height="50px" style="cursor:pointer" src="{{d.animeCover}}"></div>'}
			      ,{field:'animeVerticalCover', title:'动漫图片',width:"10%",align:"center",}
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
				        url : '${baseUrl}/anime/schedule/del?animeId='+data.id,
				        dataType : 'json',
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
		    	var flag = true;
		    	if(flag){
			         flag = false;
			         $(this).attr("width","") ;
			         $(this).attr("height","");
			     }else{
			         flag = true;
			         $(this).attr("width","50px") ;
			         $(this).attr("height","50px") ;
			     }
	            /* layer.open({
	                type: 1,
	                title: false,
	                closeBtn: 0,
	                area: '516px',
	                skin: 'layui-layer-nobg', //没有背景色
	                shadeClose: true,
	                content: '<div><img src="'+data.animeCover+'"><div>'
			     }); */
			}
		  });
		
		//表单提交事件
		form.on('submit(btnSubmit)', function(data) {
			data.field._method = $("#editForm").attr("method");
			layer.load(2);
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
			return false;
		});
		  
		  //显示表单弹窗
		function showEditModel(data){
			var index =layer.open({
	                title : data==null ? "添加动漫播放信息" :"修改动漫播放信息",
	                type : 1,
	                maxmin: true,
	                content : $("#addModel").html(),
	                success : function(layer,index){
	                    setTimeout(function(){
	                        layer.tips('这里是关闭窗口', '.layui-layer-setwin .layui-layer-close', {
	                            tips: 3
	                        });
	                    },500)
	                }
	            });
	         $("#editForm")[0].reset();
			 $("#editForm").attr("method","POST");
			 if(data!=null){
			 	$("#editForm input[name=id]").val(data.id);
				$("#editForm input[name=animeName]").val(data.animeName);
				$("#editForm input[name=animeCover]").val(data.animeCover);
				$("#editForm input[name=animeVerticalCover]").val(data.animeVerticalCover);
				$("#editForm input[name=animePlayDate]").val(data.animePlayDate);
				$("#editForm input[name=animePlayTime]").val(data.animePlayTime);
				$("#editForm input[name=animeOriginTime]").val(data.animeOriginTime);
				$("#editForm input[name=animePlaySite]").val(data.animePlaySite);
				$("#editForm input[name=animeOriginStation]").val(data.animeOriginStation);
				$("#editForm input[name=animePlayEpisode]").val(data.animePlayEpisode);
				$("#editForm input[name=animePlayUrl]").val(data.animePlayUrl);
			}
           	 layer.full(index);
           	 $("#btnCancel").click(function(){
				layer.closeAll('page');
			});
		}
	});
		
		/* $(function(){
			$(".button-collapse").sideNav();
			$(".meuns").on("click", function(){
				$(".top-nav .page-title").html($(this).html());
				content_load($("main"), $(this).attr("data-href"));
			});
			
			$('#modifymodal').modal({
				ready: function(modal, trigger) { 
					// Callback for Modal open. Modal and trigger parameters available.
			      },
			    complete: function() {
			    } // Callback for Modal close
			});
			
			$('#deletetemodal').modal({
				in_duration: 150, // Transition in duration
			    out_duration: 100, // Transition out duration
			    starting_top: '2%', // Starting topstyle attribute
			    ending_top: '5%', // Ending top style attribute
				ready: function(modal, trigger) { 
					$("input[name='delAnimeId']").val($(trigger).data('id'));
			     },
			    complete: function() {
			    	
			    }
			});
			
			$('#delAnimeId').click(function() {
				var id = $("input[name='delAnimeId']").val()
				$.ajax({
						type :'post',
				        url : '${baseUrl}/anime/schedule/del?animeId='+id,
				        dataType : 'json',
				        success :  function(json){
				        	if(!json.success){
				        		Materialize.toast(json.data,1000)
				        		return
				        	}else{
				        		Materialize.toast(json.data,1000)
				        		refresh()
				        		return
				        	}
						}
				   });
			})
			function refresh(){
				console.log("AAA")
				$.ajax({
					type :'get',
			        url : '${baseUrl}/anime/schedule/list?pagenum=1',
			        dataType : 'json',
			        success :  function(json){
			        	console.log(json)
					}
			   });
			}
		}); */
	</script> 
</html>