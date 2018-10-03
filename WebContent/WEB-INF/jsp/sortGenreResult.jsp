<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookDateBase</title>
</head>
<body>
<table border="2">
	<tr>
	<th colspan="1">id</th>
	<th colspan="1">分類</th>
	<th colspan="1">名前</th>
	<th colspan="1">値段</th>
	<th colspan="1">更新日時</th>
	</tr>
	<c:forEach var="book" items="${sortList}">
	<tr>
	   <td><c:out value="${book.id}"/></td>
	   <td><c:out value="${book.category}"/></td>
	   <td><c:out value="${book.title}"/></td>
	   <td><c:out value="${book.price}円"/></td>
	   <td><c:out value="${book.updated}"/></td>
	</tr>
	</c:forEach>
	</table><br>
	<a href="./Main">データベースへ戻る</a>
</body>
</html>