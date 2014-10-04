package com.jameskohli;

/**
 * Created by James on 6/17/2014.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**Each team that is or had been in the league*/
public class Team{

    private int id;
    private TeamName teamName;
    private int elo;

    final static Logger logger = LoggerFactory.getLogger(Team.class);

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public static Map<TeamName, Team> createTeamMap(){
        logger.info("Creating initial list of teams");
        Map<TeamName, Team> teams = new HashMap<TeamName, Team>();
        for (TeamName tn : TeamName.values()){
            Team t = new Team();
            t.setTeamName(tn);
            t.setElo(1500);
            teams.put(tn, t);
        }
        return teams;
    }
}

enum TeamName {
    ATL,
    BOS,
    BRK,
    CHA,
    CHI,
    CLE,
    DAL,
    DEN,
    DET,
    GSW,
    HOU,
    IND,
    LAC,
    LAL,
    MEM,
    MIA,
    MIL,
    MIN,
    NOP,
    NYK,
    OKC,
    ORL,
    PHI,
    PHO,
    POR,
    SAC,
    SAS,
    TOR,
    UTA,
    WAS;

    public static TeamName convertLongName (String ln) throws TeamNotFoundException {
        switch (ln) {
            case "Atlanta Hawks": return TeamName.ATL;
            case "Boston Celtics": return TeamName.BOS;
            case "Brooklyn Nets": return TeamName.BRK;
            case "Charlotte Bobcats": return TeamName.CHA;
            case "Charlotte Hornets": return TeamName.CHA;
            case "Chicago Bulls": return TeamName.CHI;
            case "Cleveland Cavaliers": return TeamName.CLE;
            case "Dallas Mavericks": return TeamName.DAL;
            case "Denver Nuggets": return TeamName.DEN;
            case "Detroit Pistons": return TeamName.DET;
            case "Golden State Warriors": return TeamName.GSW;
            case "Houston Rockets": return TeamName.HOU;
            case "Indiana Pacers": return TeamName.IND;
            case "Los Angeles Clippers": return TeamName.LAC;
            case "Los Angeles Lakers": return TeamName.LAL;
            case "Memphis Grizzlies": return TeamName.MEM;
            case "Miami Heat": return TeamName.MIA;
            case "Milwaukee Bucks": return TeamName.MIL;
            case "Minnesota Timberwolves": return TeamName.MIN;
            case "New Jersey Nets": return TeamName.BRK;
            case "New Orleans Hornets": return TeamName.NOP;
            case "New Orleans Pelicans": return TeamName.NOP;
            case "New York Knicks": return TeamName.NYK;
            case "Oklahoma City Thunder": return TeamName.OKC;
            case "Orlando Magic": return TeamName.ORL;
            case "Philadelphia 76ers": return TeamName.PHI;
            case "Phoenix Suns": return TeamName.PHO;
            case "Portland Trail Blazers": return TeamName.POR;
            case "Sacramento Kings": return TeamName.SAC;
            case "San Antonio Spurs": return TeamName.SAS;
            case "Toronto Raptors": return TeamName.TOR;
            case "Utah Jazz": return TeamName.UTA;
            case "Washington Wizards": return TeamName.WAS;
            default: throw new TeamNotFoundException();
        }

    }

    public static class TeamNotFoundException extends Throwable {
    }
}
