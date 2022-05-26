package com.example.Web.sportspredict;

import com.example.Repository.LeagueRepository;
import com.example.Web.league.League;
import com.example.Web.team.Team;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EntityScan("com.example.*")
@ComponentScan(basePackages = "com.example.*")
public class LeagueConfig {

    @Bean
    CommandLineRunner commandLineRunner (LeagueRepository repository){
        return  args -> {
//            Team TSM = new Team("TSM");
//            Team C9 = new Team("Cloud9");
            League LCS = new League("LCS");
            League LCK = new League("LCK");
            League LEC = new League("LEC");
            repository.saveAll(List.of(LCS, LCK, LEC));
        };
    }
}
