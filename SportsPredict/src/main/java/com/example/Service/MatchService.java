package com.example.Service;

import com.example.Repository.MatchRepository;
import com.example.Web.league.League;
import com.example.Web.match.Match;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public void addLeague(Match match){
        Optional<Match> optionalMatch = matchRepository.findMatchById(match.getId());

        if(optionalMatch.isPresent()) {
            throw new IllegalStateException("A Match with that id already exists");
        }
        matchRepository.save(match);
    }

    public void deleteLeague(Long matchId){
        boolean exists = matchRepository.existsById(matchId);
        if(!exists){
            throw new IllegalStateException("Match with Id " + matchId + " doesn't exist");
        }
        matchRepository.deleteById(matchId);
    }
}
