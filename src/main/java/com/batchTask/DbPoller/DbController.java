package com.batchTask.DbPoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("http://localhost:8083")
public class DbController {

	private static final Logger log = LoggerFactory.getLogger(DbController.class);

//	@Autowired
//	JobLauncher jobLauncher;
//
//	@Autowired
//	@Qualifier("job2")
//	Job job2;
	
	@Autowired
	private ScheduleJob scheduleJob;

	@GetMapping("/launch")
	public void showData() throws Exception {
		
		scheduleJob.toggle();
	}
	

	/*
	 * execution start time
	 * exe end time
	 * number of retries
	 * */
//
//	@GetMapping("/acknowledged/{ack}")
//	public String updateData(@PathVariable("ack") String ack) throws Exception {
//		if (ack.equals("COMPLETED")) {
//			JobExecution jobExecution = null;
//			try {
//				jobExecution = jobLauncher.run(job2, new JobParameters());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "jobExecution's info: Id = " + jobExecution.getId() + " ,status = " + jobExecution.getExitStatus();
//		}
//		else {
//			return "Data Processing is NOT COMPLETED SUCCESSFULLY";
//		}
//	}
}
