<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>
<%  
    //파라미터 꺼내기
    int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	//personVo 만들기
	PersonVo personVo = new PersonVo(id, name, hp, company);
	System.out.println("personVo");
	
	//PhoneDao personUpdat()로 수정하기 
	PhoneDao phoneDao = new PhoneDao();
	int count = phoneDao.personUpdate(personVo);
	System.out.println(count);
	
	//리스트로 리다이렉트 시키기 
	response.sendRedirect("./list.jsp");
	
	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>