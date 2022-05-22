package com.example.Service;

import com.example.Repository.MatchRepository;
import com.example.Web.match.Match;
import com.example.Web.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
