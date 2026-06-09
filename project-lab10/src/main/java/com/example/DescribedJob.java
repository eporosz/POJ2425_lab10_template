package com.example;

import java.time.LocalDateTime;

public class DescribedJob implements Job {
    private String description;
    private LocalDateTime time;

    public DescribedJob(String description) {
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println(description);
    }

    public void setJobTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getJobTime() {
        return time;
    }
}
