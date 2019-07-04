package com.esc.asanja.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Configuration for connecting to Mongo DB database
 * */
@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Value("${app.jobs.collection.name}")
    private String jobsCollectionName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("172.19.0.2", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return jobsCollectionName;
    }
}
