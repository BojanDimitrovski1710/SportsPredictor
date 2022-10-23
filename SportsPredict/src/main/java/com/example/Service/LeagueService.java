package com.example.Service;

import com.example.Model.Exceptions.InvalidLeagueIdException;
import com.example.Model.Exceptions.TeamNotInLeagueException;
import com.example.Model.Match;
import com.example.Model.Team;
import com.example.Repository.LeagueRepository;
import com.example.Model.League;
import com.example.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }

    public League findById(Long id){
        Optional<League> target = this.leagueRepository.findById(id);
        if(target.isPresent()){
            return target.get();
        }else{
            throw new InvalidLeagueIdException();
        }
    }



    public List<League> listAll(){
        return this.leagueRepository.findAll();
    }

    public League create(String name){
        League newLeague = new League(name);
        this.leagueRepository.save(newLeague);
        return newLeague;
    }


}
