package com.example.Service;

import com.example.Model.Exceptions.InvalidMatchIdException;
import com.example.Model.Exceptions.TeamNotInLeagueException;
import com.example.Model.League;
import com.example.Model.Team;
import com.example.Repository.MatchRepository;
import com.example.Model.Match;
import com.example.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final LeagueService leagueService;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, LeagueService leagueService) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.leagueService = leagueService;
    }

    public Match findById(Long id){
        Optional<Match> target = this.matchRepository.findById(id);
        if(target.isPresent()){
            return target.get();
        }else{
            throw new InvalidMatchIdException();
        }
    }

    public List<Match> listAll(){
        return this.matchRepository.findAll();
    }

    public Match create(String name){
        Match newMatch = new Match();
        this.matchRepository.save(newMatch);
        return newMatch;
    }

    // TODO: Implement this ffs
    public Match addMatch(Team home, Team away, Long leagueId){
        League league = this.leagueService.findById(leagueId);
        List<Team> leagueTeams = this.teamRepository.findByLeague(leagueId);
        if( !(leagueTeams.contains(home) || leagueTeams.contains(away)) ){
            throw new TeamNotInLeagueException();
        }else{
            Match newMatch = new Match(home, away, league)
        }
    }

    public Match delete(Long id){
        Optional<Match> target = this.matchRepository.findById(id);
        if(target.isPresent()){
            Match m = target.get();
            this.matchRepository.deleteById(id);
            return m;
        }else{
            throw new InvalidMatchIdException();
        }
    }
}
