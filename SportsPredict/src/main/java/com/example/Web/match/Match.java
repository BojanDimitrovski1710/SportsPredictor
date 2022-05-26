package com.example.Web.match;

import com.example.Web.team.Team;

import javax.persistence.*;

@Entity
@Table
public class Match {
    @Id
    @SequenceGenerator(
            name = "match_sequence",
            sequenceName = "match_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "match_sequence"
    )
    private long Id;
    private Team home;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getHome_goals() {
        return home_goals;
    }

    public void setHome_goals(int home_goals) {
        this.home_goals = home_goals;
    }

    public int getAway_goals() {
        return away_goals;
    }

    public void setAway_goals(int away_goals) {
        this.away_goals = away_goals;
    }

    private Team away;
    private int home_goals;
    private int away_goals;
}
