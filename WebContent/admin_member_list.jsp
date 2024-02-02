<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<%@ page session="false" %>
<%@ page import="dto.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <title>Admin</title>
 <style>
  body>div {
   width:525px;
   margin:20px auto;
   padding:20px;
   border:1px solid #afafaf;   
  }

  body>div table {
   border-collapse: collapse;
  }

  body>div table th, body>div table td {
   width:100px;
   border:1px solid #afafaf;
   text-align:center;
  }

  tr > td input {
   width:100%;
  }
  .fr { float:right; }
  .fl { float:left; }
  .small { font-size:0.5em; }
  .gray { color:#9f9f9f; }
 </style>

 <%if(request.getAttribute("msg") != null) {%>
   <script>alert('${msg}');</script>
 <%}%>

</head>
<body>

 <div>

  <h1>회원관리<span class="fr small gray"><a href="login.jsp"><button>로그인</button></a></span></h1>

  <table>

   <tr>

    <th>ID</th>
    <th>PW</th>
    <th>Name</th>
    <th>Point</th>
    <th>수정</th>
    <th>삭제</th>
   </tr>

   <c:forEach var="m" items="${member_list}">
    <tr>
     <td><c:out value="${m.id}"/></td>
     <td>${m.pw}</td>
     <td>${m.name}</td>
     <td>${m.point}</td>
     <td><a href="Controller?command=admin_member_modify&id=${m.id}"><button>수정</button></a>
     <td><a href="Controller?command=admin_member_delete&id=${m.id}"><button>삭제</button></a>
    </tr>

   </c:forEach>   
  </table>
  <br/>
  <h1>스케줄러관리</h1>
  <a href="Controller?command=admin_scheduler_start"><button>스케줄러(20초마다 포인트1 증가) 실행 시작</button></a>
  <a href="Controller?command=admin_scheduler_end"><button>스케줄러 실행 종료</button></a>
 </div>

</body>

</html>