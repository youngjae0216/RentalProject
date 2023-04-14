<%@page import="java.util.ArrayList"%>
<%@page import="client.ClientRequestDto"%>
<%@page import="java.util.Random"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header" />
<c:import url="header"/>
<body>
	<%
	DBManager.getConnection();
	%>
	<section>
		<h2>렌트카 서비스 프로젝트</h2>
		
		<%--
		EL Tag : JSP Expression Language
		jsp 문서 안에서 ${} 태그 안에 연산식 또는 참조변수 등을 작성함.
		--%>
		<%
		String id = "apple";
		%>		
		<p><%=id %></p>
		<p>${"apple" }</p>
		
		<%-- 산술연산 --%>
		<p>${1+2 }</p>
		<p>${1-2 }</p>
		<p>${1/2 }</p>
		<p>${1*2 }</p>
		<p>${1%2 }</p>
		<%-- 비교연산 --%>
		<p>${1==2 } ${1 eq 2 } equals </p>
		<p>${1!=2 } ${1 ne 2 } not equals </p>
		<p>${1<2 } ${1 lt 2 } less than </p>
		<p>${1>2 } ${1 gt 2 } grater than </p>
		<p>${1<=2 } ${1 le 2 } less than and equals </p>
		<p>${1>=2 } ${1 ge 2 } grather than and equals </p>
		<%-- 논리연산 --%>
		<p>${1<2 && 2<3 } ${1<2 and 2<3 }</p>
		<p>${1<2 || 2<3 } ${1<2 or 2<3 }</p>
		<p>${!(1<2)} ${not (1<2)}</p>
		<%-- null 연산 --%>
		<p>null : ${null }</p>
		<p>empty null : ${empty null }</p><!-- 유용하게 쓰임 -->
		
		<%-- 파라미터 값 얻어오기 --%>
		<p>empty param.id : ${empty param.id }</p>
		<p>param.id : ${param.id }</p> <!-- 알아서 형변환도 해줌 -->
		<p>${param.val1 + param.val2}</p>
		
		<%-- EL 태그로 내장객체에 접근하기 --%>
		<!-- 
		1) page
		2) request
		3) session
		4) application
		 -->
		
		<%
		pageContext.setAttribute("pageVal", "페이지 영역의 데이터입니다.");
		request.setAttribute("requestVal", "리퀘스트 영역의 데이터입니다.");
		session.setAttribute("sessionVal", "세션 영역의 데이터입니다.");
		application.setAttribute("appVal", "애플리케이션 영역의 데이터입니다.");
		%>
		<p>page : ${pageScope.pageVal } ${pageVal }</p>
		<p>request : ${requestScope.requestVal } ${requestVal }</p>
		<p>session : ${sessionScope.sessionVal } ${sessionVal }</p>
		<p>app : ${applicationScope.appVal } ${appVal }</p>
		
		<!-- 겹치는 데이터가 없다면 스코프 생략도 가능하다. -->
		<!-- 4가지 영역의 내장 객체 속성명이 유일하다면, Scope키워드를 생략할 수 있다. 하지만 권장하지 않는다. -->
		
		<%-- JSTL --%>
		<p>
		<c:out value="${1+ 10 }"></c:out>
		</p>
		<c:url var="rental" value="rental"></c:url>
		<%-- <c:redirect url="${rental }"></c:redirect> --%>
		
		<%
		ClientRequestDto cd = new ClientRequestDto(); 
		pageContext.setAttribute("data", cd);
		%>
		<!-- core set 태그 사용벙법 1) -->
		<!-- setAttribute(속성명, 속성값)  -->
		<c:set var="cd" value="${pageScope.data }" scope="session"></c:set>
		
		<!-- core set 태그 사용벙법 1) -->
		<!-- setProperty()  -->
		<!-- public setter 가 있는 속성값에 한하여 설정 가능 -->
		<c:set target="${cd }" property="name" value="야야야"></c:set>
		
		<!-- public getter 가 있는 속성값에 한하여 .속성명 으로 얻어올 수 있다 -->
		<p>cd : <c:out value="${cd.name }"/></p>
		<p>cd : <c:out value="${cd.getName() }"/></p>
		
		<!-- 제거 -->
		<c:remove var="cd"/>
		<p>cd : <c:out value="${empty cd.getName() }"/></p>
		
		<!-- if -->
		<c:if test="${1>2 }"> <!-- true면 버튼보임 -->
			<button>click</button>
		</c:if>
		
		<%if(1>2){ %>
			<button>click</button>
		<%} %>
		
		<!-- choose -->
		<!-- when 이 if, else if 이고 
			 otherwise는 else -->
		<c:choose>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
		<!-- import  -->
		<!-- 
		<jsp:include page="/header" />
		아래거와 동일 
		<c:import url="header"/>
		-->
		
		<!-- import 커맨드 밸류 서비스 서블릿으로 보내기 
		<c:import url="service">
			<c:param name="command" value="hello world"></c:param>
		</c:import>
		-->
		
		
		<%
		ArrayList<ClientRequestDto> list = new ArrayList<>();
		list.add(new ClientRequestDto("홍길동"));
		list.add(new ClientRequestDto("홍둘리"));
		list.add(new ClientRequestDto("도우너"));
		list.add(new ClientRequestDto("홍희동"));
		list.add(new ClientRequestDto("마이콜"));
		
		pageContext.setAttribute("list", list);
		%>
		
		<c:forEach items="${pageScope.list }" var="member" varStatus="info"> <!-- begin="1" step="2" -->
			<p>${info.index } [${info.count }] (${info.first } / ${info.last }) : ${member.name }</p>
		</c:forEach>
		
		<!-- foreach 랑 비슷 구분자 "/"만 들어간거 -->
		<c:forTokens items="가/나/다" delims="/" var="data">
			<p>${data }</p>
		</c:forTokens>
		
		
		
		
		
		
	</section>
</body>
<jsp:include page="/footer" />
</html>