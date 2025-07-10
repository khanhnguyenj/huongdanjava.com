package com.huongdanjava.spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Hello extends QuartzJobBean {

  private Student student;

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    System.out.println("Hello from Huong Dan Java, " + student.getName());
  }

  public void setStudent(Student student) {
    this.student = student;
  }

}
