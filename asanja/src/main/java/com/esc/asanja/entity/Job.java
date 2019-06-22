package com.esc.asanja.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Entity that represents job for executing
 */
@Document(collection = "jobs")
public class Job {

    @Id
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @Positive
    @NotNull
    private Long secondsToAchieve;

    @Positive
    @NotNull
    @Max(value = 10)
    private Integer complexity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSecondsToAchieve() {
        return secondsToAchieve;
    }

    public void setSecondsToAchieve(Long secondsToAchieve) {
        this.secondsToAchieve = secondsToAchieve;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }
}
