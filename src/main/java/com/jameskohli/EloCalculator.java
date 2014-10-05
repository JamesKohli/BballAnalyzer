package com.jameskohli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by James on 9/13/2014.
 * This calculates the ELO changes for a match
 * //Rn = Ro + K * (W - We)
 //Rn: New rating
 //Ro: Old rating
 //K: Weight constant for game played
 //W: result of game (1 for win, .5, 0)
 //We: expected result
 //We = 1/(10^(-dr/400) + 1)
 //dr = difference in ratings + home field advantage (100?)
 */
public class EloCalculator {

    Logger logger = LoggerFactory.getLogger(EloCalculator.class);
    private static final int K = 10;
    private static final int HOME_FIELD_ADVANTAGE = 25;
    private int rn1;
    private int rn2;

    /**
     * The ELO calculator for a match.
     * @param homeElo The ELO of the first team
     * @param awayElo The ELO score of the second team
     * @param homeVictory true if first team won, false if not
     */
    public EloCalculator(int homeElo, int awayElo, boolean homeVictory){
        logger.info("Calculating ELO for game home team {} away team {} home victory {}", homeElo, awayElo, homeVictory);
        rn1 = calculate(homeElo, awayElo, true, homeVictory);
        rn2 = calculate(awayElo, homeElo, false, !homeVictory);
        logger.info("Resulting elos are home team {} away team {}", rn1, rn2);
    }

    //Rn = Ro + K * (W - We)
    //Rn: New rating
    //Ro: Old rating
    //K: Weight constant for game played
    //W: result of game (1 for win, .5, 0)
    //We: expected result
    //We = 1/(10^(-dr/400) + 1)
    //dr = difference in ratings + home field advantage (100?)
    private int calculate(int ro1, int ro2, boolean isHome, boolean victory){
        double dr = ro1 - ro2;
        if (isHome) {dr += HOME_FIELD_ADVANTAGE;}
        else {dr -= HOME_FIELD_ADVANTAGE;}

        double we = 1 / ( Math.pow(10,-dr/400) + 1);

        double w;
        if (victory) {w = 1;}
        else {w = 0;}
        double rn = ro1 + K * (w - we );
        return (int) rn;
    }

    public int getRn1(){
        return rn1;
    }

    public int getRn2(){
        return rn2;
    }
}
