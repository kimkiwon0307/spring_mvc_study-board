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

	<div class="container-fluid">
		<div class="table-responsive" style="text-align: center">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">이름</th>
						<th scope="col">날짜</th>
						<th scope="col">조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}"/></td>
							<td><c:out value="${board.title}"/></td>
							<td><c:out value="${board.writer}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/> </td>
							<td>0</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</main>
	</div>

	<%@include file="../includes/footer.jsp"%>
</body>
</html>