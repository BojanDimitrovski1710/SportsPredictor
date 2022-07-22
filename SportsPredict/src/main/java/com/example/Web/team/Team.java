package com.example.Web.team;

import com.example.Web.league.League;
import com.example.Web.match.Match;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
@Access(AccessType.FIELD)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private int wins;
    private int losses;
    private int differencial;
    @ManyToMany
    private List<League> leagueList;
    //@ManyToMany
    //private List<Match> matchList;

    public Team() {
    }

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

    public List<League> getLeagueList() {
        return leagueList;
    }

    /*
    @ManyToMany
    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
    */
    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
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
