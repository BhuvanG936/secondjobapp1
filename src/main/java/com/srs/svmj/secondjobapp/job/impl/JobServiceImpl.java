package com.srs.svmj.secondjobapp.job.impl;

import com.srs.svmj.secondjobapp.job.entity.Job;
import com.srs.svmj.secondjobapp.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job: jobs){
            if(Objects.equals(job.getId(),id))
                return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {

        Iterator<Job> itr = jobs.iterator();

        while(itr.hasNext()){
            Job jobs = itr.next();
            if(Objects.equals(jobs.getId(),id)){
                itr.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

            for(Job job: jobs){
                if(Objects.equals(job.getId(),id)){
                    job.setTitle(updatedJob.getTitle());
                    job.setDescription(updatedJob.getDescription());
                    job.setMinSalary(updatedJob.getMinSalary());
                    job.setMaxSalary(updatedJob.getMaxSalary());
                    job.setLocation(updatedJob.getLocation());
                    return true;
                }else{
                    return false;
                }
            }
            return false;
    }
}
