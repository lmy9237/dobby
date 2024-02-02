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
   request.setAttribute("msg", "삭제되었습니다.");
  else
   request.setAttribute("msg", "오류! 삭제되지 않았습니다. 오류코드=3004");
  request.setAttribute("member_list", memberService.getMemberList());
  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);

 }

 

}