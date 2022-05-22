package com.example.Repository;

import com.example.Web.league.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, Long> {
    @Query("SELECT l FROM League l WHERE l.name = ?1")
    Optional<League> findLeagueByName(String name);
}
