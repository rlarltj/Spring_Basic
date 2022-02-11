<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>id=${param.id}</h1>
<h1>pwd=${param.pwd}</h1>
<h1>name=${param.name}</h1>
<h1>email=${param.email}</h1>
<h1>birth=${param.birth}</h1>
<h1>sns=${param.sns}</h1>
<!-- sns는 checkbox 타입이므로, 전송되는 값이 여러개일 수 있다. 따라서 배열의 형태로 받는다. -->
<h1>sns=${paramValues.sns}</h1>
<h1>sns=${paramValues.sns[1]}</h1>
<h1>sns=${user.sns}</h1>
<h1>hobby=${user.hobby}</h1>
</body>
</html>