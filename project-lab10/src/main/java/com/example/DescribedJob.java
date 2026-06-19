package com.example;

import java.time.LocalDateTime;

public class DescribedJob implements Job {
    private String description;

    public DescribedJob(String description) {
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println(description);
    }

    @Override
    public void setJobTime(LocalDateTime time) {

    }

    @Override
    public LocalDateTime getJobTime() {
        return null;
    }
}
