<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/admin/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="site-form">
					<ul>
						<li>
							<c:set var='count' value='${fn:length(list) }' /> <c:forEach
								items='${list }' var='vo' varStatus='status'>
								<table>
									<tr>
										<td>${count-status.index }</td>
										<td>${vo.name }</td>
										<td>${vo.reg_date }</td>
										<td><a
											href="${pageContext.servletContext.contextPath}/admin/guestbook/delete/${vo.no}">삭제</a></td>
									</tr>
									<tr>
										<td colspan=4>${fn:replace(vo.contents, newline, '<br/>')}
										</td>
									</tr>
								</table>
								<br>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp">
				<c:param name="menu" value="guestbook" />
			</c:import>
		</div>
	</div>
</body>
</html>