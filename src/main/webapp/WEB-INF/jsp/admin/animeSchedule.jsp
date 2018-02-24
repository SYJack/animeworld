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
		       <div class="container">
	      		<table class="highlight bordered centered responsive-table">
			        <thead>
			          <tr>
			              <th align="center" data-field="id">行号</th>
			              <th align="center" data-field="name">名称</th>
			              <th align="center" data-field="price">封面图片</th>
			              <th align="center" data-field="id">动漫图片</th>
			              <th align="center" data-field="name">播放日期</th>
			              <th align="center" data-field="price">国内播放时间</th>
			              <th align="center" data-field="id">制作国家播放时间</th>
			              <th align="center" data-field="name">国内播放网站</th>
			              <th align="center" data-field="price">制作国家播放电视台</th>
			              <th align="center" data-field="price">国内播放网址</th>
			              <th align="center" data-field="price">播放集数</th>
			              <th align="center" data-field="price">操作</th>
			          </tr>
			        </thead>
			
			        <tbody>
			          <tr>
			          	<td>1</td>
			            <td>龙王的工作！</td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/1ad2b2"></td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/907611"></td>
			            <td>20180219</td>
			            <td>22:30</td>
			            <td>21:00</td>
			            <td>bilibili</td>
			            <td>AT-X</td>
			            <td></td>
			            <td>第7集</td>
			            <td>第7集</td>
			          </tr>
			         <tr>
			          	<td>2</td>
			            <td>龙王的工作！</td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/1ad2b2"></td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/907611"></td>
			            <td>20180219</td>
			            <td>22:30</td>
			            <td>21:00</td>
			            <td>bilibili</td>
			            <td>AT-X</td>
			            <td></td>
			            <td>第7集</td>
			          </tr>
			          <tr>
			          	<td>3</td>
			            <td>龙王的工作！</td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/1ad2b2"></td>
			            <td><img class="materialboxed" width="100" height="100" src="http://img.animetamashi.cn/guide/907611"></td>
			            <td>20180219</td>
			            <td>22:30</td>
			            <td>21:00</td>
			            <td>bilibili</td>
			            <td>AT-X</td>
			            <td></td>
			            <td>第7集</td>
			          </tr>
			        </tbody>
			      </table>
		      </div>
  		</div>
  	   </main>
  	   <footer id="footer">
	  	   	<div class="container">
	  		</div>
	    </footer>
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
		});
	</script> 
</html>