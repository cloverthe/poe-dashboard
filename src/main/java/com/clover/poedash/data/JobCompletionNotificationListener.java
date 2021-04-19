package com.clover.poedash.data;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.clover.poedash.model.Match;

import org.hibernate.sql.Select;
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

    private final EntityManager em;

    @Autowired
    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }


    public List<Match> findAll() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Match> cq = cb.createQuery(Match.class);
      Root<Match> rootEntry = cq.from(Match.class);
      CriteriaQuery<Match> all = cq.select(rootEntry);
      TypedQuery<Match> allQuery = em.createQuery(all);
      return allQuery.getResultList();
  }  

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");
      findAll().forEach(System.out::println);
     }
    }
}
      
    //   Map<String, Team> teamData = new HashMap<>();
            
    //   em.createQuery("select m.team1, count(*) from Match m group by m.team1", Object[].class)
    //     .getResultList()
    //     .stream()
    //     .map(e -> new Team((String) e[0], (long) e[1]))
    //     .forEach(team -> teamData.put(team.getTeamName(), team));
    
    //     em.createQuery("select m.team2, count(*) from Match m group by m.team2", Object[].class)
    //     .getResultList()
    //     .stream()
    //     .forEach(e -> {
    //         Team team = teamData.get((String) e[0]);
    //         team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
    //     });

    //     em.createQuery("select m.matchWinner, count(*) from Match m group by m.matchWinner", Object[].class)
    //     .getResultList()
    //     .stream()
    //     .forEach(e -> {
    //         Team team = teamData.get((String) e[0]);
    //         if (team != null) team.setTotalWins((long) e[1]);
    //     });

    //     teamData.values().forEach(team -> em.persist(team));
    //     teamData.values().forEach(team -> System.out.println(team));
    // }
//   }
// }
