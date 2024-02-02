package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import dto.MemberDto;

import service.MemberService;

 

public class RegisterMemberInsertAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  MemberService memberService = new MemberService();
  MemberDto dto = new MemberDto(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"), 0);
  int result = memberService.registerMember(dto);

  if(result==1) 

   request.setAttribute("msg", "가입되었습니다. 로그인 해주세요.");

  else

   request.setAttribute("msg", "오류! 가입이 되지 않았습니다. 오류코드 = 2004");
  request.getRequestDispatcher("login.jsp").forward(request, response);

 }

 

}