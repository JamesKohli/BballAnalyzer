package com.jameskohli;

import au.com.bytecode.opencsv.CSVReader;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

import java.util.List;


/**
 * Created by James on 6/17/2014.
 */
public class TeamSeasonReader {

    CSVReader csvReader;
    Logger logger = LoggerFactory.getLogger(TeamSeasonReader.class);
    private List<Game> results;
    final String fileType = ".csv";


    /** This reads a team results csv for a year from basketball-reference.com and returns the home games in a list.*/
    public List<Game> read(Team t, int year) {

        results = new ArrayList<Game>();
        String file = "/" + t.toString() + "_" + year + fileType;

        try {
            csvReader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream(file)));
            String [] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                parseLine(nextLine, t);
            }
        } catch (Exception e) {
            logger.error("Couldn't read file " + file, e);
        }
        return results;
    }

    private void parseLine(String[] nextLine, Team t) {
        if (nextLine[0].equals("G") | nextLine[3].equals("@")){return;}

        try {
            Team awayTeam = Team.convertLongName(nextLine[4]);
            DateTimeFormatter fmt = DateTimeFormat.forPattern("EEE MMM dd yyyy");

            Game g = new Game(t, awayTeam, Integer.parseInt(nextLine[7]), Integer.parseInt(nextLine[8]), DateTime.parse(nextLine[1], fmt));
            results.add(g);
        } catch (Team.TeamNotFoundException e) {
            logger.error("Couldn't find team " + nextLine[4], e);
        }

    }
}
