<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>명함 관리 시스템 : 명함 입력</title>
	<style type="text/css">
		@font-face {
			src: url("fonts/LeferiBaseRegular.ttf");
			font-family: "Leferi";		}
		* {
			font-family: "Leferi";
		}
		#registForm {
			margin: auto;			width: 600px;			height : 400px;		}
		table {
			margin: 10px;			width: 600px;			border: 1px solid lightgray;	}
		input {
			width: 200px;
		}
		#commandCell {
			margin-top: 10px;
			text-align: center;
		}
	</style>
</head>
	<body>
		<!-- 직원 등록 -->
		<section id="registForm">
		<h2 style="text-align: center;">직원 등록</h2>
			<form action="cardWrite.bo" method="post">
				<table border="1px" bordercolor="lightgrey" align="center" cellspacing="0">
					<tr>
						<td class="td_left"><label for="emp_num">사번</label></td>
						<td colspan="3" class="td_right"><input type="number" name="emp_num" id="emp_num" autofocus required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="name_kor">성명</label></td>
						<td class="td_right"><input type="text" name="name_kor" id="name_kor" required></td>
						<td class="td_left"><label for="name_eng">영문자 성명</label></td>
						<td class="td_right"><input type="text" name="name_eng" id="name_eng" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="soc_num">주민번호</label></td>
						<td class="td_right" colspan="3"><input type="text" name="soc_num" id="soc_num" min="0001011" max="9999999" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="emp_passwd">비밀번호</label></td>
						<td class="td_right"><input type="password" name="emp_passwd" id="emp_passwd" required></td>
						<td class="td_left"><label for="emp_passwd_confirm">비밀번호 확인</label></td>
						<td class="td_right"><input type="password" name="emp_passwd_confirm" id="emp_passwd_confirm" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="dep_num">부서명</label></td>
						<td class="td_right"><input type="text" name="dep_num" id="dep_num" required></td>
						<td class="td_left"><label for="pos_num">직위</label></td>
						<td class="td_right"><input type="text" name="pos_num" id="pos_num" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="mobile">모바일</label></td>
						<td class="td_right"><input type="text" name="mobile" id="mobile" required></td>
						<td class="td_left"><label for="email">이메일</label></td>
						<td class="td_right"><input type="text" name="email" id="email" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="phone">유선전화</label></td>
						<td class="td_right"><input type="text" name="phone" id="phone" required></td>
						<td class="td_left"><label for="tel">팩스</label></td>
						<td class="td_right"><input type="text" name="tel" id="tel" required></td>
					</tr>
					<tr>
						<td class="td_left"><label for="d_entry">입사일</label></td>
						<td class="td_right"><input type="date" name="d_entry" id="d_entry" required></td>
						<td class="td_left"><label for="e_resign">퇴사일</label></td>
						<td class="td_right"><input type="date" name="e_resign" id="e_resign"></td>
					</tr>
				</table>
				<section id="commandCell">
					<input type="submit" value="등록">&nbsp;&nbsp;
						<input type="reset" value="다시 쓰기" />
				</section>
		</form>
		</section>
	</body>
</html>