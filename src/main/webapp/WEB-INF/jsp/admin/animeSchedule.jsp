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
  			苟利国家生死以
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