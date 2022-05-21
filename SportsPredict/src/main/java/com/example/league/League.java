package com.example.league;

import com.example.team.Team;

import java.util.List;

public class League {
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
