<!--
<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<BoardBean> articleList=(ArrayList<BoardBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
  //기타 객체 다 받아와야 수정으로 넘길 수 있음
%>
-->

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
      <!--
      <% if(articleList != null && listCount > 0) { %>
      <% for (int i = 0; i < articleList.size(); i++ ){ %>
      <% if (i % 2 == 0) { %>
        <tr>
          <td>
          <div align="center"><span style="font-size:20px"><b><%=articleList.get(i).getEMPNAME() %></b></span>
          <%=articleList.get(i).getPOSNAME %> | <%=articleList.get(i).getDEPNAME %></div>
          <hr>
          <div><span class="type">Mobile.</span><%=articleList.get(i).getMOBILE() %></div>
          <div><span class="type">Tel.</span><%=articleList.get(i).getPHONE() %></div>
          <div><span class="type">Fax.</span><%=articleList.get(i).getFax() %></div>
          <div><span class="type">Email.</span><%=articleList.get(i).getEMAIL() %></div>
        </td>
    <%} else if (i % 2 == 1){ %>
          <td>
            <div align="center"><span style="font-size:20px"><b><%=articleList.get(i).getEMPNAME() %></b></span>
            <%=articleList.get(i).getPOSNAME %> | <%=articleList.get(i).getDEPNAME %></div>
            <hr>
            <div><span class="type">Mobile.</span><%=articleList.get(i).getMOBILE() %></div>
            <div><span class="type">Tel.</span><%=articleList.get(i).getPHONE() %></div>
            <div><span class="type">Fax.</span><%=articleList.get(i).getFax() %></div>
            <div><span class="type">Email.</span><%=articleList.get(i).getEMAIL() %></div>
          </td>
        <tr>
    <% } %>
    -->
      <tr>
        <td> <!-- onclick="window.open('')"> 수정 페이지로 연결-->
          <div align="center"><span style="font-size:20px"><b>황윤주</b></span> 대리 | 솔루션</div><hr>
          <div><span class="type">Mobile.</span> 010-9371-1431</div>
          <div><span class="type">Tel.</span> 053-555-5555</div>
          <div><span class="type">Fax.</span> 042-244-2123</div>
          <div><span class="type">Email.</span> edelbteen@gmail.com</div>
        </div>
        </td>
        <td>
          <div align="center"><span style="font-size:20px"><b>EMPNAME()</b></span>
          POSNAME | DEPNAME</div>
          <hr>
          <div><span class="type">Mobile.</span> MOBILE</div>
          <div><span class="type">Tel.</span> PHONE</div>
          <div><span class="type">Fax.</span> Fax</div>
          <div><span class="type">Email.</span> EMAIL</div>
        </td>
      <tr>
    </table>
  </section>
  <section id="pageList">
    <!--
      <% if (nowPage <= 1) { %>
        이전%nbsp|
      <% } else { %>
        <a href="boardList.bo?page="<%=nowPage-1 %>">[이전]</a>&nbsp;
      <% } %>
      <% for (int i = startPage; i <= endPage; i++) {
        if (i == nowPage) { %>
          <% i %> |&nbsp;
        <% } else { %>
         <a href="boardList.bo?page=<%=a %>"><%=a %></a> |&nbsp;
        <% } %>
      <% } %>
      <% if (nowPage >= maxpage) { %>
        다음
      <% } else { %>
        	<a href="boardList.bo?page=<%=nowPage+1 %>">다음</a>
      <% } %>
    -->
		<a href="">이전</a> | 1 | <a href="">다음</a>
	</section>
  <section id="emptyArea">
  <!--
  <% } else { %>
    <section><hr><h2 style="font-size:15px">등록된 명함이 없습니다.</h2></section>
  <% } %>
  -->
	<hr><h2 style="font-size:15px">등록된 명함이 없습니다.</h2>
  </section>
  </body>
</html>
