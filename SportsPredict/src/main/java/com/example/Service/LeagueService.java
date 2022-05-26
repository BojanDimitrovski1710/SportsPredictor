package com.example.Service;

import com.example.Repository.LeagueRepository;
import com.example.Web.league.League;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getLeagues() {
        return leagueRepository.findAll();
    }

    public void addLeague(League league){
        Optional<League> optionalLeague = leagueRepository.findLeagueByName(league.getName());

        if(optionalLeague.isPresent()) {
            throw new IllegalStateException("A League with that name already exists");
        }
        leagueRepository.save(league);
    }

    public void deleteLeague(Long leagueId){
        boolean exists = leagueRepository.existsById(leagueId);
        if(!exists){
            throw new IllegalStateException("League with Id " + leagueId + " doesn't exist");
        }
        leagueRepository.deleteById(leagueId);
    }
}
