<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>BookDataBase</title>
</head>
<body>
	<form action="/bookDB/SearchTitleServlet" method="post">
	検索(名前のみ)<br>
	<input type="text" name="search">
	<input type="submit" value="検索">
	</form>
	<p><button name="create" onclick="location.href='CreateBookServlet'">行の追加</button>
	<button name="delete" onclick="location.href='DeleteBookServlet'">行の削除</button>
	<button name="genre" onclick="location.href='SortBookServlet'">分類別に表示</button></p>
	<table border="2">
	<tr>
	<th colspan="1">id</th>
	<th colspan="1">分類</th>
	<th colspan="1">名前</th>
	<th colspan="1">値段</th>
	<th colspan="1">更新日時</th>
	</tr>
	<c:forEach var="book" items="${bookList}">
	<tr>
	   <td><c:out value="${book.id}"/></td>
	   <td><c:out value="${book.category}"/></td>
	   <td><c:out value="${book.title}"/></td>
	   <td><c:out value="${book.price}円"/></td>
	   <td><c:out value="${book.updated}"/></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>