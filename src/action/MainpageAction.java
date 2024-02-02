package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import service.MemberService;
public class MainpageAction implements Action {

 @Override
 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  HttpSession session = request.getSession();
  MemberService memberService = new MemberService();


  String id = "";
  if(session.getAttribute("loginId") != null) {
   id = (String)(session.getAttribute("loginId"));
   request.setAttribute("member", memberService.getMemberById(id));
  }

  

  request.getRequestDispatcher("mainpage.jsp").forward(request, response);
 }

 

}