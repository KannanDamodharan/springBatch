package com.varks.batch.student;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping
    public void importCsvToDBJob(){
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();
        try{
            jobLauncher.run(job, jobParameters);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
