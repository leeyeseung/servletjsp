<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">게시물 쓰기</div>
	<div class="card-body">
		<form method="post" action="WriteController" enctype="multipart/form-data">
			<div class="form-group">
				<label for="btitle">Title</label> 
				<input type="text" class="form-control" id="btitle" name="btitle"> 
			</div>
			<div class="form-group">
				<label for="bcontent">Content</label> 
				<textarea rows="5" cols="50" name = "bcontent" id="bcontent" class="form-control"></textarea> 
				
			</div>
			<div class="form-group">
				<label for="bwriter">Writer</label> 
				<input type="text" class="form-control" id="bwriter" name="bwriter"> 
			</div>
			<div class="form-group">
				<label for="battach">Writer</label> 
				<input type="file" class="form-control" id="battach" name="battach"> 
			</div>
			
			
			<button type="submit" class="btn btn-primary">게시물 등록</button>
		</form>

	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>