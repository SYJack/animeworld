<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="baseUrl" value="<%=basePath%>" scope="application"></c:set>
<c:set var="baseImgPath" value="${baseUrl }/res/images" scope="application"></c:set>
<c:set var="baseJsPath" value="${baseUrl }/res/js" scope="application"></c:set>
<c:set var="baseStylePath" value="${baseUrl }/res/style" scope="application"></c:set>
<c:set var="baseResPath" value="${baseUrl }/res" scope="application"></c:set>
<c:set var="baseResLayuiPath" value="${baseUrl }/res/layui" scope="application"></c:set>