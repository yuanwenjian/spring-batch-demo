package com.yuanwj.batch.rest;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *  Copyright 天阳宏业科技股份有限公司 - All Rights Reserved
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/09/28 18:43
 **/
@RestController
@RequestMapping("/batch")
public class BatchRest {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @RequestMapping(value = "/batchTest",method = RequestMethod.GET)
    public String batchTest() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder().addDate("now", new Date()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        ExitStatus exitStatus = jobExecution.getExitStatus();
        System.out.println(exitStatus);
        return "success";
    }
}
