package com.example.Web.league;

import com.example.Service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/league")
public class LeagueController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService){
        this.leagueService = leagueService;
    }

    @GetMapping
    public List<League> getLeagues(){
        return leagueService.getLeagues();
    }

    @PostMapping
    public void addNewLeague(@RequestBody League league){
        leagueService.addLeague(league);
    }

    @DeleteMapping(path = "{leagueId}")
    public void deleteLeague(@PathVariable("leagueId") Long leagueId){
        leagueService.deleteLeague(leagueId);
    }
}
