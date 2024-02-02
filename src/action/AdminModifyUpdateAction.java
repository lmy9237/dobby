package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import dto.MemberDto;

import service.MemberService;

 

public class AdminModifyUpdateAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  MemberService memberService = new MemberService();

  MemberDto dto = new MemberDto(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"), Integer.parseInt(request.getParameter("point")));

  

  int result = memberService.updateMemberById(dto);

  if(result==1)

   request.setAttribute("msg", "수정되었습니다.");

  else

   request.setAttribute("msg", "오류! 수정되지 않았습니다. 오류코드=1004");

    

  request.setAttribute("member_list", memberService.getMemberList());

  request.getRequestDispatcher("admin_member_list.jsp").forward(request, response);

 }

 

}