package com.batchTask.DbPoller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class UserDetailsJobListener implements JobExecutionListener{
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsJobListener.class);
	private Date startTime, endTime;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		startTime = new Date();
		log.info("User Details Job Started at: "+ startTime);
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		endTime = new Date();
		if(jobExecution.getStatus() == BatchStatus.COMPLETED)
			log.info("User Details Job Completed successfully at: "+ endTime);
		else if(jobExecution.getStatus() == BatchStatus.FAILED)
			log.info("User Details Job Failed!");
	}

}
