<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain."/>
	
	<h1>1.길이 구하기</h1>
	${fn:length(str1)}
	
	<h1>2.특정 문자열이 있는지 확인</h1>
	No가 있는가? ${fn:contains(str1,'No')}<br>
	no가 있는가? ${fn:contains(str1,'no')}<br>
	
	<c:if test="${fn:containsIgnoreCase(str1,'no')}">
	문장에 no라는 문자열이 존재. 대소문자구별 안함
	</c:if>
	
	<h1>3.특정 문자열로 시작하는지 확인</h1>
	No로 시작하는가 ${fn:startsWith(str1,'No')}
	<h1>4.특정 문자열로 시작하는지 확인</h1>
	n로 끝나는가 ${fn:endsWith(str1,'n')}<br>
	.으로 끝나는가 ${fn:endsWith(str1,'.')}<br>
	
	<h1>5.문자열치환</h1>
	<c:set var="str2" value="I love chiken"/>
	${str2}<br>
	${fn:replace(str2,'chiken','bread')}
	
	<h1>6.구분자로 잘라서 배열 만들기</h1>
	${fn:split(str1,'.')[0]}<br>
	${fn:split(str1,".")[1]}<br>
	
	<h1>7.시작 인덱스부터 종료인덱스까지 자르기</h1>
	${fn:substring(str2,2,6)}
	
	<h1>8.모두 소문자로 변경</h1>
	${fn:toLowerCase(str2)}
	
	<h1>8.모두 대문자로 변경</h1>
	${fn:toUpperCase(str2)}
	
	<h1>10.앞뒤 공백 제거</h1>
	<c:set var="str3" value="     h e  ll      o   ." />
	<pre>str3: ${str3}</pre>
	<pre>str3: trim: ${fn:trim(str3)} </pre>
	
</body>
</html>