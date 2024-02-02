<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<%@ page session="true" %>

<html>

<head>

 <title>Mainpage</title>

 <style>

  body>div {

   width:1060px;

   margin:20px auto;

   padding:20px;

   border:1px solid #afafaf;   

  }

  h1 p { font-size:0.5em; }

  .fr { float:right; }

  .border { border:1px solid #afafaf; }

  table td { text-align:center;}

  img { cursor:pointer; }

 </style>

 <%

  if(request.getAttribute("msg")!=null) {

 %>

   <script>alert('${msg}');</script>

 <%

  }

 %>

 <%

  if(request.getAttribute("url")!=null) {

 %>

   <script>location.href='${url}';</script>

 <%

  }

 %>

 <%

  if(session.getAttribute("loginId")==null) {

   request.setAttribute("msg", "로그인이 필요합니다");

   request.getRequestDispatcher("/").forward(request, response);

  }

 %>

 <script>

  function advertise() {

   alert("1000점이 적립되었습니다.");

   location.href="Controller?command=advertiseClicked";

  }

 </script>

</head>

<body>

 <div>

  <h1>

   메인페이지

   <p class="fr">

    ${member.name}(${member.id})님 안녕하세요. <a href="Controller?command=logout"><button>로그아웃</button></a><br/>

    포인트 : ${member.point}점

   </p>

  </h1>

  <div style="clear:both;"></div>

  <h3>구입할 컨텐츠를 선택하세요.</h3>

  <table>

   <tr>
 	<td><a href="Controller?command=order&cid=intro"><img src="img/2_Intro_350_441.png"/></a></td>
    <td><a href="Controller?command=order&cid=java"><img src="img/2_Java_350_441.png"/></a></td>
    <td><a href="Controller?command=order&cid=cpp"><img src="img/2_Cpp_350_441.png"/></a></td>
   </tr>

   <tr>

    <td>100,000포인트</td>

    <td>500,000포인트</td>

    <td>300,000포인트</td>

   </tr>

  </table>

  <br/><br/>

  <div id="advertise" class="fr border">

   <광고><br/> 

   <img src="img/korea_it.png" onclick="advertise()"/>

  </div>

  <div style="clear:both;"></div>

 </div>

</body>

</html>