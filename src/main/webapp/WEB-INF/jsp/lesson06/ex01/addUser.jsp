<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- bootstrap CDN link -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  	<%-- AJAX를 사용하려면 더 많은 함수가 있는 js를 포함해야 한다. --%>
 	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<form method="post" action="/lesson06/ex01/add_user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="col-3 form-control" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="col-3 form-control" placeholder="19940722">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="col-3 form-control" placeholder="email">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="col-5 form-control" rows="5"></textarea>
			</div>
			<!-- 1)form태그를 위한 submit버튼 -->
			<!-- <input type="submit" class="btn btn-success" value="화원가입"> -->
 		
 			<!-- AJAX를 위한 !!버튼!! -->
 			<!-- 그냥 button태그로 만들었는데 type을 안쓰면 기본으로 submit이 됨, ajax가 잘 수행이안됨 -->
 			<input id="join" type="button" class="btn btn-success" value="화원가입"> 
 		</form>
	</div>

	<script>
	
		$(document).ready(function(){
			//1)jquery의 submit기능 이용하기
			/* $('form').on('submit',function(e){
				//alert("서브밋");
				//e.preventDefault();//서브밋 되는 것을 막는다.(기본서브밋막아놓고 validation처리 후 따로함수를써 원하는 타이밍에 서브밋 할때 사용)
			
				//validation 서버에보내기전에 해야함
				let name = $('#name').val().trim();
				if (name.length == '') {
					alert('이름을 입력하세요');
					return false; //submit인경우 return false해야 서브밋 되지않는다
				}
				let yyyymmdd = $('#yyyymmdd').val().trim();
				if (yyyymmdd.length == '') {
					alert('생년월일을 입력하세요');
					return false;
				}
				//여기까지 도달하면 submit
				alert("서브밋");				
			});			 */
			
			//2)jquery의 AJAX통신 이용하기(ajax:form과 submit을 같이쓰지말것, form안써도됨)
			$('#join').on('click',function(){
				//alert("aaaa");
				//validation 서버에보내기전에 해야함
				let name = $('#name').val().trim();
				if (name.length == '') {
					alert('이름을 입력하세요');
					return ; 
				}
				let yyyymmdd = $('#yyyymmdd').val().trim();
				if (yyyymmdd.length == '') {
					alert('생년월일을 입력하세요');
					return ;
				}
				if (isNaN(yyyymmdd)){//모두 숫자가 아닌경우 참
					alert('숫자만 입력해주세요')
					return;
				}
				//CONSOLE로 확인하는 습관 들이기
				let email = $('#email').val().trim();
				console.log(email);
				let introduce = $('#introduce').val().trim();
				console.log(introduce);
				
				//AJAX
				$.ajax({
					//Request
					type:"POST" //type소문자!!
					, url:"/lesson06/ex01/add_user"
					, data:{"name":name,"yyyymmdd":yyyymmdd,"email":email,"introduce",introduce} //변수가 안만들어져도 보내짐!주의
					
					//Response  변수이름 data(관례적)
					, success:function(data){
						alert(data);
					}
					, complete:function(data){ //success error위주로만씀
						alert("완료");
					}
					, error:function(e){
						alert("에러");
					}
				})
			})
		});
	</script>
</body>
</html>