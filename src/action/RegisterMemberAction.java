package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

public class RegisterMemberAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
  request.getRequestDispatcher("register.jsp").forward(request, response);

 }

 

}