package com.example.Web.team;

import com.example.Service.TeamService;
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
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @PostMapping
    public void addNewTeam(@ModelAttribute TeamInfo teamInfo){
        Team t = new Team(teamInfo.getName(), teamInfo.getWins(), teamInfo.getLosses());
        teamService.addTeam(t);
    }

    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId){
        teamService.deleteTeam(teamId);
    }
}
