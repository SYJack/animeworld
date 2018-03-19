<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/jsp/common/domain.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <title>动漫世界管理系统</title>
	  <link rel="stylesheet" href="${baseResPath}/layui/css/layui.css" media="screen,projection">
	  <link type="text/css" rel="stylesheet" href="${baseResPath}/css/style.css" media="screen,projection">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	</head>
<body>
	<form class="layui-form" style="width:80%;">
		<input type="hidden" name="id" value="${currentUser.id}"/>
	</form>
</body>
<script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
<script>
	layui.use(['layer','jquery','form','upload'], function(){
		var layer=layui.layer,
			 form =layui.form,
			 $=layui.jquery,
			 upload = layui.upload;
			
	});
</script>