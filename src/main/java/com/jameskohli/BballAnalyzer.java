package com.jameskohli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by James on 6/17/2014.
 */
public class BballAnalyzer {

    private static Logger logger = LoggerFactory.getLogger(BballAnalyzer.class);
    private static List<Integer> years = new ArrayList<Integer>();
    static boolean download = false;
    //Our hibernate sesssion
    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public static void main(String[] args) {

        logger.info("Starting analyzer");

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-y")) {
                logger.info("Adding year " + Integer.parseInt(args[i+1]));
                years.add(Integer.parseInt(args[i + 1]));
            }
            if (args[i].equals("-d")) {
                logger.info("Downloads enabled");
                download = true;
            }
        }

        if (years.isEmpty()){
            years.add(2014);
        }

        //download the appropriate years
        if (download){
            for (int year : years) {
                logger.info("Starting year " + year);
                runDownloads(year);
            }
        }

        //save the appropriate years to the database
        for (int year : years){
            TeamSeasonReader tsr = new TeamSeasonReader();
            for (Team t : Team.values()) {
                List<Game> games = tsr.read(t, year);
                for (Game g : games){
                    Session s = sessionFactory.openSession();
                    s.beginTransaction();
                    s.save(g);
                    s.getTransaction().commit();
                    s.close();
                }
            }
        }
    }

    private static void runDownloads(int year){
        TeamSeasonScraper tss = new TeamSeasonScraper();
        for (Team t : Team.values()){
            logger.info("Downloading team " + t);
            tss.scrape(t, year);
            try {
                logger.info("Completed team " + t);
                //Pause for a little to be good web citizens, don't want to hit the site with many requests at a time
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
