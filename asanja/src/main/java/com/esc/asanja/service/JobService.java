package com.esc.asanja.service;

import com.esc.asanja.entity.Job;
import com.esc.asanja.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for manipulating job entity.
 * */
@Service
public class JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository= jobRepository;
    }

    /**
     * Method creates new job.
     *
     * @param newJob
     *      - new job entity
     * */
    public void createNewJob(Job newJob) {
        jobRepository.save(newJob);
    }

    /**
     * Method for retrieving all existing jobs.
     *
     * @return list of jobs
     * */
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    /**
     * Method for deleting all existing jobs.
     * */
    public void deleteAllJobs() {
        jobRepository.deleteAll();
    }
}
