package com.example.Repository;

import com.example.Web.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query("SELECT m FROM Match m WHERE m.Id = ?1")
    Optional<Match> findMatchById(Long Id);
}
