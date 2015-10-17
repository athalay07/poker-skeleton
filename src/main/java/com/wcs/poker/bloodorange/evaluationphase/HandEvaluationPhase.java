/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase;

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
        Rank rank1 = player.getHoleCards().get(0).getRank();
        Rank rank2 = player.getHoleCards().get(1).getRank();
        int value = 0;

        if (highRanks.contains(rank1) || highRanks.contains(rank2)) {
            value = 2;
        }

        if (highRanks.contains(rank1) && highRanks.contains(rank2)) {
            value = 4;
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
