<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title>MovieFan : 내 평점등록</title>
   <link type="image/png" href="/resources/images/logo/moviefan-favicon.png" rel="icon"/>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
	<form class="border bg-light p-3" method="post" action="commentForm">
	<h4>내 평점등록</h4>
	<div class="row mb-3">
		<div class="col-6">
	  		<strong>영화검색</strong>
	  		<input type="text" placeholder="영화를 검색하세요." />
	  		<button type="button" class="btn btn-secondary">검색</button>
	  		<div>
	  			<label class="form-label">Movie_no</label>
	  			<input type="number" name="movieNo">
	  		</div>
	  	</div>
  		<div class="col-6">
  			<div class="btn-group me-2 mb-3" id="button-box">
				<button type="button" class="btn" id="1"><i class="bi bi-star"></i></button>
				<button type="button" class="btn" id="2"><i class="bi bi-star"></i></button>
			   	<button type="button" class="btn" id="3"><i class="bi bi-star"></i></button>
			    <button type="button" class="btn" id="4"><i class="bi bi-star"></i></button>
				<button type="button" class="btn" id="5"><i class="bi bi-star"></i></button>
			</div>
			<label class="form-label">별점</label>
			<input type="number" class="" name="rating" />
			<div class="form-floating mb-3">
			  <textarea class="form-control" name="content" id="floatingTextarea"></textarea>
			  <label for="floatingTextarea">한줄 평을 작성해주세요.</label>
			</div>
			<div>
	  			<label class="form-label">Customer_no</label>
	  			<input type="number" name="customerNo">
	  		</div>
			<div class="d-grid g-2 justify-content-md-end">
				<button type="submit" class="btn btn-secondary">등록</button>
			</div>
  		</div>
  	</div>
	</form>
</div>
<script type="text/javascript">
	$("#button-box button").mouseenter(function() {
		var rating = $(this).attr("id");
		$(this).closest('div').find("button").find('i').removeClass('bi-star-fill').addClass('bi-star')
		$(this).closest('div').find("button:lt("+parseInt(rating)+")").find('i').removeClass('bi-star').addClass('bi-star-fill');
		
		console.log(rating);
	})
</script>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</html>