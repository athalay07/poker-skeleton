package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.HighRanks;
import com.wcs.poker.gamestate.Rank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author athalay
 */
public class TwoPairsCardsEvaluator implements HandEvaluator {

    HighRanks highRanks = new HighRanks();

    @Override
    public int eval(List<Card> cards) {
        Map<Rank, Integer> cardsByRank = new HashMap<>();

        for (Card card : cards) {
            Integer i = cardsByRank.get(card.getRank());
            if (i == null) {
                i = 0;
            }
            i = i + 1;
            cardsByRank.put(card.getRank(), i);
            
        }

        int pairs = 0;
        for (Map.Entry<Rank, Integer> entrySet : cardsByRank.entrySet()) {
            Integer value = entrySet.getValue();
            if (value == 2) {
                pairs++;
            }
        }

        if (pairs >= 2) {
            return 14;
        }
        return 0;
    }

}
