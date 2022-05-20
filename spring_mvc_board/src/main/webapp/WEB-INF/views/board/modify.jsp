<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../includes/header.jsp"%>

<body>
	<header>
	</header>
	<div class="container">
		<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>수정 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > SpringMVC게시판 > 수정</h5>
			</div>
			
		</div>
		
		<form action="/controller/board/modify" method="post" >
					
			<div class="input_group_a">
			
				<input type='hidden' name="bno" value="${board.bno}"/>
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">제 목</span> 
					<input type="text" class="form-control" value="${board.title}" 
					  name="title" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">작성자</span> 
					<input type="text" class="form-control" placeholder="작성자" name="writer" value="${board.writer}" readonly="readonly">
				</div>
			
			
				<div class="input-group">
					<span class="input-group-text">내 용</span>
  					<textarea class="form-control" aria-label="With textarea" name="content" required>${board.content}</textarea>
				</div>


				<div class="btn_group">
					<button type="submit" class="btn btn-primary" id="btn_write">수 정</button>
					<button type="button" class="btn btn-danger" id="btn_list">삭 제</button>
					<button type="button" class="btn btn-danger" id="btn_list">목 록</button>
				</div>
			</div>
		</form>
			
	</div>

	<div class="bottom">
	</div>

	<script>
		$(document).ready(function(){
			
			
			})
			
		})
	
	</script>

</body>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>