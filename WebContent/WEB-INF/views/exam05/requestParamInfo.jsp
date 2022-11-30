<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
   <div class="card-header">requestParamInfo.jsp</div>
   <div class="card-body">
      <a href="ParamController?pageNo=5&kind=freeboard&writer=winter&hobby=movie&hobby=game" class="btn btn-info btn-sm">GET 방식으로 전달</a>
      <hr />
      <form method="post" action="ParamController" novalidate>
         <div class="form-group">
            <label for="email">Email address:</label> 
            <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
         </div>
         <div class="form-group">
            <label for="pwd">Password:</label> 
            <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pwd">
         </div>

         <div class="form-group">
            <div>Hobby:</div>
            <div class="form-check-inline">
               <label class="form-check-label"> 
                  <input class="form-check-input" type="checkbox" name="hobby"  value="movie"> 영화보기
               </label>
            </div>
            <div class="form-check-inline">
               <label class="form-check-label"> 
                  <input class="form-check-input" type="checkbox" name="hobby" value="music"> 음악감상
               </label>
            </div>
            <div class="form-check-inline">
               <label class="form-check-label"> 
                  <input class="form-check-input" type="checkbox" name="hobby" value="game"> 게임하기
               </label>
            </div>
         </div>

         <div class="form-group">
            <div>Job:</div>
            <div class="form-check-inline">
               <label class="form-check-label"> 
                  <input type="radio" class="form-check-input" name="job" value="developer" checked> 개발자
               </label>
            </div>
            <div class="form-check-inline">
               <label class="form-check-label"> 
                  <input type="radio" class="form-check-input" name="job"  value="designer"> 디자이너
               </label>
            </div>
            <div class="form-check-inline disabled">
               <label class="form-check-label"> 
                  <input type="radio" class="form-check-input" name="job"  value="manager"> 관리자
               </label>
            </div>
         </div>
         <div class="form-group">
			  <label for="sel1">거주 도시:</label>
			  <select class="form-control" id="city" name="city" >
			    <option value="seoul" selected>서울</option>
			    <option value="daejoen">대전</option>
			    <option value="jeju">제주</option>

			  </select>
		</div>

         <button type="submit" class="btn btn-primary btn-sm">Post 방식으로 전달</button>
        
      </form>
      
      <hr/>
      <form method="post" enctype="multipart/form-data" action="FileUploadController">
     	 <div class="form-group">
            <label for="title">Title:</label> 
            <input type="text" class="form-control" placeholder="Title" id="title" name="title">
         </div>
          <div class="form-group">
            <label for="desc">Desc:</label> 
            <input type="text" class="form-control" placeholder="desc" id="desc" name="desc">
         </div>
  		<div class="form-group">
   		 <label for="attach">Attach</label>
   		 <input type="file" class="form-control-file" id="attach1" name="attach">
   		 <input type="file" class="form-control-file" id="attach2" name="attach">
   		 <input type="file" class="form-control-file" id="attach3" name="attach">
  		</div>
  		  <button type="submit" class="btn btn-success btn-sm">Post 방식/멀티파트로 전달</button>
	</form>
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>