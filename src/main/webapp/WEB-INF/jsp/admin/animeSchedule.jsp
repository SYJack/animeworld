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
	      		<table id="animeTable" class="layui-table" lay-filter="animetab">
			        <%-- <thead>
			          <tr>
			              <th class="valign">行号</th>
			              <th class="valign">动漫基本信息</th>
			              <th class="valign">动漫图片信息</th>
			              <th class="valign">动漫播放信息</th>
			              <th class="valign">操作</th>
			          </tr>
			        </thead>
			
			        <tbody>
			         <c:forEach var="item" items="${scheduleList}" varStatus="stus">
			         	<tr data-id="${item.id }">
				          	<td class="valign">${stus.index + 1 }</td>
				            <td class="valign">
				            	<p>名称:${item.animeName}</p>
				            </td>
				            <td class="valign">
				            	<p class="left-align">封面图片:<img class="materialboxed" width="100" height="100" src="${item.animeCover}"></p>
				            	<p class="left-align">动漫图片:<img class="materialboxed" width="100" height="100" src="${item.animeVerticalCover}"></p>
				            </td>
				            <td class="valign">
				            	<p>播放日期:${item.animePlayDate}</p>
				            	<p>国内播放时间:${item.animePlayTime}</p>
				            	<p>制作国家播放时间:${item.animeOriginTime}</p>
				            	<p>国内播放网站:${item.animePlaySite}</p>
				            	<p>制作国家播放电视台:${item.animeOriginStation}</p>
				            	<p>国内播放网址:${item.animePlayUrl}</p>
				            	<p>播放集数:${item.animePlayEpisode}</p>
				            </td>
				            <td class="valign">
				            	<p>
				            		<a href="#modifymodal" class="modal-trigger waves-effect waves-light btn" title="编辑"><i class="tiny material-icons left">mode_edit</i>编辑</a>
				            	</p>
				            	<p>
					            	<a href="#deletetemodal" data-id="${item.id }" class="modal-trigger waves-effect waves-light btn" title="删除"><i class="tiny material-icons left">delete</i>删除</a>
				            	</p>
				            </td>
			          </tr>
			         </c:forEach>
			        </tbody> --%>
			      </table>
  	   <%-- <footer id="footer">
  	   		<c:if test="${totalpages>1}">
  	   			<div class="right-align" style="background: transparent">
		  	   		<ul class="pagination" style="background: transparent">
		  	   			<li class="waves-effect"><a href="${baseUrl}/anime/schedule/list?pagenum=1">首页</a></li>
					    <li class="waves-effect"><a href="${baseUrl}/anime/schedule/list?pagenum=${pageNum-1}"><i class="material-icons">chevron_left</i></a></li>
					    <c:forEach var="pageIndex" begin="${startpage}" end="${endpage}">
                            <c:choose>
                                <c:when test="${pageNum == pageIndex}">
                                    <li class="active"><a href="#!"> ${pageIndex} </a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="waves-effect">
                                        <a href="${baseUrl}/anime/schedule/list?pagenum=${pageIndex}">${pageIndex}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
					    <c:if test="${pageNum != totalpages}">
					    	<li class="waves-effect"><a href="${baseUrl}/anime/schedule/list?pagenum=${pageNum+1}"><i class="material-icons">chevron_right</i></a></li>
					    </c:if>
					    <li class="waves-effect"><a href="${baseUrl}/anime/schedule/list?pagenum=${totalpages}">末页</a></li>
					    <li class="disabled"><a>共${totalpages}页</a></li>
					 </ul>
		  		</div>
  	   		</c:if>
	    </footer> --%>
    </body>
    <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
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
			      ,{field:'animeCover', title:'封面',width:"10%",align:"center",event: 'imageEvent' , unresize: true, sort: true,templet:'<div style="height:50px;"><img style="cursor:pointer" class="fmimage"  src="../resource/upload/images/{{d.blog_coverimage}}"></div>'}
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
		      layer.confirm('真的删除行么', function(index){
		        obj.del();
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		      layer.alert('编辑行：<br>'+ JSON.stringify(data))
		    }
		  });
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