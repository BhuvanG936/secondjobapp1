
//Implementation without using the database

package com.srs.svmj.firstjobapp.controller;

import com.srs.svmj.firstjobapp.entity.Job;
import com.srs.svmj.firstjobapp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //1. To Retrieve All the Job Lists
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    //2. To Retrieve a Single job based on the ID
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //3. For Creating a new Job
    @PostMapping("/jobss")
    public ResponseEntity<String> createJob(@RequestBody Job job){

        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully", HttpStatus.CREATED);
    }

    //4. For Updating the Job
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){

        boolean updated = jobService.updateJob(id, updatedJob);

        if(updated)
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //5. For Deleting the Job by ID
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);

        if(deleted)
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
