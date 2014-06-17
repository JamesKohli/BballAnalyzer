package com.jameskohli;

import org.joda.time.DateTime;
/**
 * Created by James on 6/17/2014.
 */
public class Game implements Comparable<Game> {
    public final Team homeTeam;
    public final Team awayTeam;
    public final int homeScore;
    public final int awayScore;
    public final DateTime dateTime;

    public Game(Team homeTeam, Team awayTeam, int homeScore, int awayScore, DateTime dateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.dateTime = dateTime;
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
