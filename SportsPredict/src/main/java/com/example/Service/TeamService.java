package com.example.Service;

import com.example.Repository.TeamRepository;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(String name) {
        Optional<Team> optionalTeam = teamRepository.findTeamByName(name);

        if (!optionalTeam.isPresent()) {
            throw new IllegalStateException("A Team with that name doesn't exists");
        }
        return optionalTeam.get();
    }

    public void addTeam(Team team){
        Optional<Team> optionalTeam = teamRepository.findTeamByName(team.getName());

        if(optionalTeam.isPresent()) {
            throw new IllegalStateException("A Team with that name already exists");
        }
        teamRepository.save(team);
    }

    /*
    public void addTeamToLeague(Team t, League l){
        t.setLeagueList(List.of(l));
        teamRepository.save(t);
    }
    */
    public void deleteTeam(Long teamId){
        boolean exists = teamRepository.existsById(teamId);
        if(!exists){
            throw new IllegalStateException("Team with Id " + teamId + " doesn't exist");
        }
        teamRepository.deleteById(teamId);
    }
}
