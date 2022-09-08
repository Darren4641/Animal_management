<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1024kb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

   <head>
      <title>HTML form Tag</title>
   </head>

   <body>
      <form action = "/addPet.do" method = "post">
         이름: 
            <input type = "text" name = "name" value = "" maxlength = "100" />
         <br />
         생년월일: 
            <input type="date" name = "birth" value = "" maxlength = "100" />
         <br />
         종류: 
            <input type = "text" name = "kind" value = "" maxlength = "100" />
         <br />
         품종: 
            <input type = "text" name = "category" value = "" />
         <br />
         주인이름: 
            <input type = "text" name = "owner" value = "" maxlength = "100" />
         <br />
         전화번호: 
            <input type = "text" name = "ownerPhone" value = "" maxlength = "100" />
         <input type = "submit" value ="Submit" />
      </form>
   </body>

</html>