/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Timi
 */
public class FullEvaluator implements HandEvaluator {

    @Override
    public int eval(List<Card> cards) {
        Map<Rank, Integer> ranks = new HashMap<>();
        boolean sameRank2 = false;
        boolean sameRank3 = false;

        for (Card card : cards) {
            Integer i = ranks.get(card.getRank());
            if (i == null) {
                i = 0;
            }
            i = i + 1;
            ranks.put(card.getRank(), i);
        }

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Integer value = entry.getValue();
            if (value == 3) {
                sameRank3 = true;
            }
            if (value == 2) {
                sameRank2 = true;
            }
        }

        if (sameRank2 && sameRank3) {
            return 20;
        }
        return 0;
    }

}
