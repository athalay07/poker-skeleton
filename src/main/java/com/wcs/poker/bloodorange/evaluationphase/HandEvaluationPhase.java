/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;

/**
 *
 * @author Timi
 */
public class HandEvaluationPhase implements EvaluationPhase {

    @Override
    public int eval(GameState gameState) {
        Player player = gameState.getPlayers().get(gameState.getInAction());
        if (player.getHoleCards().get(0).getRank().equals(player.getHoleCards().get(1).getRank())) {
            return gameState.getCurrentBuyIn() - player.getBet() + gameState.getMinimumRaise();
        }
        return 0;
    }
    
}
