package com.example.Web.match;

import com.example.Web.team.Team;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Match {
    @Id
    @SequenceGenerator(
            name = "match_sequence",
            sequenceName = "match_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "match_sequence"
    )
    private long id;
    private Team home;
    private Team away;
    private int home_goals;
    private int away_goals;
}
