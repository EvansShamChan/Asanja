package com.esc.asanja.init;

import com.esc.asanja.entity.Job;
import com.esc.asanja.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

/**
 * Class for managing default jobs list.
 * */
@Controller
public class DefaultJobsManager {

    @Value("#{'${app.jobs.default.list}'.split(', ')}")
    private List<String> defaultJobs;

    private JobService jobService;

    @Autowired
    public DefaultJobsManager(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * Method to add default jobs in DB.
     * */
    @PostConstruct
    public void initDefaultJobs() {
        defaultJobs.stream()
                .map(this::createInitJob)
                .forEach(job -> jobService.createNewJob(job));
    }

    private Job createInitJob(String jobName) {
        //todo: create builder for job entity
        Job job = new Job();
        job.setName(jobName);
        job.setSecondsToAchieve(60L);
        job.setComplexity(new Random().nextInt(10));
        return job;
    }

    /**
     * Deletes all existing jobs in DB.
     * */
    @PreDestroy
    public void deleteDefaultJobs() {
        jobService.deleteAllJobs();
    }
}
