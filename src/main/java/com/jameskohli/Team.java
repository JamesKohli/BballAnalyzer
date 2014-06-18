package com.jameskohli;

/**
 * Created by James on 6/17/2014.
 */

/**Each team that is or had been in the league*/
public enum Team {
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

    public static Team convertLongName (String ln) throws TeamNotFoundException {
        switch (ln) {
            case "Atlanta Hawks": return Team.ATL;
            case "Boston Celtics": return Team.BOS;
            case "Brooklyn Nets": return Team.BRK;
            case "Charlotte Bobcats": return Team.CHA;
            case "Charlotte Hornets": return Team.CHA;
            case "Chicago Bulls": return Team.CHI;
            case "Cleveland Cavaliers": return Team.CLE;
            case "Dallas Mavericks": return Team.DAL;
            case "Denver Nuggets": return Team.DEN;
            case "Detroit Pistons": return Team.DET;
            case "Golden State Warriors": return Team.GSW;
            case "Houston Rockets": return Team.HOU;
            case "Indiana Pacers": return Team.IND;
            case "Los Angeles Clippers": return Team.LAC;
            case "Los Angeles Lakers": return Team.LAL;
            case "Memphis Grizzlies": return Team.MEM;
            case "Miami Heat": return Team.MIA;
            case "Milwaukee Bucks": return Team.MIL;
            case "Minnesota Timberwolves": return Team.MIN;
            case "New Jersey Nets": return Team.BRK;
            case "New Orleans Hornets": return Team.NOP;
            case "New Orleans Pelicans": return Team.NOP;
            case "New York Knicks": return Team.NYK;
            case "Oklahoma City Thunder": return Team.OKC;
            case "Orlando Magic": return Team.ORL;
            case "Philadelphia 76ers": return Team.PHI;
            case "Phoenix Suns": return Team.PHO;
            case "Portland Trail Blazers": return Team.POR;
            case "Sacramento Kings": return Team.SAC;
            case "San Antonio Spurs": return Team.SAS;
            case "Toronto Raptors": return Team.TOR;
            case "Utah Jazz": return Team.UTA;
            case "Washington Wizards": return Team.WAS;
            default: throw new TeamNotFoundException();
        }

    }

    public static class TeamNotFoundException extends Throwable {
    }
}
