package com.clover.poedash.data;



import javax.transaction.Transactional;
import com.clover.poedash.repositories.MatchRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);


    private MatchRepository matchRepository;

    @Autowired
    public JobCompletionNotificationListener(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

  

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED!");
            // log.warn("LOOK! -> " + matchRepository.findByAccountIgnoreCase("alkaizerx").stream().findAny().orElse(null));
            // log.warn("died: " + matchRepository.findAll()
            // .stream()
            // .filter(e -> e.getDead().equals(true))
            // .count()
            // );
            
        }
    }
}
