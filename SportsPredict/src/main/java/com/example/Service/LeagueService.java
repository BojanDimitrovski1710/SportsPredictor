package com.example.Service;

import com.example.Repository.LeagueRepository;
import com.example.Web.league.League;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
