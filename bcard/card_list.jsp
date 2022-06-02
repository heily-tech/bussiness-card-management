<%@page import="vo.PageInfo"%>
<%@page import="vo.CardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<CardBean> cardList=(ArrayList<CardBean>)request.getAttribute("cardList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>명함 관리 시스템 : 명함 목록</title>
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
  @font-face {
    src: url("../fonts/LeferiBaseRegular.ttf");
    font-family: "Leferi";
  }
#listForm {
	width: 800px;
	/*border: 1px solid red; 영역 표시 */
	margin: auto;
}
#pageList {
  margin: auto;
  margin-top: 10px;
  width: 500px;
  /*border: 1px solid red; 영역 표시 */
  text-align: center;
  font-family: "Leferi";
}
.type {
  font-weight: bold;
}
table {
	margin: auto;
	width: 700px;
}
td {
  width: 350px;
  height: 100px;
  border: 2px solid lightgray;
  font-family: "Leferi";
  font-size: 16px;
  padding: 15px;
}
td:hover {
  background-color: lightgray;
}
h2 {
	text-align: center;
  font-family: "Leferi"
}
</style>
</head>
<body>
	<section id="listForm">
		<h2>명함 목록</h2><br>
    <table>
      <% if(cardList != null && listCount > 0) { %>
      <% for (int i = 0; i < card.size(); i++ ){ %>
      <% if (i % 2 == 0) { %>
        <tr>
          <td>
          <div align="center"><span style="font-size:20px"><b><%=cardList.get(i).getEMP_NAME() %></b></span>
          <%=cardList.get(i).getPOS_NUM %> | <%=cardList.get(i).getDEP_NUM %></div>
          <hr>
          <div><span class="type">Mobile.</span><%=cardList.get(i).getMOBILE() %></div>
          <div><span class="type">Tel.</span><%=cardList.get(i).getPHONE() %></div>
          <div><span class="type">Fax.</span><%=cardList.get(i).getFax() %></div>
          <div><span class="type">Email.</span><%=cardList.get(i).getEMAIL() %></div>
        </td>
    <%} else if (i % 2 == 1){ %>
          <td>
            <div align="center"><span style="font-size:20px"><b><%=cardList.get(i).getEMP_NAME() %></b></span>
            <%=cardList.get(i).getPOS_NUM %> | <%=cardList.get(i).getDEP_NUM %></div>
            <hr>
            <div><span class="type">Mobile.</span><%=cardList.get(i).getMOBILE() %></div>
            <div><span class="type">Tel.</span><%=cardList.get(i).getPHONE() %></div>
            <div><span class="type">Fax.</span><%=cardList.get(i).getFax() %></div>
            <div><span class="type">Email.</span><%=cardList.get(i).getEMAIL() %></div>
          </td>
        <tr>
    <% } %>
    </table>
  </section>
  <section id="pageList">
      <% if (nowPage <= 1) { %>
        이전%nbsp|
      <% } else { %>
        <a href="cardList.bo?page="<%=nowPage-1 %>">[이전]</a>&nbsp;
      <% } %>
      <% for (int i = startPage; i <= endPage; i++) {
        if (i == nowPage) { %>
          <% i %> |&nbsp;
        <% } else { %>
         <a href="cardList.bo?page=<%=a %>"><%=a %></a> |&nbsp;
        <% } %>
      <% } %>
      <% if (nowPage >= maxpage) { %>
        다음
      <% } else { %>
        	<a href="cardList.bo?page=<%=nowPage+1 %>">다음</a>
      <% } %>
    -->
		<a href="">이전</a> | 1 | <a href="">다음</a>
	</section>
  <section id="emptyArea">
  <% } else { %>
    <section><hr><h2 style="font-size:15px">등록된 명함이 없습니다.</h2></section>
  <% } %>
  </body>
</html>
