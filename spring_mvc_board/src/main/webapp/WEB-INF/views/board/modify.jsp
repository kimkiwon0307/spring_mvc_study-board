<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
			<form role="form" action="/fboard/modify" method="post">
			
				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
				<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
				<input type="hidden" name='type' value='<c:out value="${cri.type }"/>'>
				<input type="hidden" name='keyword' value='<c:out value="${cri.keyword}"/>'>

				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='f_no'
						value='<c:out value="${board.f_bno}"/>' readonly="readonly">
				</div>


				<div class="form-group">
					<label>Title</label> <input class="form-control" name='f_title'
						value='<c:out value="${board.f_title}"/>'>
				</div>
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='f_content' ><c:out value="${board.f_content}"/></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='f_writer'
					value='<c:out value="${board.f_writer}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>RegDate</label> <input class="form-control" name='f_date'
					value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.f_date}"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>RegDate</label> <input class="form-control" name='f_udate'
					value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.f_udate}"/>' readonly="readonly">
				</div>
				
				
				<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
				<button type="submit" data-oper='remove' class="btn btn-danger">remove</button>
				<button type="submit" data-oper='list' class="btn btn-info">List</button>
			 </form>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		
		var formObj = $("form");
		
		$('button').on("click", function(e){
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			if(operation === 'remove'){
				formObj.attr("action", "/fboard/remove");
			}else if(operation === 'list'){
				
				formObj.attr("action","/fboard/list").attr("method","get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			formObj.submit();
		});
	});
	
</script>
<%@include file="../includes/footer.jsp"%>