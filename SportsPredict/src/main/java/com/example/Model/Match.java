package com.example.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Access(AccessType.FIELD)
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToMany
    private List<Team> participatingTeams;
    private int home_goals;
    private int away_goals;

    public Match(List<Team> participatingTeams){
        this.participatingTeams = participatingTeams;
        this.home_goals = 0;
        this.away_goals = 0;
    }

    public Match(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @ManyToMany
    public List<Team> getParticipatingTeams() {
        return participatingTeams;
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
}
