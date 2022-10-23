package com.example.Repository;

import com.example.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team WHERE t.league = ?1")
    List<Team> findByLeague(Long leagueId);
}
