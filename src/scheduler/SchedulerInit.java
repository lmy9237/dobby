package scheduler;

 

import java.text.ParseException;

 

import javax.servlet.http.HttpServlet;

 

import org.quartz.JobDetail;

import org.quartz.Scheduler;

import org.quartz.SchedulerException;

import org.quartz.SchedulerFactory;

import org.quartz.Trigger;

import org.quartz.impl.JobDetailImpl;

import org.quartz.impl.StdSchedulerFactory;

import org.quartz.impl.triggers.CronTriggerImpl;

 

public class SchedulerInit extends HttpServlet { 

 private static final long serialVersionUID = 1L;

 

 private SchedulerFactory schedulerFactory;  

 private Scheduler scheduler;  

   

 public SchedulerInit() {  

  try {  

   schedulerFactory = new StdSchedulerFactory();  

   scheduler = schedulerFactory.getScheduler();  

     

   //"job이름, 그룹명, 동작시킬Class"  

   JobDetail job1 = new JobDetailImpl("myJob1", "group1", MyJob.class);  

 

   // 20초마다 한번씩 실행. --> 'cron 표현식'

   Trigger trigger1 = new CronTriggerImpl("myTrigger1", "group1", "0/20 * * * * ?");  

 

   scheduler.scheduleJob(job1, trigger1);  
   scheduler.start();  
  } catch (SchedulerException e) {  
   e.printStackTrace();  
  } catch (ParseException e) {
   e.printStackTrace();

  }

 }  

   

// public static void main(String[] args) {  

//  new SchedulerInit();  

// }  

}  