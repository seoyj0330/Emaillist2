<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트 가입</h1>
	<p>
		메일 리스트에 가입하려면,<br> 아래 항목을 기입하고 submit 버튼을 클릭하세요.
	</p>
	<form action="el" method="get">			<%-- action을 el로 ! el로 데이터를 보내줌  --%>
		Last name(성): <input type="text" name="ln" value=""><br>
		First name(이름): <input type="text" name="fn" value=""><br>
		Email address: <input type="text" name="email" value=""><br>
		<input type ="text" name="a" value="insert"><br>
		<input type="submit" value="등록">
	</form>
	<br>
	<p>
		<a href="el?a=list">리스트 바로가기</a>		<%-- controller인 el을 통해서 list를 요청할 수 있도록 --%>
	</p>
</body>
</html>