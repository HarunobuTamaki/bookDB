<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の追加</title>
</head>
<body>
<c:if test="${errorMsg!=null }">
<c:out value="${errorMsg}"/><br>
</c:if>
<a href = "/bookDB/CreateBookServlet">戻る</a>
</body>
</html>