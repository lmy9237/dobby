package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import service.MemberService;

 

public class AdminMemberDeleteAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  MemberService memberService = new MemberService();
  String id = request.getParameter("id");

  int result = memberService.deleteMember(id);
  if(result==1) 
   request.setAttribute("msg", "�����Ǿ����ϴ�.");
  else
   request.setAttribute("msg", "����! �������� �ʾҽ��ϴ�. �����ڵ�=3004");
  request.setAttribute("member_list", memberService.getMemberList());
  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);

 }

 

}