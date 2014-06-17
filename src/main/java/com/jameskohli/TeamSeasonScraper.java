package com.jameskohli;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 6/17/2014.
 */
public class TeamSeasonScraper {

    final private WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
    private HtmlPage page;
    Logger logger = LoggerFactory.getLogger(TeamSeasonScraper.class);

    public void scrape(Team t, int year){
        String url = "http://www.basketball-reference.com/teams/" + t + "/" + year + "_games.html";
        int tries = 0;
        int maxTries = 5;

        while (tries < maxTries) {
            try {
                logger.info("Getting page " + url);
                page = webClient.getPage(url);
                final HtmlSpan span = (HtmlSpan) page.getElementById("").getByXPath("div[@class='table_heading_text']/span[@tip='Convert the table below to comma-separated values']").get(0);
                page = span.click();

                String csv = page.getElementById("csv_teams_games").asText();

                String[] lines = csv.split(",\\s|,Notes\\s");

                PrintWriter pw = new PrintWriter("TeamSeasons/" + t + "_" + year + ".csv");
                for (String s : lines) {
                    pw.println(s);
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
