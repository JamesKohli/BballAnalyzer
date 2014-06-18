package com.jameskohli;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;

/**
 * Created by James on 6/17/2014.
 */
public class TeamSeasonScraper {

    int tries = 0;
    final int maxTries = 5;

    Logger logger = LoggerFactory.getLogger(TeamSeasonScraper.class);

    //** scrape a basketball reference season results page for a given team and year*/
    public void scrape(Team t, int year){
        String url = "http://www.basketball-reference.com/teams/" + t + "/" + year + "_games.html";

        tries = 0;
        while (tries < maxTries) {
            try {
                logger.info("Getting page " + url);
                Document doc = Jsoup.connect(url).get();

                Element table = doc.getElementById("teams_games");

                PrintWriter pw = new PrintWriter("TeamSeasons/" + t + "_" + year + ".csv");
                for (Element tr : table.select("tr")) {
                    for (Element td : tr.select("td")){
                        pw.print(td.text() + ",");
                    }
                    for (Element th : tr.select("th")){
                        pw.print(th.text() + ",");
                    }
                    pw.println();
                }

                pw.close();
                break;

            } catch (Exception e) {
                logger.error("Couldn't get page " + url, e);
                tries += 1;
            }
        }

    }
}
