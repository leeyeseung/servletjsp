<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">content.jsp</div>
	<div class="card-body">
		<form method="post" action="UserJoinController">
			<div class="form-group">
				<label for="userId">ID</label> 
				<input type="text" class="form-control" id="userId" name="userId"> 
			</div>
			<div class="form-group">
				<label for="userName">Name</label> 
				<input type="text" class="form-control" id="userName" name="userName"> 
				
			</div>
			<div class="form-group">
				<label for="userPwd">Password</label> <input
					type="password" class="form-control" id="userPwd" name ="userPwd">
			</div>
			
			<div class="form-group">
				<label for="userAge">Age</label> <input
					type="text" class="form-control" id="userAge" name ="userAge">
			</div>
			
			<div class="form-group">
				<label for="userEmail">Email</label> <input
					type="email" class="form-control" id="userEmail" name ="userEmail">
			</div>
			
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>

	</div>
</div>




<%@ include file="/WEB-INF/views/common/footer.jsp"%>