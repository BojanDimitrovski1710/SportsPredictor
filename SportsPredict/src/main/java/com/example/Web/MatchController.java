package com.example.Web;

import com.example.Model.League;
import com.example.Model.Match;
import com.example.Model.Team;
import com.example.Service.LeagueService;
import com.example.Service.MatchService;
import com.example.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/match")
public class MatchController {
    private final MatchService matchService;
    private final TeamService teamService;
    private final LeagueService leagueService;

    @Autowired
    public MatchController(MatchService matchService, TeamService teamService, LeagueService leagueService){
        this.matchService = matchService;
        this.teamService = teamService;
        this.leagueService = leagueService;
    }

    @GetMapping
    public List<Match> getMatches(){
        return matchService.listAll();
    }

    @PostMapping
    public void addNewMatch(@PathVariable Long homeId, @PathVariable Long awayId,@PathVariable Long leagueId){
        Team home = this.teamService.findById(homeId);
        Team away = this.teamService.findById(awayId);
        League league = this.leagueService.findById(leagueId);



    }

    @PostMapping("/matches/{id}/delete")
    public String deleteMatch(@PathVariable Long id){
        matchService.delete(id);
        return "redirect:/matches";
    }
}
