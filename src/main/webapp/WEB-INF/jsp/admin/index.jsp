<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
	  <title>动漫世界管理系统</title>
	  <link rel="stylesheet" href="${baseResPath}/layui/css/layui.css" media="screen,projection">
	  <link type="text/css" rel="stylesheet" href="${baseResPath}/css/style.css" media="screen,projection">
      <link type="text/css" rel="stylesheet" href="${baseResPath}/love2d/waifu.css" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	</head>

     <body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">
		  <div class="layui-header">
		    <div class="layui-logo">layui 后台布局</div>
		    <!-- 头部区域（可配合layui已有的水平导航） -->
		    <ul class="layui-nav layui-layout-left">
		      <li class="layui-nav-item"><a href="">控制台</a></li>
		      <li class="layui-nav-item"><a href="">商品管理</a></li>
		      <li class="layui-nav-item"><a href="">用户</a></li>
		      <li class="layui-nav-item">
		        <a href="javascript:;">其它系统</a>
		        <dl class="layui-nav-child">
		          <dd><a href="">邮件管理</a></dd>
		          <dd><a href="">消息管理</a></dd>
		          <dd><a href="">授权管理</a></dd>
		        </dl>
		      </li>
		    </ul>
		    <ul class="layui-nav layui-layout-right">
		      <li class="layui-nav-item">
		        <a href="javascript:;">
		          <img src="${baseResPath}/images/avatar.jpg" class="layui-nav-img">
		         	椎名真白
		        </a>
		        <dl class="layui-nav-child">
		          <dd><a href="">基本资料</a></dd>
		          <dd><a href="">安全设置</a></dd>
		        </dl>
		      </li>
		      <li class="layui-nav-item"><a href="">退了</a></li>
		    </ul>
		  </div>
		  
		  <div class="layui-side layui-bg-black">
		    <div class="layui-side-scroll">
		      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		      <ul id="sidebar_Navigation" class="layui-nav layui-nav-tree"  lay-filter="">
		        <li class="layui-nav-item layui-nav-itemed">
		          <a href="javascript:;">图片管理</a>
		          <dl class="layui-nav-child">
		            <dd><a href="javascript:;" data-url="">列表一</a></dd>
		            <dd><a href="javascript:;" data-url="">列表二</a></dd>
		            <dd><a href="javascript:;" data-url="">列表三</a></dd>
		            <dd><a href="" data-url="">超链接</a></dd>
		          </dl>
		        </li>
		        <li class="layui-nav-item">
		          <a href="javascript:;">文章管理</a>
		          <dl class="layui-nav-child">
		            <dd><a href="javascript:;" data-url="">列表一</a></dd>
		            <dd><a href="javascript:;" data-url="">列表二</a></dd>
		            <dd><a href="">超链接</a></dd>
		          </dl>
		        </li>
		        <li class="layui-nav-item">
		        	<a href="javascript:;">番剧管理</a>
		        	<dl class="layui-nav-child">
			            <dd><a href="javascript:;" data-url="${baseUrl}/admin/animeSchedule">番剧日志</a></dd>
			            <dd><a href="javascript:;" data-url="">列表二</a></dd>
		          	</dl>
		        </li>
		        <li class="layui-nav-item">
		        	<a href="javascript:;">权限管理</a>
		        	<dl class="layui-nav-child">
			            <dd><a href="javascript:;" data-url="${baseUrl}/admin/sysUserList">系统用户管理</a></dd>
			            <dd><a href="javascript:;" data-url="${baseUrl}/admin/sysManagerList">系统管理员管理</a></dd>
			            <dd><a href="javascript:;" data-url="${baseUrl}/admin/sysRoleList">系统角色管理</a></dd>
		          	</dl>
		        </li>
		        <li class="layui-nav-item"><a href="javascript:;" data-url="">系统管理</a></li>
		      </ul>
		    </div>
		  </div>
		  
		  
		  <div class="layui-body">
		    <!-- 内容主体区域 -->
		    <div>
		        <div class="layui-tab layui-tab-brief" lay-allowClose="true"  lay-filter="contentTab">
					 <ul class="layui-tab-title">
					</ul>
					<div class="layui-tab-content">
					</div>
				</div>      
		    </div>
		  </div>
		  
		  <div class="layui-footer">
		    <!-- 底部固定区域 -->
		    © layui.com - 底部固定区域
		  </div>
		</div>
	  <script type="text/javascript" src="${baseResPath}/js/jquery-3.1.1.min.js"></script>
	  <script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
      <%-- <script type="text/javascript" src="${baseResPath}/love2d/autoload.js"></script> --%>
      <script>
		layui.define(['layer', 'element'], function(exports){
		  var element = layui.element;
		  var layer = layui.layer;
		    element.tabAdd('contentTab', {
		        title: "<i class='fa fa-home'></i>&nbsp;首页"
		        ,content:"<iframe class='iframe' src='main'></iframe>" //支持传入html
		        ,id: "777"
		    });
		    element.tabChange("contentTab",777);
		    
		     // 加载 CSS
			$("<link>").attr({href: "${baseResPath}/love2d/waifu.css", rel: "stylesheet", type: "text/css"}).appendTo('head');
			// 插入 DIV
			$('.layui-footer').append('<div class="waifu"><div class="waifu-tips"></div><canvas id="live2d" width="280" height="250" class="live2d"></canvas><div class="waifu-tool"><span class="fui-home"></span> <span class="fui-chat"></span> <span class="fui-eye"></span> <span class="fui-user"></span> <span class="fui-photo"></span> <span class="fui-info-circle"></span> <span class="fui-cross"></span></div></div>');
			// 加载 JS
			$.ajax({
				url: '${baseResPath}/love2d/live2d.js',
				dataType:"script",
				cache: true,
				async: false
			});
			$.ajax({
				url: '${baseResPath}/love2d/waifu-tips.js',
				dataType:"script",
				cache: true,
				async: false
			});
			
			// 初始化看板娘，会自动加载指定目录下的 waifu-tips.json
			initModel('${baseResPath}/love2d/');
		    $('#sidebar_Navigation li a').each(function(index,el){
		    	$(el).click(function(){
		    		if($(this).data('url')){
		    			var url=$(this).data("url");
		    			var title=$(this).html();
		    			
		    			var flag=false;
				    	$("#contentTab2 li").each(function(k,v){
		                    if($(v).attr("lay-id")==eval(index+1)){
		                        flag=true;
		                    }
		                });
		                if(flag){
		                    element.tabChange("contentTab",index+1);
		                }else{
		                    //判断layID 是否存在
		                    setTimeout(function(){
		                        element.tabAdd('contentTab', {
		                            title: title
		                            ,content:"<iframe class='iframe' src="+url+"></iframe>" //支持传入html
		                            ,id: index+1
		                        });
		                        element.tabChange("contentTab",index+1);
		                    },500)
		                }
		    		}
		    	});
		    });
		  
		});
		
	  </script> 
    </body>
</html>
      