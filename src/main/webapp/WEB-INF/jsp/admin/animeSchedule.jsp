<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link type="text/css" rel="stylesheet" href="${baseResPath}/materialize/css/materialize.min.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="${baseResPath}/css/style.css" media="screen,projection">
      <link type="text/css" rel="stylesheet" href="${baseResPath}/love2d/waifu.css" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

     <body>
     <header id="header" class="page-topbar">
     	<nav class="light-blue lighten-1" role="navigation">
      	<a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle"><i class="material-icons">menu</i></a>
	    <div class="nav-wrapper container">
	      <ul class="right hide-on-med-and-down">
	        <li><a href="#">导航链接</a></li>
	      </ul>
	    </div>
	 	</nav>
	 	<%@include file="/WEB-INF/jsp/common/adminNav.jsp"%>
  	  </header>
  	  <main id="content">
		      <div class="container">
		      	<form class="col">
			     </form>
		      </div>
		       <div class="valign-wrapper">
	      		<table class="highlight bordered centered responsive-table">
			        <thead>
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
				            	<%-- <p>国内播放网址:${item.animePlayUrl}</p> --%>
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
			        </tbody>
			      </table>
		      </div>
  		</div>
  	   </main>
  	   <footer id="footer">
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
	    </footer>
	    
	  <!-- Modal Structure -->
	  <div id="modifymodal" class="modal modal-fixed-footer">
	    <div class="modal-content">
	      <h5>模态标题</h5>
	      <p>一堆文本</p>
	    </div>
	    <div class="modal-footer">
	      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">保存</a>
	      <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">取消</a>
	    </div>
	  </div>
	  
	  <div id="deletetemodal" class="modal">
	    <div class="modal-content">
	      <h5>确认信息</h5>
	      <p>是否删除选中的动漫?</p>
	    </div>
	    <div class="modal-footer">
	      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">删除</a>
	      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">取消</a>
	    </div>
	  </div>
      <script type="text/javascript" src="${baseResPath}/materialize/js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="${baseResPath}/materialize/js/materialize.min.js"></script>
      <script type="text/javascript" src="${baseResPath}/love2d/autoload.js"></script>
    </body>
	<script>
		$(function(){
			$(".button-collapse").sideNav();
			$(".meuns").on("click", function(){
				$(".top-nav .page-title").html($(this).html());
				content_load($("main"), $(this).attr("data-href"));
			});
			
			$('#modifymodal').modal({
				ready: function(modal, trigger) { 
					// Callback for Modal open. Modal and trigger parameters available.
			        console.log(modal, trigger);
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
			        console.log(modal, trigger);
			     },
			    complete: function() {
			    	$.ajax({
 							type :  'post',
 					        url : '',
 					        dataType : 'json',
 					        success :  function(json){
 					        	if(!json.success){
 					        		return;
 					        	}
 					        	if(json.msg != ''){
 					    		}
 							}
 					   }); 
			    }
			});
		});
	</script> 
</html>