package com.jameskohli;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 6/17/2014.
 */
public class Tests {

    @Test
    public void testTeamSeasonCSVRead(){

        TeamSeasonReader tsr = new TeamSeasonReader();
        List<Game> results = tsr.read(TeamName.SAS, 2014, Team.createTeamMap());

        assertEquals(41, results.size());
    }

    @Test
    public void testTeamScraper(){
        TeamSeasonScraper tss = new TeamSeasonScraper();
        tss.scrape(TeamName.ATL, 2014);
    }

    @Test
    public void testEloCalculatorHomeWinUneven(){
        EloCalculator calc = new EloCalculator(1450, 1350, true);

        assertEquals(1452, calc.getRn1());
        assertEquals(1346, calc.getRn2());
    }

    @Test
    public void testEloCalculatorHomeLossUneven(){
        EloCalculator calc = new EloCalculator(1350, 1450, false);

        assertEquals(1345, calc.getRn1());
        assertEquals(1453, calc.getRn2());
    }
}
