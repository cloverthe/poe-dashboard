package com.clover.poedash.controllers;

import java.util.stream.Collectors;

import com.clover.poedash.model.Match;
import com.clover.poedash.repositories.MatchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/players")
public class PlayerController {
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Match> getAllPlayers() {
        return matchRepository.findAll();
    }

    @GetMapping(path = "/alive")
    public @ResponseBody Iterable<Match> getAllPlayersAlive(){
        return matchRepository.findAll()
        .stream()
        .filter(e -> e.getDead().equals(true))
        .collect(Collectors.toList());
    }
    @GetMapping(path = "/dead")
    public @ResponseBody Iterable<Match> getAllPlayersDead(){
        return matchRepository.findAll()
        .stream()
        .filter(e -> e.getDead().equals(false))
        .collect(Collectors.toList());
    }

    @GetMapping(path = "searchByAccount/{name}")
    public @ResponseBody Iterable<Match> getAllPlayersByName(@PathVariable String name){
        return matchRepository.findByAccountIgnoreCaseContaining(name);
    }
}
