package com.example.Web;

import com.example.Model.League;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<League> getLeagues(){
        return leagueService.getLeagues();
    }

    @PostMapping
    public void addNewLeague(@ModelAttribute LeagueInfo leagueInfo){
        League l = new League(leagueInfo.getName());
        leagueService.addLeague(l);
    }

    @DeleteMapping(path = "{leagueId}")
    public void deleteLeague(@PathVariable("leagueId") Long leagueId){
        leagueService.deleteLeague(leagueId);
    }
}
