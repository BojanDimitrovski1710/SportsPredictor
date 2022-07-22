package com.example.Web.team;

import com.example.Service.LeagueService;
import com.example.Service.TeamService;
import com.example.Web.league.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping
    public String getTeams(){
        return teamService.getTeams().toString();
    }

    @PostMapping
    public void addNewTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId){
        teamService.deleteTeam(teamId);
    }
}
