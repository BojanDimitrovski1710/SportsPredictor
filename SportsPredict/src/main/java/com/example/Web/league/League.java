package com.example.Web.league;

import com.example.Repository.TeamRepository;
import com.example.Service.TeamService;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
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
        this.participating_teams = new ArrayList<>();
    }

    public League(String name, List<Team> participating_teams) {
        this.name = name;
        this.participating_teams = participating_teams;
        for(int i=0; i<participating_teams.size(); i++){
            //participating_teams.get(i).setLeague(this);
        }
    }

    public String getName() {
        return name;
    }

    @ManyToMany
    public List<Team> getParticipating_teams() {
        return participating_teams;
    }

    public void addTeam(Team t){
        this.participating_teams.add(t);
    }

}
