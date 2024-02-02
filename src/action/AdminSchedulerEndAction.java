package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import org.quartz.Scheduler;

import org.quartz.impl.StdSchedulerFactory;

 

import service.MemberService;

 

public class AdminSchedulerEndAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  HttpSession session = request.getSession();

  MemberService memberService = new MemberService();

  

  if(session.getAttribute("loginId")==null) {

   request.setAttribute("msg", "로그인이 필요합니다.");

   request.getRequestDispatcher("login.jsp").forward(request, response);

  }

  if(!"admin".equals(session.getAttribute("loginId"))) {

   request.setAttribute("msg", "관리자 로그인이 필요합니다.");

   request.getRequestDispatcher("login.jsp").forward(request, response);

  }

  

  Scheduler scheduler = new StdSchedulerFactory().getScheduler();

  scheduler.shutdown();

  System.out.println("<<< 포인트 스케줄러의 실행이 종료되었습니다. >>>");

  

  request.setAttribute("member_list", memberService.getMemberList());

  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);

 }

 

}