package com.esc.asanja.service;

import com.esc.asanja.entity.Job;
import com.esc.asanja.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository= jobRepository;
    }

    public void createNewJob(Job newJob) {
        jobRepository.save(newJob);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
