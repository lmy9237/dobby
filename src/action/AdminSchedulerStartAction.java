package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import scheduler.SchedulerInit;

import service.MemberService;

 

public class AdminSchedulerStartAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  MemberService memberService = new MemberService();

  HttpSession session = request.getSession();




  if(session.getAttribute("loginId")==null) {
   request.setAttribute("msg", "로그인이 필요합니다.");
   request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  if(!"admin".equals(session.getAttribute("loginId"))) {
   request.setAttribute("msg", "관리자 로그인이 필요합니다.");
   request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  

  new SchedulerInit();
  System.out.println("<<< 포인트 스케줄러가 시작되었습니다. >>>");

  

  request.setAttribute("member_list", memberService.getMemberList());
  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);
 }


}