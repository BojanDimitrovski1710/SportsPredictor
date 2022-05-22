package com.example.Web.team;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Team {
    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    private long id;
    private String name;
    private int wins;
    private int losses;
    private int differencial;

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.differencial = 0;
    }

    public Team(String name, int wins, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.differencial = this.wins - this.losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDifferencial() {
        return differencial;
    }

    public void updateDifferencial() {
        this.differencial = this.wins - this.losses;
    }
}
