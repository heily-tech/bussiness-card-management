<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 관리 시스템 : 명함 상세보기</title>
<style type="text/css">
@font-face {
  src: url("fonts/LeferiBaseRegular.ttf");
  font-family: "Leferi";
}
* {  font-family: "Leferi";}
#listForm {  margin: auto; 	width: 600px;	/*border: 1px solid red; */  }
table {  margin: 10px; width: 600px;			border: 1px solid lightgray;	}
.td_right {  font-size: 14px;  }
#commandCell {  margin-top: 10px;  text-align: center;  color : #666666}
a {  text-decoration: none; }
</style>
</head>
<body>
	<section id="listForm">
		<h2 style="text-align: center">명함 상세보기</h2>
      <table border="1px" bordercolor="lightgrey" align="center" cellspacing="0">
        <tr>
          <td class="td_left"><label for="emp_num">사번</label></td>
          <td colspan="3" class="td_right">${card.getEmpNum()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="name_kor">성명</label></td>
          <td class="td_right">${card.getNameKor()}</td>
          <td class="td_left"><label for="name_eng">영문자 성명</label></td>
          <td class="td_right">${card.getNameEng()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="soc_num">주민번호</label></td>
          <td class="td_right" colspan="3">${card.getSocNum()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="dep_num">부서명</label></td>
          <td class="td_right">${card.getDepNum()}</td>
          <td class="td_left"><label for="pos_num">직위</label></td>
          <td class="td_right">${card.getPosNum()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="mobile">모바일</label></td>
          <td class="td_right">${card.getMobile()}</td>
          <td class="td_left"><label for="email">이메일</label></td>
          <td class="td_right">${card.getEmail()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="phone">유선전화</label></td>
          <td class="td_right">${card.getPhone()}</td>
          <td class="td_left"><label for="fax">팩스</label></td>
          <td class="td_right">${card.getFax()}</td>
        </tr>
        <tr>
          <td class="td_left"><label for="d_entry">입사일</label></td>
          <td class="td_right">${card.getDEntry()}</td>
          <td class="td_left"><label for="d_resign">퇴사일</label></td>
          <td class="td_right">${card.getDResign()}</td>
        </tr>
         <tr>
           <td class="td_left"><label for="d_period">근무기간</label></td>
           <td colspan="3">zz</td>
         </tr>
      </table>
	</section>
	<section id="commandCell">
		<a href="cardModifyView.bo?emp=${card.getEmpNum()}">수정 </a> |
	    <a href="cardDeleteView.bo?emp="> 삭제 </a>|
	    <a href="cardList.bo"> 목록</a>&nbsp;&nbsp;
	  </section>
</body>
</html>