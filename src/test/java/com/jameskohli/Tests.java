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
        List<Game> results = tsr.read(Team.SAS, 2014);

        assertEquals(41, results.size());
    }

    @Test
    public void testTeamScraper(){

        TeamSeasonScraper tss = new TeamSeasonScraper();

        tss.scrape(Team.ATL, 2014);

    }

    @Test
    public void testEloCalculatorHomeWin(){
        EloCalculator calc = new EloCalculator(1400, 1400, true);

        assertEquals(calc.getRn1(), 1410);
        assertEquals(calc.getRn2(), 1385);
    }

    @Test
    public void testEloCalculatorHomeLoss(){
        EloCalculator calc = new EloCalculator(1400, 1400, false);

        assertEquals(calc.getRn1(), 1380);
        assertEquals(calc.getRn2(), 1415);
    }

    @Test
    public void testEloCalculatorHomeWinUneven(){
        EloCalculator calc = new EloCalculator(1450, 1350, true);

        assertEquals(calc.getRn1(), 1457);
        assertEquals(calc.getRn2(), 1339);
    }

    @Test
    public void testEloCalculatorHomeLossUneven(){
        EloCalculator calc = new EloCalculator(1350, 1450, false);

        assertEquals(calc.getRn1(), 1335);
        assertEquals(calc.getRn2(), 1460);
    }

}
