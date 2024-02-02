package action;

 

public class ActionFactory {  // Singleton Pattern.

 private static ActionFactory instance = new ActionFactory();

 private ActionFactory() { }

 public static ActionFactory getInstance() {

  return instance;

 }

 

 public Action getAction(String command) {

  Action action = null;

  if(command==null) {

   return new LoginAction();

  }

  

  switch(command) {

  case "":

  case "login":
   action = new LoginAction();
   break;

  case "login_check_action":
   action = new LoginCheckAction();
   break;

  case "logout":
   action = new LogoutAction();
   break;

  case "advertiseClicked":
   action = new AdvertiseClickedAction();
   break;

  case "order":
   action = new OrderAction();
   break;

  case "mainpage":
   action = new MainpageAction();
   break;

  case "admin_member_modify":
   action = new AdminMemberModifyAction();
   break;
  case "admin_member_delete":
	   action = new AdminMemberDeleteAction();
  break;
  case "admin_member_modify_update":
   action = new AdminModifyUpdateAction();
   break;

  case "register_member":
   action = new RegisterMemberAction();
   break;

  case "register_member_insert":
   action = new RegisterMemberInsertAction();
   break;

  case "admin_scheduler_start":
   action = new AdminSchedulerStartAction();
   break;

  case "admin_scheduler_end":
   action = new AdminSchedulerEndAction();
   break;

  }

  return action;

 }

}