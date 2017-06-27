<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>学生姓名</td>
			<td>学生年龄</td>
			<td>学生性别</td>
			<td>学生班级</td>
			<td>学生生日</td>
			<td><button onclick="location.href='saveStudentpage'">添加</button></td>
		</tr>
		<c:forEach items="${list}" var="li">
			<tr>
				<td>${li.name}</td>
				<td>${li.age}</td>
				<td>${li.sex}</td>
				<td>${li.clazz}</td>
				<td>${li.birthday}</td>
				<td>
					<button onclick="location.href='toUpdPage?stu.id=${li.id}'">修改</button>
					<button onclick="location.href='detStudent?stu.id=${li.id}'">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	${error}
</body>
</html>