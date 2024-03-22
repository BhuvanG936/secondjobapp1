package com.srs.svmj.secondjobapp.job.repository;

import com.srs.svmj.secondjobapp.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
