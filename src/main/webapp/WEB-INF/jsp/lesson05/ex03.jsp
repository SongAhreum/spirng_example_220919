<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
</head>
<body>
	<c:set var="num" value="12345678"/>
	<h1>숫자 출력</h1>
	<%-- el문법도 출력가능, c:out으로도 출력가능 --%>
	<fmt:formatNumber value="${num }" />
	
	<h1>Type</h1>
	숫자: <fmt:formatNumber value="${num}" type="number"/><br>
	숫자 3자리마다 쉼표 제거 <fmt:formatNumber value="${num}" type="number" groupingUsed="false"/><br>
	
	<%-- %는 1이 100 퍼센트이다 --%>
	100%<fmt:formatNumber value="1" type="percent"/><br>
	40% <fmt:formatNumber value="0.4" type="percent" /><br>
	
	통화(원): <fmt:formatNumber value="${num}" type="currency" /><br>
	통화(달러): <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/>
	
	<h1>var로 변수에 저장</h1>
	<fmt:formatNumber var="doller" value="${num}" type="currency" currencySymbol="$"/>
	달러를 EL로 출력: ${doller} <br>
	달러를 c:out으로 출력 <c:out value="${doller}"/><br>
	
	<h1>Pattern</h1>
	3.14: <fmt:formatNumber value="3.14"/><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000"/><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####"/><br>
	3.14159(#.####): <fmt:formatNumber value="3.14159" pattern="#.####"/><br>
	
	<h1>Date객체를 String형태로 출력=> fmt:formatDate</h1>
	<fmt:formatDate var="pattern1" value="${today}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
	pattern1: ${pattern1}<br>
	<fmt:formatDate var="pattern2" value="${today}" pattern="yyyy/MM/dd  HH:mm:ss"/>
	pattern2: ${pattern2}<br>
	
	<h1>String을 Date객체로 변환 =>fmt:parseDate</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd  HH:mm:ss"/><br>
	<fmt:parseDate var="date2" value="${pattern2}" pattern="yyyy/MM/dd  HH:mm:ss"/>
	Date객체: ${date2}
</body>
</html>