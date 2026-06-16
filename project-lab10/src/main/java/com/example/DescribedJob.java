package com.example;

public class DescribedJob implements Job {
    private String description;

    public DescribedJob(String description) {
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println(description);
    }
}
