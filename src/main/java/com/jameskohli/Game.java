package com.jameskohli;

import org.joda.time.DateTime;
/**
 * Created by James on 6/17/2014.
 */
public class Game implements Comparable<Game> {

    private long id;
    private String uniqueId;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private DateTime dateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUniqueId() {
        return homeTeam.getTeamName() + "_" + awayTeam.getTeamName() + "_" + dateTime;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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
