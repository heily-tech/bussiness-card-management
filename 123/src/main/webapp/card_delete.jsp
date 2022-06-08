<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<title>명함 관리 시스템 : 명함 삭제</title>
  	<style type="text/css">
  		@font-face {
  			src: url("fonts/LeferiBaseRegular.ttf");
  			font-family: "Leferi";		}
  		* {  			font-family: "Leferi";  		}
      #deleteForm {  			margin: auto;			width: 600px;			height : 400px;		}
      #commandCell {  			margin-top: 10px;  			text-align: center;  		}
  	</style>
  </head>
  <body>
    <h2 style="text-align: center;">명함 삭제</h2>
    <form action="cardDelete.bo" method="post">
      <input type = "hidden" name = "page" value = ""/>
      <table border="1px" align="center" cellspacing="0">
        <tr>
          <td class="td_left"><label for="emp_num">사번</label></td>
          <td colspan="3" class="td_right"><input type="number" name="emp_num" id="emp_num" autofocus required></td>
        </tr>
        <tr>
          <td>권한 비밀번호</td>
          <td><input type="password" name="author_passwd" id="author_passwd" required></td>
        </tr>
      </table>
      <section id="commandCell">
        <input type="submit" value="삭제">&nbsp;&nbsp;
        <input type="button" value="돌아가기" onClick='javascript:history.go(-1)'/>
      </section>
    </form>
  </body>
</html>