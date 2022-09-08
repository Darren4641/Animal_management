<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1024kb"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "/search.do" method = "post" style="width:60%; float:left;">
         검색: <input type = "text" name = "name" value = "" maxlength = "100" />
         <input type = "submit" value ="Submit" />
</form>
<input type = "button"  onclick="location.href='/add.do';" value="추가" style="float:left;">
<input type = "button"  onclick="location.href='/list_order.do?code=name';" value="이름 정렬" style="float:left; margin-left:4px;" >
<input type = "button"  onclick="location.href='/list_order.do?code=owner';" value="주인 이름 정렬" style="float:left;">
<br/>
<hr>
<br/>
<c:choose>
	<c:when test="${empty list }">
		<table style="margin:0 auto;">
			<td style="height:300px;">
				게시판에 저장된 글이 없습니다.
			</td>
		</table>
	</c:when>
	
	<c:otherwise>
	
		<table border="1px" style="margin:0 auto;position: absolute; ">
			<thead>
				<tr>
					<th style="width:6%;">이름</th>
					<th style="width:6%;">생년월일</th>
					<th style="width:6%;">종류</th>
					<th style="width:6%;">품종</th>
					<th style="width:6%;">주인 이름</th>
					<th style="width:6%;">전화번호</th>
					<th style="width:6%;">작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ list }"  var="dto" varStatus="i">
				<tr>
					<td>${ dto.name }</td>
					<td>${ dto.birth }</td>
					<td>${ dto.kind }</td>
					<td>${ dto.category }</td>
					<td>${ dto.owner }</td>
					<td>${ dto.ownerPhone }</td>
					<td>${ dto.createDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</c:otherwise>
</c:choose>

</body>
</html>