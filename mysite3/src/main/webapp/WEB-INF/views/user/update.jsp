<%@page import="kr.co.itcen.mysite.vo.UserVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="user">
				<form:form
				 modelAttribute="userVo"
				 id="join-form" 
				 name="joinForm" 
				 method="post" 
				action="${pageContext.servletContext.contextPath}/user/update" >
				<label class="block-label" for="name">이름</label>
				<form:input path="name" />
					<spring:hasBindErrors name="userVo">
					<br>
						<c:if test='${errors.hasFieldErrors("name") }'>
						<p style="font-weight:bold; color:red; text-align:left; padding:2px 0 0 0">
							<spring:message code='${errors.getFieldError("name").codes[0] }' text='${errors.getFieldError("name").defaultMessage }'></spring:message>
						</p>
						</c:if>
					</spring:hasBindErrors>	
					<label class="block-label" for="email">이메일</label>
					<h4>${userVo.email }</h4>
					<form:hidden path="email" />
					<label class="block-label">패스워드</label>
					<form:password path="password" />
					<br>
					<form:radiobuttons path="gender" items="${userVo.genders }" />
					
					<input type="submit" value="수정하기">
	
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>