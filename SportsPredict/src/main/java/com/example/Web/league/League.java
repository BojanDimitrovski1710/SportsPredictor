package com.example.Web.league;

import com.example.Web.team.Team;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Access(AccessType.FIELD)
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    @ManyToMany
    private List<Team> participating_teams;

    public League() {
    }

    public League(String name) {
        this.name = name;
    }

    public League(String name, List<Team> participating_teams) {
        this.name = name;
        this.participating_teams = participating_teams;
    }

    public String getName() {
        return name;
    }

    @ManyToMany
    public List<Team> getParticipating_teams() {
        return participating_teams;
    }
}
