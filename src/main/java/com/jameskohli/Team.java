package com.jameskohli;

/**
 * Created by James on 6/17/2014.
 */
public enum Team {
    CHI,
    MIL,
    LAC,
    CHA,
    UTA,
    MIN,
    LAL,
    NOH,
    NOP,
    MEM,
    DAL,
    CLE,
    HOU,
    GSW,
    POR,
    PHX,
    BKN,
    OKC,
    SAC,
    TOR,
    ORL,
    BOS,
    NYK,
    MIA,
    ATL,
    DET,
    DEN,
    SAS,
    WAS,
    PHI,
    IND;

    public static Team convertLongName (String ln) throws TeamNotFoundException {
        switch (ln) {
            case "Chicago Bulls": return Team.CHI;
            case "Milwaukee Bucks": return Team.MIL;
            case "Los Angeles Clippers": return Team.LAC;
            case "Charlotte Bobcats": return Team.CHA;
            case "Utah Jazz": return Team.UTA;
            case "Minnesota Timberwolves": return Team.MIN;
            case "Los Angeles Lakers": return Team.LAL;
            case "New Orleans Hornets": return Team.NOH;
            case "New Orleans Pelicans": return Team.NOP;
            case "Memphis Grizzlies": return Team.MEM;
            case "Dallas Mavericks": return Team.DAL;
            case "Cleveland Cavaliers": return Team.CLE;
            case "Houston Rockets": return Team.HOU;
            case "Golden State Warriors": return Team.GSW;
            case "Portland Trail Blazers": return Team.POR;
            case "Phoenix Suns": return Team.PHX;
            case "Brooklyn Nets": return Team.BKN;
            case "Oklahoma City Thunder": return Team.OKC;
            case "Sacramento Kings": return Team.SAC;
            case "Toronto Raptors": return Team.TOR;
            case "Orlando Magic": return Team.ORL;
            case "Boston Celtics": return Team.BOS;
            case "New York Knicks": return Team.NYK;
            case "Miami Heat": return Team.MIA;
            case "Atlanta Hawks": return Team.ATL;
            case "Detroit Pistons": return Team.DET;
            case "Denver Nuggets": return Team.DEN;
            case "San Antonio Spurs": return Team.SAS;
            case "Washington Wizards": return Team.WAS;
            case "Philadelphia 76ers": return Team.PHI;
            case "Indiana Pacers": return Team.IND;
            default: throw new TeamNotFoundException();
        }

    }

    public static class TeamNotFoundException extends Throwable {
    }
}
