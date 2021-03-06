<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>명함 관리 시스템 : 명함 목록</title>
<style type="text/css">
  @font-face {
    src: url("fonts/LeferiBaseRegular.ttf");
    font-family: "Leferi";
  }
  * {font-family: "Leferi";}
  #header {    background: lightblue;    text-align: center;
    padding: 12px;    font-size: 25px;    font-weight: bold;    margin-bottom: 10px;  }
  #nav {  	text-align: right;  	font-size: 25px;
  	width: 800px;  	margin: auto;  }
  #listForm {	width: 800px;	margin: auto;}
  #pageList {  margin: auto;  margin-top: 10px;
		width: 500px;  text-align: center; }
  .type {  font-weight: bold;}
  table {	margin: auto;	width: 700px;}
  td {  width: 350px;  height: 100px;  border: 2px solid lightgray;
	  font-size: 16px;  padding: 15px;}
  td:hover {  background-color: lightgray;}
  h2 {  text-align: center;}
  a {  text-decoration : none;  color : blue;}
</style>
</head>
<body>
  <section id="header">
    <header>
      <div>
        <img src="imgs/download.png" width="50px" style="vertical-align:middle"> 명함 관리 시스템
      </div>
    </header>
  </section>
  <section id="nav">
   	<a href="/123/card_write.jsp">명함 작성</a>
  </section>
  <section id="listForm"><hr>
	<c:if test="${empty list}">
    	<hr><h2 style="font-size:25px">등록된 명함이 없습니다.</h2><hr>
	</c:if>
	<c:if test="${not empty list}">
		<c:set var="idx" value="0" />
    	<table cellspacing="2">
	    <c:forEach var="l" items="${list}">
	    <c:if test="${idx%2==0}">
	        <tr>
	    </c:if>
	          	<td onClick="location.href='/123/cardDetail.bo?emp=${l.getEmpNum()}'">
		          <div align="center"><span style="font-size:23px"><b>${l.getNameKor()}</b></span>
		          	<span>${l.getPosNum()} | ${l.getDepNum() }</span></div><hr>
		          <div><span class="type">Mobile.</span> ${l.getMobile()}</div>
		          <div><span class="type">Phone.</span> ${l.getPhone()}</div>
		          <div><span class="type">Fax.</span> ${l.getFax()}</div>
		          <div><span class="type">Email.</span> ${l.getEmail()}</div>
	        	</td>
	    <c:if test="${idx%2!=0}">
	        </tr>
	    </c:if>
    	<c:set var="idx" value="${idx + 1}" />
	    </c:forEach>
    </table>
   </c:if>
 	</section>
    <section id="pageList">
        <c:if test="${page==1}">
	        <a>이전 |</a>&nbsp;
        </c:if>
        <c:if test="${page!=1}">
	        <a href="cardList.bo?page=${page - 1}">이전 |</a>&nbsp;
        </c:if>

        <c:forEach var="m" items="${max}">
        	<a href="cardList.bo?page=${m.getPage()}">${m.getPage()}</a>&nbsp;|
        </c:forEach>

        <c:if test="${size!=7}">
      		<a> 다음</a>
		</c:if>
		<c:if test="${size==7}">
      		<a href="cardList.bo?page=${page + 1}"> 다음</a>
		</c:if>
    </section>
  </body>
</html>
