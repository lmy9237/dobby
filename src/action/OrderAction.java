package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import dto.MemberDto;

import service.MemberService;

 

public class OrderAction implements Action {

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  HttpSession session = request.getSession();

  MemberService memberService = new MemberService();

  

  if(session.getAttribute("loginId")==null) {

   request.setAttribute("msg", "�α����� �ʿ��մϴ�.");

   request.getRequestDispatcher("Controller?command=login").forward(request, response);

  }

  String cid = request.getParameter("cid");

  // intro 100 , java 500 , cpp 300

  int pointToPay = 0;

  switch(cid) {

  case "intro": pointToPay = 100_000; break;

  case "java": pointToPay = 500_000; break;

  case "cpp": pointToPay = 300_000; break;

  }

  String id = (String)(session.getAttribute("loginId"));

  MemberDto member = memberService.getMemberById(id);

    

  if(member.getPoint() >= pointToPay) {

   memberService.gainMemberPoint(id, -pointToPay);
   member.setPoint(member.getPoint()-pointToPay);

   request.setAttribute("msg", "������("+cid+")�� �����Ͽ����ϴ�.");
  } else {

   request.setAttribute("msg", "����Ʈ�� �����մϴ�. ���� Ŭ���ϼ���.");

  }

  request.getRequestDispatcher("order_result.jsp").forward(request, response);

 }

}