package com.jameskohli;

import org.joda.time.DateTime;
/**
 * Created by James on 6/17/2014.
 */
public class Game implements Comparable<Game> {

    private Long id;

    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private DateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Game(Team homeTeam, Team awayTeam, int homeScore, int awayScore, DateTime dateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.dateTime = dateTime;
    }

    public Game(){

    }

    @Override
    public int compareTo(Game o) {
        if (this.dateTime.isAfter(o.dateTime)){
            return 1;
        } else if (this.dateTime.isBefore(o.dateTime)) {
            return -1;
        } else {
            return 0;
        }
    }
}
