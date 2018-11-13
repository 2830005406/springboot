<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
Date d=new Date();
SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ems/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%=s.format(d) %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome ${sessionScope.username}!
					</h1>
					<table class="table" style="text-align:center">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Bir
							</td>
							<td>
								Sex
							</td>
							<td>
								Operation
							</td>
						</tr>
						<c:forEach items="${sessionScope.list }" var="list">
						<tr>
							<td>${list.id}</td>
							<td>${list.name}</td>
							<td>${list.salary}</td>
							<td>${list.age}</td>
							<td><fmt:formatDate value="${list.birthday }" pattern="yyyy-MM-dd"/></td>
							<td>${list.sex}</td>
							<td>
								<a href="${pageContext.request.contextPath }/emp/deleteEmployee?id=${list.id}">delete emp</a>&nbsp;
								<a href="${pageContext.request.contextPath }/emp/queryOneById?id=${list.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<a href="${pageContext.request.contextPath }/ems/addEmp.jsp">添加员工信息</a>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
