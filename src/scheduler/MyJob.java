package scheduler;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import service.MemberService;

 

public class MyJob implements Job {
 public void execute(JobExecutionContext context) throws JobExecutionException {  
  MemberService memberService = new MemberService();

  

  int result = -1;
  try {
   result = memberService.gainAllMembersPoint();
  } catch (Exception e) {
   e.printStackTrace();
  }
  System.out.println("Job이 실행됨  : " + new Date(System.currentTimeMillis()) + " / " + result + "명에게 포인트 부여(1점).");
 }  
}  