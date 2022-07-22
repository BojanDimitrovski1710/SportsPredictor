package com.example.Web.sportspredict;

import com.example.Repository.LeagueRepository;
import com.example.Repository.TeamRepository;
import com.example.Web.league.League;
import com.example.Web.team.Team;
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
    CommandLineRunner commandLineRunner (LeagueRepository repository, TeamRepository teamRepository){
        return  args -> {
            Team TSM = new Team("TSM");
            Team C9 = new Team("Cloud9");
            teamRepository.saveAll(List.of(TSM, C9));
            ArrayList<Team> lcs_teams = new ArrayList<Team>();
            lcs_teams.add(C9);
            lcs_teams.add(TSM);
            League LCS = new League("LCS", lcs_teams);
            League LCK = new League("LCK");
            League LEC = new League("LEC");
            League TCL = new League("TCL");
            repository.saveAll(List.of(LCS, LCK, LEC, TCL));
        };
    }
}
