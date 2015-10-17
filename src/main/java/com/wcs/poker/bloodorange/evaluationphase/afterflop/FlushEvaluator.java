/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Suit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Timi
 */
public class FlushEvaluator implements HandEvaluator {

    @Override
    public int eval(List<Card> cards) {
        Map<Suit, Integer> suits = new HashMap<>();

        for (Card card : cards) {
            Integer i = suits.get(card.getSuit());
            if (i == null) {
                i = 0;
            }
            i = i + 1;
            suits.put(card.getSuit(), i);
        }

        for (Map.Entry<Suit, Integer> entrySet : suits.entrySet()) {
            Integer value = entrySet.getValue();
            if (value == 5) {
                return 18;
            }
        }

        return 0;
    }

}
