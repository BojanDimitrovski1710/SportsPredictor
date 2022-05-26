package com.example.Web.sportspredict;

import com.example.Repository.LeagueRepository;
import com.example.Web.league.League;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.example.*")
@ComponentScan(basePackages = "com.example.*")
public class LeagueConfig {

    @Bean
    CommandLineRunner commandLineRunner (LeagueRepository repository){
        return  args -> {
            League LCS = new League(
                    "LCS"
            );
        };
    }
}
