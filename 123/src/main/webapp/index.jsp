<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>명함 관리 시스템 : INDEX</title>
  <style type="text/css">
    @font-face {
      src: url("fonts/LeferiBaseRegular.ttf");
      font-family: "Leferi";
    }
    * {      font-family: "Leferi";    }
    #header {
      background: lightblue;
      text-align: center;
      padding: 12px;
      font-size: 25px;
      font-weight: bold;
      margin-bottom: 10px;
    }
    #nav {
      text-align: center;
      padding: 20px;
    }
    #login {
      background-color : white;
      border: 1px solid lightgray;
      width: 180px;
      padding : 10px;
      margin: 10px auto;
    }
    div a {
      text-decoration : none;
      color : black;
      font-size: 20px;
      margin : 30px;
      background-color: #e2e5e2;
      border: 2px solid black;
      border-radius: 10px;
      padding: 5px 20px 5px 20px;
    }
    div a:hover {
      background-color: #22e5e2;
    }

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
  <section id="login">
  	<table>
  		<tr>
        <td>Login</td>
      </tr>
      <tr>
        <td width="100px">
          <input type="text" value="ID" style="width:100px; margin-bottom:2px"></input>
      		<input type="text" value="PASSWORD" style="width:100px"></input>
        </td>
        <td rowspan="2"><button type="submit" value="submit" style="height:55px">로그인</button></td>
      </tr>
  	</table>
  </section>
  <!--
  <section id="nav">
    <div>
      	<a href="/123/cardList.bo?page=1">목록보기</a>
      	<a href="/123/card_write.jsp">명함 작성</a>
      	<a href="/123/card_delete.jsp">명함 삭제</a>
    </div>
  </section>
-->
  <section id="footer">
    <div>
      <hr>
      2022, Capstone design.
    </div>
  </section>
</body>
</html>
