package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

public class LogoutAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

  HttpSession session = request.getSession();

  session.removeAttribute("loginId");
  request.setAttribute("msg", "로그아웃 되었습니다.");
  request.getRequestDispatcher("Controller?command=login").forward(request, response);
 }

 

}