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
<div class="databese">
<p>削除する本のタイトルを選択してください</p>
<form action="/bookDB/DeleteBookServlet" method="post">
<select name="BookTitle">
<c:forEach var="book" items="${bookList}">
<option value="${book.id}">${book.title}</option>
</c:forEach>
</select>
<input type="submit" value="削除"><br>
</form>
</div>
<a href="./Main">データベースへ戻る</a>
</body>
</html>