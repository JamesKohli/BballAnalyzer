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

}
