<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<a href="${pageContext.request.contextPath}/exam04/HtmlResponseController" class="btn btn-info btn-sm">HTML 응답 생성</a>
		<a href="${pageContext.request.contextPath}/exam04/JSONResponseController" class="btn btn-info btn-sm">JSON 응답 생성</a>
		<a href="${pageContext.request.contextPath}/exam04/FileResponseController" class="btn btn-info btn-sm">파일 다운로드 응답 생성</a>
		
	</div>
</div>

<div class="card m-2">
	<div class="card-header">
		redirect
	</div>
		<div class="card-body">
			<form method="post" action="${pageContext.request.contextPath}/exam04/ContentController">
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="email" class="form-control" placeholder="Enter email" id="email">
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="pwd">
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
			
			
		</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>