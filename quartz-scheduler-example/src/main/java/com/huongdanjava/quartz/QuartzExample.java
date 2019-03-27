package com.huongdanjava.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzExample {

	public static void main(String[] args) throws SchedulerException {
		Trigger trigger = TriggerBuilder.newTrigger()
			.withIdentity("huongdanjavaTrigger", "group")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5)
					.repeatForever()
			)
			.build();

		JobDetail job = JobBuilder.newJob(QuartzJob.class)
			.withIdentity("huongdanjavaJob", "group")
			.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

}
