<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<%@ page session="false" %>

<%@ page import="dto.*" %>

<html>

<head>

 <title>Admin</title>

 <style>

  body>div {

   width:525px;

   margin:200px auto;

   padding:20px;

   border:1px solid #afafaf;   

  }

 </style>

</head>

<body>

 <div>

  <h1>회원관리-수정<span class="fr small gray">관리자</span></h1>

  <form action="Controller?command=admin_member_modify_update" method="post">

   <table>

    <tr>

     <td>ID</td>

     <td><input type="text" name="id" value="${member.id}" readonly/></td>

    </tr>

    <tr>

     <td>PW</td>

     <td><input type="text" name="pw" value="${member.pw}" /></td>

    </tr>

    <tr>

     <td>Name</td>

     <td><input type="text" name="name" value="${member.name}" /></td>

    </tr>

    <tr>

     <td>point</td>

     <td><input type="text" name="point" value="${member.point}" /></td>

    </tr>

    <tr>

     <td colspan="2"><input type="submit" value="제출" style="width:100%;"/></td>

    </tr>

   </table>

  </form>

 </div>

</body>

</html>