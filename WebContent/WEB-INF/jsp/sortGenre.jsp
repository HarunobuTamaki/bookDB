<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>BookDataBase</title>
</head>
<body>
<div class="database">
<p>表示したいジャンルの本を選択してください</p>
<form action="/bookDB/SortBookServlet" method="post">
<select name="genre">
<option value="漫画">漫画</option>
<option value="雑誌">雑誌</option>
<option value="小説">小説</option>
<option value="未分類">未分類</option>
</select>
<input type="submit" value="決定">
</form><br>
<a href="./Main">戻る</a>
</div>
</body>
</html>