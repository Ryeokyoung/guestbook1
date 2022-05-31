<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.PersonVo" %>
<%@ page import="com.javaex.dao.PhoneDao" %>
	
<%@ page import="java.util.List" %>	
	
<%
	//파라미터에서 값 꺼내오기 
	
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	
	
	/*
	System.out.println(name);
	System.out.println(hp);
	System.out.println(company);
	*/
	
	//객체만들기 person
	PersonVo personVo = new PersonVo(name,hp,company);
	System.out.println(personVo);
	
	//객체만들기 phonedao 
	PhoneDao phoneDao = new PhoneDao();
	
	//객체만들기 insert
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
	
	
	
	//응답은 리스트로 리다이렉트 시킨다.
	//list.jsp로 다시 요청 
	response.sendRedirect("./list.jsp");
	
	//리스트가져와서 HTML 섞기 
	/*List<PersonVo> personList = phoneDao.getPersonList();
	system.out.println(personList);*/
	
	//personVo 메모리에 올린다
	//생성자 name hp company
	
	//Dao.insert(personVo)

%>
    
    
  