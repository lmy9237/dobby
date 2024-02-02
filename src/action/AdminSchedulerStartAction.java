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
   request.setAttribute("msg", "�α����� �ʿ��մϴ�.");
   request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  if(!"admin".equals(session.getAttribute("loginId"))) {
   request.setAttribute("msg", "������ �α����� �ʿ��մϴ�.");
   request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  

  new SchedulerInit();
  System.out.println("<<< ����Ʈ �����ٷ��� ���۵Ǿ����ϴ�. >>>");

  

  request.setAttribute("member_list", memberService.getMemberList());
  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);
 }


}