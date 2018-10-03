<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイトル検索結果</title>
</head>
<body>
<!-- 検索結果がなかった場合、検索文字を表示しない -->
<c:if test="${title.length() != 0}">
<p>検索文字:<c:out value="${title}"/></p>
</c:if>
<!-- エラーメッセージがなく(0文字)、検索文字が一文字以上の場合 -->
<!-- 検索に引っかかったカラム(列)を表示する。 -->
<c:choose>
<c:when test="${errorMsg.length()==0 && title.length() != 0}">
	<table border="2">
	<tr>
	<th colspan="1">id</th>
	<th colspan="1">分類</th>
	<th colspan="1">名前</th>
	<th colspan="1">値段</th>
	<th colspan="1">更新日時</th>
	</tr>
	<c:forEach var="book" items="${sTitle}">
	<tr>
	   <td><c:out value="${book.id}"/></td>
	   <td><c:out value="${book.category}"/></td>
	   <td><c:out value="${book.title}"/></td>
	   <td><c:out value="${book.price}円"/></td>
	   <td><c:out value="${book.updated}"/></td>
	</tr>
	</c:forEach>
	</table><br>
	</c:when>
	<c:otherwise>
	<c:out value="${errorMsg}"/><br>
	</c:otherwise>
</c:choose>
	<a href="./Main">データベースへ戻る</a>
</body>
</html>