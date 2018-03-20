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
		 <div class="layui-form-item">
	        <label class="layui-form-label">登录名称</label>
	        <div class="layui-input-inline">
		          <input type="text" class="layui-input" name="loginname" lay-verify="required" placeholder="请输入登录名" value="${currentUser.loginname}">
		     </div>
	    </div>
	    <div class="layui-form-item">
	        <label class="layui-form-label">头像</label>
	        <div class="layui-input-block">
		          <input type="hidden"  name="portraitUrl" value="${currentUser.portraitUrl}">
		          <img class="layui-upload-img" src="${currentUser.portraitUrl}" >
		     </div>
	    </div>
	    <div class="layui-form-item">
	        <label class="layui-form-label">手机号码</label>
	        <div class="layui-input-inline">
		          <input type="text" class="layui-input" name="mobile" lay-verify="phone" placeholder="请输入手机号码" value="${currentUser.mobile}">
		     </div>
	    </div>
	    <div class="layui-form-item">
		    <label class="layui-form-label">性别</label>
		    <div class="layui-input-block">
		      <input type="radio" <c:if test="${currentUser.gender == 1}">checked</c:if> name="gender" value="1" title="男" >
		      <input type="radio" <c:if test="${currentUser.gender == 0}">checked</c:if> name="gender" value="0" title="女" >
		      <input type="radio" <c:if test="${currentUser.gender == -1}">checked</c:if> name="gender" value="-1" title="保密">
		    </div>
		</div>
		<div class="layui-form-item">
	        <label class="layui-form-label">邮箱</label>
	        <div class="layui-input-inline">
		          <input type="text" class="layui-input" name="email" lay-verify="email" placeholder="请输入邮箱" value="${currentUser.email}">
		     </div>
	    </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label">开通</label>
		    <div class="layui-input-block">
		      <input type="radio" <c:if test="${currentUser.status == 1}">checked</c:if> name="status" value="1" title="启用" >
		      <input type="radio" <c:if test="${currentUser.status == 0}">checked</c:if> name="status" value="-1" title="冻结" >
		    </div>
		</div>
		<div class="layui-form-item">
	        <div class="layui-input-block">
	            <button class="layui-btn" lay-submit lay-filter="modifyUser">保存</button>
	            <button class="layui-btn" class="layui-btn layui-btn-primary">取消</button>
		     </div>
	    </div>
	</form>
</body>
<script type="text/javascript" src="${baseResPath}/layui/layui.js"></script>
<script>
	var index = parent.layer.getFrameIndex(window.name); //当前窗口索引
	layui.use(['layer','jquery','form','upload'], function(){
		var layer=layui.layer,
			 form =layui.form,
			 $=layui.jquery,
			 upload = layui.upload;
		
		form.on("submit(modifyUser)",function(data){
			if(data.field.id == null){
                layer.msg("用户ID不存在");
                return false;
            }
			var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
			$.ajax({
                type:"POST",
                url:"${baseUrl}/admin/sysuser/modify",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data.field),
                success:function(json){
                    layer.close(loadIndex);
                    if(json.success){
                        parent.layer.msg("用户编辑成功！",{time:1500},function(){
                            parent.location.reload();
                        });
                    }else{
                        layer.msg(json.data);
                    }
                }
            });
            return false;
		});
	});
</script>