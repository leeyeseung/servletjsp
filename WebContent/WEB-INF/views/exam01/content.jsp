<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		JSP와 서블릿의 차이점
	</div>
	<div class="card-body">
		<a href="/servletjsp/views/exam01/boardList.jsp" class="btn btn-info btn-sm">JSP 요청</a>
		<a href="/servletjsp/exam01/BoardListController" class="btn btn-info btn-sm">Servlet 요청</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>