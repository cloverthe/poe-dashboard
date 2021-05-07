package com.clover.poedash.repositories;
import java.util.List;
import java.util.Optional;

import com.clover.poedash.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long>{
    
    List<Match> findAll(Pageable pageable);
    List<Match> findByAccountIgnoreCase(String name);
    List<Match> findByAccountIgnoreCaseContaining(String name);
    Optional<Match> findById(Long id);

    default List<Match> getPage(Integer start, Integer amount){
        return findAll(PageRequest.of(start, amount));
    }

}
