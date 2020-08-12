package com.batchTask.DbPoller;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleJob {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
//	@Qualifier("job1")
	Job job1;
	
	private final AtomicBoolean enabled = new AtomicBoolean(false);

//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "0 */5 * * * ?")
    public String execute() {
        if (enabled.get()) {
        	JobExecution jobExecution = null;
    		try {
    			jobExecution = jobLauncher.run(job1, new JobParameters());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return "jobExecution's info: Id = " + jobExecution.getId() + " ,status = " + jobExecution.getExitStatus();
        }
		return "Job Failed to Start";
    }

    void toggle() {
        enabled.set(!enabled.get());
    }
}
