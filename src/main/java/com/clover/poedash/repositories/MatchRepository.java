package com.clover.poedash.repositories;
import java.util.List;

import com.clover.poedash.model.Match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long>{
    
    List<Match> findByAccountIgnoreCase(String name);
    List<Match> findByAccountIgnoreCaseContaining(String name);

}
