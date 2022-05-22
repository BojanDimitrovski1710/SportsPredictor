package com.example.Web.league;

import com.example.Web.team.Team;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

public class League {
    @Id
    @SequenceGenerator(
            name = "league_sequence",
            sequenceName = "league_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "league_sequence"
    )
    private long id;

    private String name;
    private List<Team> participating_teams;

    public League(String name) {
        this.name = name;
    }

    public League(String name, List<Team> participating_teams) {
        this.name = name;
        this.participating_teams = participating_teams;
    }
}
