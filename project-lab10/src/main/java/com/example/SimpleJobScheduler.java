package com.example;

import java.time.LocalDateTime;

public class SimpleJobScheduler implements JobScheduler {
    private Job job;
    private int timeInterval = 1;
    private int repeatCount = 1;
    private int counter = 0;
    private LocalDateTime startTime =  LocalDateTime.now();

    @Override
    public JobScheduler forJob(Job job) {
        this.job = job;
        return this;
    }

    @Override
    public JobScheduler everySeconds(int seconds) {
        this.timeInterval = seconds;
        return this;
    }

    @Override
    public JobScheduler repeatTimes(int times) {
        this.repeatCount = times;
        return this;
    }

    @Override
    public JobScheduler startsAt(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public void listenTo(TimeEvent event) {
        if (job == null) return;
        if (startTime.isAfter(event.getTime())) return;
        if (repeatCount <= counter) return;
        counter++;
        startTime = startTime.plusSeconds(timeInterval);
        new JobThread(job).start();
    }
}
