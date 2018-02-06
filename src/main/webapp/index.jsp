<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link type="text/css" rel="stylesheet" href="${baseResPath}/materialize/css/materialize.min.css"  media="screen,projection"/>
      <link href="${baseResPath}/css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

     <body>
      <nav class="light-blue lighten-1" role="navigation">
	    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">Logo</a>
	      <ul class="right hide-on-med-and-down">
	        <li><a href="#">导航链接</a></li>
	      </ul>
	    </div>
	  </nav>
	  
	  <div id="main" class="container">
	       <div class="wrapper">
	        	<aside id="left-sidebar-nav">
	        		<ul id="slide-out" class="side-nav fixed leftside-navigation">
	        			<li class="user-details cyan darken-2">
	        				<div class="row">
			                    <div class="col s4 m4 l4">
			                        <img src="${baseResPath}/images/avatar.jpg" alt="" class="circle responsive-img valign profile-image">
			                    </div>
			                    <div class="col s8 m8 l8">
			                        <ul id="profile-dropdown" class="dropdown-content">
			                            <li><a href="#"><i class="small material-live_help"></i>个人信息</a></li>
			                            <li><a href="#"><i class="small material-settings"></i>设置</a></li>
			                            <li><a href="#"><i class="small material-live_help"></i>帮助</a></li>
			                            <li class="divider"></li>
			                            <li><a href="#"><i class="small material-lock_outline"></i>Lock</a></li>
			                            <li><a href="#"><i class="small material-live_help"></i>退出</a></li>
			                        </ul>
			                        <a class="btn-flat profile-btn dropdown-button waves-effect" href="#" data-activates="profile-dropdown">椎名真白<i class="mdi-navigation-arrow-drop-down right"></i></a>
			                        <p class="user-roal">Administrator</p>
			                    </div>
			                </div>
	        			<li>
	        			<li class="bold active"><a href="#" class="waves-effect waves-cyan"><i class="mdi-action-dashboard"></i> Dashboard</a>
                		</li>
	        		<ul>
	        	</aside>
	       </div>
       </div>
      <script type="text/javascript" src="${baseResPath}/materialize/js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="${baseResPath}/materialize/js/materialize.min.js"></script>
    </body>
	<script>
	
	</script> 
</html>
      