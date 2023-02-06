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

<title>이름 중복확인</title>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<div class="form-group ">
			<label for="name">이름</label>
			<div class="d-flex">	
				<input type="text" id="name" class="form-control col-3 ">
				<!-- name으로 셀렉터를 안잡아도되서 id만필요, name="name"은 필요없음 -->
				<button type="button" id="nameCheckBtn" class="btn btn-info">중복확인</button>	
			</div>
			<small id="nameStatusArea"></small>
		
		</div>
		
		<button type="button" id="joinBtn" class="btn btn-success">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function(){
			//중복확인 버튼 클릭
			$('#nameCheckBtn').on('click',function(){
				//alert('111');
				//nameStatusArea의 하위태크 초기화
				$('#nameStatusArea').empty();
				
				let name = $('#name').val().trim(); //ajax request data로보냄
				
				//이름 입력 validation test
				if(name == ''){
					//alert('이름을 입력하세요');
					//태그추가 함수(append), text추가하는 함수도있음(누를때마다추가되니 초기화필요)
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					//리턴중요!
					return;
				}
				//이름중복확인 -> db에서 조회 => AJAX통신
				$.ajax({
					//request
					type:'get'
					,url:"/lesson06/ex02/is_duplication"
					,data:{"name":name}
					
					//response
					,success:function(data){
						//alert(data.is_duplication);
						if(data.is_duplication){
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
						}
						
					}
					,error:function(e){
							alert("실패"+e); //서버에 요청이 안갓다,ajax자체가 실패->request확인할것
					}	
					
				})				
			})
		})
	
	</script>
</body>
</html>