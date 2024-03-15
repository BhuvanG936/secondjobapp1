package com.srs.svmj.firstjobapp.service;

import com.srs.svmj.firstjobapp.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);
}
