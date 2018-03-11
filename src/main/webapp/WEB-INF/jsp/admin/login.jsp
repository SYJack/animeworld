<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html>
<html>
     <body>
	     <head>
		  <title>登录--系统管理后台</title>
		  <link rel="stylesheet" href="${baseResPath}/layui/css/layui.css" media="screen,projection">
		  <link type="text/css" rel="stylesheet" href="${baseResPath}/css/login.css" media="screen,projection">
	      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		  <script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
		  <style type="text/css">
		  		body{
					background: url(${baseResPath}/images/loginbg.jpg) no-repeat top center;
				}
		  </style>
		</head>
		<div class="video_mask"></div>
		<div class="login">
		    <h1>椎名真白</h1>
		    <form class="layui-form" action="${baseUrl}/login/main" method="post">
		        <div class="layui-form-item">
		            <input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		        </div>
		        <div class="layui-form-item">
		            <input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		        </div>
		        <div class="layui-form-item form_code">
		            <input class="layui-input" name=validateCode placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
		            <div class="code"><img src="${baseUrl}/admin/getCaptcha" alt="点击更换" title="点击更换" width="116" height="36" id="login_validateCodeId"></div>
		        </div>
		        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		    </form>
		</div>
		<script>
		    layui.use(['layer', 'form'], function() {
		        var layer = layui.layer,
		                $ = layui.jquery,
		                form = layui.form;
		         $("#login_validateCodeId").click(function(){
           			 $("#login_validateCodeId")[0].src="${baseUrl}/admin/getCaptcha?t= "+Math.random();
		         });
		         form.on('submit(login)', function(data) {
		         	var username = $("input[name='username']").val();
		         	var password = $("input[name='password']").val();
		         	var code = $("input[name='validateCode']").val();
		         	$.post("${baseUrl}/admin/loginmain", {username:username,password:password,code:code}, function(json){
		         		console.log(json)
						layer.closeAll('loading');
						if(!json.success){
							layer.msg(json.data.msg)
							return
						}else{
							location.href = '${baseUrl}/index';
						}
					}, "JSON");
		           return false;
       			 });
		    });
		</script>
	</body>
</html>