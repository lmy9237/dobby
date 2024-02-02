package action;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

public class LoginAction implements Action {

 

 @Override

 public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
  request.getRequestDispatcher("login.jsp").forward(request, response);

 }

 

}