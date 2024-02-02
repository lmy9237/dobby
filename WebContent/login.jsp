<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<%@ page session="true" %>

<html>

<head>

 <title>Login</title>

 <style>
body>div {
   width:225px;
   margin:200px auto;
   padding:20px;
   border:1px solid #afafaf;   
}
tr > td input {
   width:100%;
}
 </style>

<%if(request.getAttribute("msg")!=null) {%>
  <script>alert('${msg}');</script>
<%}%>

</head>
<body>

 <div>
  <h1>로그인</h1>
  <form action="Controller?command=login_check_action" method="post">
   <table>
    <tr>
     <td>ID : </td>
     <td><input type="text" name="id"/></td>
    </tr>
    
    <tr>
     <td>PW : </td>
     <td><input type="password" name="pw"/></td>
    </tr>
    
    <tr>
     <td colspan="2"><input type="submit" value="로그인"/></td>
    </tr>
    
    <tr>
     <td colspan="2"><a href="Controller?command=register_member"><input type="button" value="회원가입"/></a></td>
    </tr>
    
   </table>
  </form>
 </div>
 
</body>
</html>