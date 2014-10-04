package com.jameskohli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by James on 6/17/2014.
 */
public class BballAnalyzer {

    private static Logger logger = LoggerFactory.getLogger(BballAnalyzer.class);
    private static List<Integer> years = new ArrayList<Integer>();
    static boolean download = false;
    //Our hibernate sesssion
    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    //the list of teams
    static Map<TeamName, Team> teams = new HashMap<TeamName, Team>();


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

        //Create and save the list of teams
        teams = Team.createTeamMap();
        logger.info("Persisiting teams to database");
        for (Team t: teams.values()){
                try{
                    Session s = sessionFactory.openSession();
                    s.beginTransaction();
                    s.save(t);
                    s.getTransaction().commit();
                    s.close();}
                catch (Exception e){
                    logger.error("Error saving team " + t, e);
                }
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
            for (TeamName t : TeamName.values()) {
                List<Game> games = tsr.read(t, year, teams);
                for (Game g : games){
                    try{
                        Session s = sessionFactory.openSession();
                        s.beginTransaction();
                        s.save(g);
                        s.getTransaction().commit();
                        s.close();}
                    catch (Exception e){
                        logger.error("Error saving game " + g, e);
                    }
                }
            }
        }
    }

    private static void runDownloads(int year){
        TeamSeasonScraper tss = new TeamSeasonScraper();
        for (TeamName t : TeamName.values()){
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
