package com.example.Web.match;

import com.example.Service.MatchService;
import com.example.Service.TeamService;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/match")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getMatches(){
        return matchService.getMatches();
    }

    @PostMapping
    public void addNewMatch(@RequestBody Match match){
        matchService.addMatch(match);
    }

    @DeleteMapping(path = "{matchId}")
    public void deleteMatch(@PathVariable("matchId") Long matchId){
        matchService.deleteMatch(matchId);
    }
}
