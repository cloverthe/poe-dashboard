package com.clover.poedash.data;

import com.clover.poedash.model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {
    public static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        // log.info("HERE");
        // log.error(matchInput.toString());
        match.setId(Long.parseLong(matchInput.getRank().trim()));
        match.setAccount(matchInput.getAccount());
        match.setCharacter(matchInput.getCharacter());
        match.setCharacterClass(matchInput.getCharacterClass());
        match.setLevel(Integer.parseInt(matchInput.getLevel()));
        match.setExperience(Long.parseLong(matchInput.getExperience()));
        if("Dead".equals(matchInput.getDead()) || matchInput.getDead() == null){
            match.setDead(true);
        } else {
            match.setDead(false);
        }
       
        return match;
    }
    

}
