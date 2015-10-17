package com.wcs.poker.gamestate;

import java.util.ArrayList;

/**
 * @author athalay
 */
public class HighRanks extends ArrayList<Rank> {

    {
        add(Rank.TEN);
        add(Rank.JACK);
        add(Rank.QUEEN);
        add(Rank.KING);
        add(Rank.ACE);
    }
}
