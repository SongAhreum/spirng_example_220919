<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>JSTL Core라이브러리(1)</title>
</head>
<body>
	<h1>1.변수 정의하기(c:set)</h1>
	<%--java코드에 주석처리하는방법으로 jstl구문도 이렇게주석처리 <!--html주석-->는 안됨 --%>
	<c:set var="num1" value="100"/>
		num1 : ${num1}<br>
	<c:set var="num2">250</c:set>
		num2 : ${num2}<br>
		num1 + num2 : ${num1+num2} <%-- 숫자끼리만 더할 수 있다 --%>
	<hr>
	
	<h1>2.변수 출력하기 (c:out)</h1>
		num1 : <c:out value="${num1}"/><br>
	<c:out value="Hello world!!"/><br>
	
	<%-- 문구그대로 출력 --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>"/><br>
	<%-- 문구그대로 출력 --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="true"/>
	<%-- 스크립트가 수행된다. --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="false"/>
	<%-- 문구그대로 출력 ,두경우 동일--%>
	<c:out value="<script>consol.log(alert('얼럿창 띄우기'));</script>" escapeXml="false"/>
	<script>consol.log(alert('얼럿창 띄우기'));</script>
	<hr>
	
	<h1>3.조건문 (c:if)</h1>
	<c:if test="${num1>50}">
		num1은 50보다 크다<br>
	</c:if>
	
	<c:if test="${num1 == 100 }">
		num1은 100이다<br>
	</c:if>
	<c:if test="${num1 eq 100 }"> <%--eq예약어로 쓰는게 정석이긴함,상관없 --%>
		num1은 100이다<br>
	</c:if>
	<c:if test="${num1 ne 222 }"> <%-- !=로써도되고 ne로써도 된다 --%>
		num1은 222가 아니다<br>
	</c:if>
	
	<%-- model에들어있는게 비어잇는지, 비어있을때 화면을 어떻게 분개할지 등등에 자주사용 --%>
	<c:if test="${not empty num1}">
		num1은 비어있지 않다
	</c:if>
	<br>
	<c:if test="${!empty num1}">
		num1은 비어있지 않다
	</c:if>
	
</body>
</html>