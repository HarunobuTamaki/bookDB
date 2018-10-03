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
<!-- エラーメッセージがなければ登録処理 -->
<c:choose>
<c:when test="${errorMsg.length()==0}">
<p>下記の本を登録します</p>
<p>
本のタイトル:${registerBook.title}<br>
分類:${registerBook.category}<br>
値段:${registerBook.price}
</p>
</c:when>
<c:otherwise>
<c:out value="${errorMsg}"/>
</c:otherwise>
</c:choose>
<br>
<a href="./CreateBookServlet">戻る</a>
<!-- エラーメッセージがなければ表示する -->
<c:if test="${errorMsg.length()==0}">
<a href="./CreateBookServlet?action=done">登録する</a>
</c:if>
</div>
</body>
</html>