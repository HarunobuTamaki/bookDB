<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>本の追加</title>
</head>
<body>
<div class="database">
<c:if test="${errorMsg!=null}">
<c:out value="${errorMsg}"/>
</c:if>
<form action="/bookDB/CreateBookServlet" method="post">
本のタイトル:<br>
<input type="text" name="title"><br>
分類:<br>
<input type="text" name="category"><br>
値段(半角数字のみ):<br>
<input type="text" name="price"><br>
<input type="submit" value="登録">
</form><br>
<a href="./Main">データベースに戻る</a>
</div>
</body>
</html>