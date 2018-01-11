package com.redbee.batchjobs.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("leadsNeotelJob")
    private Job leadsNeotelJob;

    @Scheduled(cron = "0 */30 * * * *")
    public void leadsNeotelJob() throws Exception {
//        log.info("cron");
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(leadsNeotelJob, jobParameters);
    }
}