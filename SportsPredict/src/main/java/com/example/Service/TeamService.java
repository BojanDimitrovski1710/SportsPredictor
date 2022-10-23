package com.example.Service;

import com.example.Model.Exceptions.InvalidTeamIdException;
import com.example.Repository.TeamRepository;
import com.example.Model.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findById(Long id){
        Optional<Team> target = this.teamRepository.findById(id);
        if(target.isPresent()){
            return target.get();
        }else{
            throw new InvalidTeamIdException();
        }
    }

    public List<Team> listAll(){
        return this.teamRepository.findAll();
    }

    public Team create(String name){
        Team newTeam = new Team(name);
        this.teamRepository.save(newTeam);
        return newTeam;
    }

}

