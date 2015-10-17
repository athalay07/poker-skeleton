/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import com.wcs.poker.gamestate.Rank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timi
 */
public class HandEvaluationPhase implements EvaluationPhase {

    private final List<Rank> highRanks = new ArrayList<>();

    public HandEvaluationPhase() {
        highRanks.add(Rank.TEN);
        highRanks.add(Rank.JACK);
        highRanks.add(Rank.QUEEN);
        highRanks.add(Rank.KING);
        highRanks.add(Rank.ACE);
    }

    @Override
    public int eval(GameState gameState) {
        Player player = gameState.getPlayers().get(gameState.getInAction());
        Card card1 = player.getHoleCards().get(0);
        Rank rank1 = card1.getRank();
        Card card2 = player.getHoleCards().get(1);
        Rank rank2 = card2.getRank();

        boolean sameSuit = card1.getSuit().equals(card2.getSuit());

        int value = 0;

        if (highRanks.contains(rank1) || highRanks.contains(rank2)) {
            value = 2;
        }

        if (highRanks.contains(rank1) && highRanks.contains(rank2) && sameSuit) {
            value = 4;
        }

        if (highRanks.contains(rank1) && highRanks.contains(rank2)) {
            value = 6;
        }

        if (highRanks.contains(rank1) && highRanks.contains(rank2) && sameSuit) {
            value = 8;
        }

        if (rank1.equals(rank2)) {
            value = 12;
        }

        if (rank1.equals(rank2) && highRanks.contains(rank1)) {
            value = 20;
        }

        return value;
    }

}
