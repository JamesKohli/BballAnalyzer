package com.jameskohli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by James on 6/17/2014.
 */
public class BballAnalyzer {

    private static Logger logger = LoggerFactory.getLogger(BballAnalyzer.class);


    public static void main(String[] args) {

        logger.info("Starting analyzer");
        int year = 2014;
        boolean download = false;

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-y")) {
                logger.info("Year set to " + year);
                year = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-d")) {
                logger.info("Downloads enabled");
                download = true;
            }
        }

        if (download){
            runDownloads(year);
        }
    }

    private static void runDownloads(int year){
        TeamSeasonScraper tss = new TeamSeasonScraper();
        for (Team t : Team.values()){
            logger.info("Downloading team " + t);
            tss.scrape(t, year);
            try {
                logger.info("Completed team " + t);
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
