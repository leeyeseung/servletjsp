<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		content10.jsp
	</div>
	<div class="card-body">
		<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/exam10/ExceptionHandlingController">예외 처리(try-catch)</a>
		<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/exam10/NoExceptionHandlingController">예외 처리(web.xml)</a>	
		
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>