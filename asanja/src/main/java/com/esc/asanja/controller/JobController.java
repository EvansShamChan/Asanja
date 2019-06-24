package com.esc.asanja.controller;

import com.esc.asanja.entity.Job;
import com.esc.asanja.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for job entity
 * */
@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * Method for creating new user defined job
     *
     * @param newJob
     *      - new job entity
     * */
    @PostMapping
    public void createJob(@Valid @RequestBody Job newJob) {
        jobService.createNewJob(newJob);
    }

    /**
     * Method for retrieving all existing jobs
     *
     * @return list of all jobs
     * */
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
}
