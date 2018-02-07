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
      <aside id="left-sidebar-nav">
		  <ul id="nav-mobile" class="side-nav fixed">
		    <li>
		     <div class="userView">
		      <div class="background">
		        <img src="${baseResPath}/images/user-bg.jpg">
		      </div>
		      <a href="#!user"><img class="circle" src="${baseResPath}/images/avatar.jpg"></a>
		      <a href="#!name"><span class="white-text name">椎名真白</span></a>
		      <a href="#!email"><span class="white-text email">ooxx@gmail.com</span></a>
		      </div>
		    </li>
            
		    <li class="no-padding">
                 <ul class="collapsible collapsible-accordion">
                     <li class="bold">
                     	 <a class="collapsible-header waves-effect waves-cyan"><i class="material-icons">picture_in_picture</i>图片管理</a>
                         <div class="collapsible-body">
                             <ul>
                                 <li><a href="#!">Full Screen</a>
                                 </li>
                                 <li><a href="#!">Horizontal Menu</a>
                                 </li>
                             </ul>
                         </div>
                     </li>
                 </ul>
             </li>
             <li class="no-padding">
                 <ul class="collapsible collapsible-accordion">
                     <li class="bold">
                     	 <a class="collapsible-header waves-effect waves-cyan"><i class="material-icons">library_books</i>文章管理</a>
                         <div class="collapsible-body">
                             <ul>
                                 <li><a href="#!">Full Screen</a>
                                 </li>
                                 <li><a href="#!">Horizontal Menu</a>
                                 </li>
                             </ul>
                         </div>
                     </li>
                 </ul>
             </li>
             <li class="no-padding">
                 <ul class="collapsible collapsible-accordion">
                     <li class="bold">
                     	 <a class="collapsible-header waves-effect waves-cyan"><i class="material-icons">video_library</i>番剧管理</a>
                         <div class="collapsible-body">
                             <ul>
                                 <li><a href="#!">Full Screen</a>
                                 </li>
                                 <li><a href="#!">Horizontal Menu</a>
                                 </li>
                             </ul>
                         </div>
                     </li>
                 </ul>
             </li>
             <li class="no-padding">
                 <ul class="collapsible collapsible-accordion">
                     <li class="bold">
                     	 <a class="collapsible-header waves-effect waves-cyan"><i class="material-icons">person_pin</i>管理员管理</a>
                         <div class="collapsible-body">
                             <ul>
                                 <li><a href="#!">Full Screen</a>
                                 </li>
                                 <li><a href="#!">Horizontal Menu</a>
                                 </li>
                             </ul>
                         </div>
                     </li>
                 </ul>
             </li>
             <li class="no-padding">
                 <ul class="collapsible collapsible-accordion">
                     <li class="bold">
                     	 <a class="collapsible-header waves-effect waves-cyan"><i class="material-icons">settings</i>系统管理</a>
                         <div class="collapsible-body">
                             <ul>
                                 <li><a href="#!">Full Screen</a>
                                 </li>
                                 <li><a href="#!">Horizontal Menu</a>
                                 </li>
                             </ul>
                         </div>
                     </li>
                 </ul>
             </li>
	  	  </ul>
  	  </aside>
  	  </header>
  	  <main id="content">
  		<div class="container">
  			苟利国家生死以
  		</div>
  	   </main>
  	   <%-- <footer class="page-footer">
	        <div class="container">
	            <div class="row section">
	                <div class="col l6 s12">
	                    <h5 class="white-text">World Market</h5>
	                    <p class="grey-text text-lighten-4">World map, world regions, countries and cities.</p>
	                    <div id="world-map-markers"></div>
	                </div>
	                <div class="col l4 offset-l2 s12">
	                    <h5 class="white-text">Sales by Country</h5>
	                    <p class="grey-text text-lighten-4">A sample polar chart to show sales by country.</p>
	                    <div id="polar-chart-holder">
	                        <canvas id="polar-chart-country" width="200"></canvas>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="footer-copyright">
	            <div class="container">
	                Copyright © 2015 <a class="grey-text text-lighten-4" href="http://themeforest.net/user/geekslabs/portfolio?ref=geekslabs" target="_blank">GeeksLabs</a> All rights reserved.
	                <span class="right"> Design and Developed by <a class="grey-text text-lighten-4" href="http://geekslabs.com/">GeeksLabs</a></span>
	            </div>
	        </div>
	    </footer> --%>
	 	 <div class="waifu" id="waifu">
		    <div class="waifu-tips"></div>
		    <canvas id="live2d" width="280" height="250" class="live2d"></canvas>
		    <div class="waifu-tool">
		        <span class="fui-home"></span>
		        <span class="fui-chat"></span>
		        <span class="fui-eye"></span>
		        <span class="fui-user"></span>
		        <span class="fui-photo"></span>
		        <span class="fui-info-circle"></span>
		        <span class="fui-cross"></span>
		    </div>
		</div>
      <script type="text/javascript" src="${baseResPath}/materialize/js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="${baseResPath}/materialize/js/materialize.min.js"></script>
      <script type="text/javascript" src="${baseResPath}/love2d/live2d.js"></script>
      <script type="text/javascript" src="${baseResPath}/love2d/waifu-tips.js"></script>
      <script type="text/javascript">initModel("${baseResPath}/love2d/")</script>
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
      