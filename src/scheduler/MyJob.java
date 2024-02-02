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
  System.out.println("Job�� �����  : " + new Date(System.currentTimeMillis()) + " / " + result + "���� ����Ʈ �ο�(1��).");
 }  
}  