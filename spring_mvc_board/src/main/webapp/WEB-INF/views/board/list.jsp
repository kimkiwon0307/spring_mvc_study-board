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
	<div class="container">
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
								<td><c:out value="${board.bno}" /></td>
								<td><a class="go_get" href="${board.bno}">	<c:out value="${board.title}" />
								</a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>
								<td>0</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


				<!-- modal -->
				<div class="modal" tabindex="-1" id="checkModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Modal title</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<p>처리가 완료되었습니다.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /modal -->
			</div>
			
			<!-- pagination -->
			<nav aria-label="Page navigation">
				<ul class="pagination">
					
				  <c:if test="${pageMaker.prev}">
					<li class="page-item disabled">
						<a class="page-link" href="${pageMaker.startPage -1}"tabindex="-1" aria-disabled="true">Previous</a>
					</li>
				  </c:if>	

				  <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					<li class="page-item ${pageMaker.cri.pageNum == num ? "active" : "" }">
						<a class="page-link" href="${num}">${num}</a>
					</li>
				  </c:forEach>

				   <c:if test="${pageMaker.next}">
					<li class="page-item">
						<a class="page-link" href="${pageMaker.endPage -1}">Next</a>
					</li>
				  </c:if>
				</ul>
			</nav>
		<!-- /pagination -->
			<button type="button" class="btn btn-primary" id="btn_register">등록</button>
			
			<form action="/controller/board/list" method="get" id="with_paging">
				<input type="hidden" name='pageNum' value="${pageMaker.cri.pageNum}">
				<input type="hidden" name='amount' value="${pageMaker.cri.amount}">
			</form>
			
		</div>
	</div>
	<%@include file="../includes/footer.jsp"%>

	<script>
		$(document).ready(function(){
			
		//모달 실행	
			
			// controller에서 넘긴 result
			var result = '<c:out value="${result}"/>'; 
			//모달함수 실행
			checkModal(result)
			// result를 파라미터로 받아서 해결하는 모달함수
			function checkModal(result){
				console.log(result);
				if(result === ''){
					return;
				}
				if(parseInt(result) > 0 ){
					$(".modal-body").html("게시글" + ${result} + "번이 등록되었습니다.");
				}
				
				$("#checkModal").modal("show");
			}
			
			
		//등록 버튼 
			$("#btn_register").on("click",function(){
				self.location ="/controller/board/register";
			});
		
		//
			$(".page-item a").on("click",function(e){
				
				e.preventDefault();
				
				$("#with_paging").find("input[name='pageNum']").val($(this).attr("href"));
				
				$("#with_paging").submit();
				
			});
		
			$(".go_get").on("click",function(e){
				
				e.preventDefault();
				
				$("#with_paging").append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
				$("#with_paging").attr("action","/controller/board/get");
				
				$("#with_paging").submit();
				
			});
		
		});
	</script>

</body>
</html>