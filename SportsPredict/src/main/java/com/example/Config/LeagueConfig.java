package com.example.Config;

import com.example.Model.League;
import com.example.Model.Match;
import com.example.Model.Team;
import com.example.Repository.LeagueRepository;
import com.example.Repository.MatchRepository;
import com.example.Repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EntityScan("com.example.*")
@ComponentScan(basePackages = "com.example.*")
public class LeagueConfig {

    @Bean
    CommandLineRunner commandLineRunner (LeagueRepository repository, TeamRepository teamRepository, MatchRepository matchRepository){
        return  args -> {
            Team TSM = new Team("TSM");
            Team C9 = new Team("Cloud9");
            teamRepository.saveAll(List.of(TSM, C9));
            ArrayList<Team> lcs_teams = new ArrayList<Team>();
            lcs_teams.add(C9);
            lcs_teams.add(TSM);
            Match TSMvC9 = new Match(List.of(C9, TSM));
            matchRepository.save(TSMvC9);
            League LCS = new League("LCS", lcs_teams);
            teamRepository.saveAll(List.of(TSM, C9));
            League LCK = new League("LCK");
            League LEC = new League("LEC");
            League TCL = new League("TCL");
            repository.saveAll(List.of(LCS, LCK, LEC, TCL));
        };
    }
}
