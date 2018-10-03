<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>本の削除</title>
</head>
<body>
<div class="database">
<p>下記の本を削除します</p>
<p>
本のタイトル:${deleteBook.title}<br>
分類:${deleteBook.category}<br>
値段:${deleteBook.price}<br>
</p>
<button name="back" onclick="location.href='./DeleteBookServlet'">戻る</button>
<button name="delete" onclick="location.href='./DeleteBookServlet?action=done'">削除する</button>
</div>
</body>
</html>