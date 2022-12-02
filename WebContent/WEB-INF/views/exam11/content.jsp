<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		content11.jsp
	</div>
	<div class="card-body">
		1. ${5} <br/>
		2. ${"홍길동"} <br/>
		
		<h4 class="mt-3"> 산술연산자</h4>
		3. ${2+5} <br/>	
		4. ${7 mod 3} <br/>
		5. ${7 % 3 } <br/>
		
		<h4 class="mt-3"> 논리연산자</h4>
		6. ${true and true} <br/>
		7. ${true && true} <br/>
		
		8. ${false or true } <br/>
		9. ${false || true } <br/>
		
		10. ${!true } <br/>
		11 ${not true} <br/>
		
		<h4 class="mt-3">비교연산자</h4>
		12. ${2 > 5} , ${2 gt 5} <br/>
		13. ${2 < 5} , ${2 lt 5}  <br/>
		14. ${2 >= 5} , ${2 le 5} <br/>
		15. ${2 >=  5} , ${2 ge 5} <br/>
		16. ${2 != 5}  <br/>
		
		17. ${empty null} <br/>
		18. ${empty ""} <br/>
		
		<h4 class="mt-3"> pageContent를 이용해서 request, response, session의 Getter 리턴값 얻기</h4>
		19. ${pageContext.request.contextPath} <br/>
		
		<h4 class="mt-3"> request범위-> session범위 -> application범위 순으로 저장된 이름 값을 출력</h4>
		20. ${user.userId}, ${user.userName} <br/>
		21. ${board.bno}, ${board.btitle}, ${board.bcontent} <br/>
		22. ${info} <br/>
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>