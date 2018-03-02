     <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
     <div class="layui-side layui-bg-black">
	    <div class="layui-side-scroll">
	      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
	      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
	        <li class="layui-nav-item layui-nav-itemed">
	          <a class="" href="javascript:;">图片管理</a>
	          <dl class="layui-nav-child">
	            <dd><a href="javascript:;">列表一</a></dd>
	            <dd><a href="javascript:;">列表二</a></dd>
	            <dd><a href="javascript:;">列表三</a></dd>
	            <dd><a href="">超链接</a></dd>
	          </dl>
	        </li>
	        <li class="layui-nav-item">
	          <a href="javascript:;">文章管理</a>
	          <dl class="layui-nav-child">
	            <dd><a href="javascript:;">列表一</a></dd>
	            <dd><a href="javascript:;">列表二</a></dd>
	            <dd><a href="">超链接</a></dd>
	          </dl>
	        </li>
	        <li class="layui-nav-item">
	        	<a href="javascript:;">番剧管理</a>
	        	<dl class="layui-nav-child">
		            <dd><a href="${baseUrl}/anime/schedule/list">番剧日志</a></dd>
		            <dd><a href="javascript:;">列表二</a></dd>
	          	</dl>
	        </li>
	        <li class="layui-nav-item"><a href="javascript:;">管理员管理</a></li>
	        <li class="layui-nav-item"><a href="javascript:;">系统管理</a></li>
	      </ul>
	    </div>
	  </div>
	  
	  
      <%-- <aside id="left-sidebar-nav">
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
                                 <li><a href="${baseUrl}/anime/image">Full Screen</a>
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
                                 <li><a href="${baseUrl}/anime/schedule/list">番剧日志</a>
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
  	  </aside> --%>