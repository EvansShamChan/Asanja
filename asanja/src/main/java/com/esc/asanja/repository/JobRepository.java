package com.esc.asanja.repository;

import com.esc.asanja.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for job entity.
 * */
@Repository
public interface JobRepository extends MongoRepository<Job, Long> {
}
