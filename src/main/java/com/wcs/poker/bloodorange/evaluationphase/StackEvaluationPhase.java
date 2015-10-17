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
public class StackEvaluationPhase implements EvaluationPhase {

    @Override
    public int eval(GameState gameState) {
        Player player = gameState.getPlayers().get(gameState.getInAction());
        int stack = player.getStack();
        int minRaise = gameState.getMinimumRaise();
        int value = 0;

        if (stack < minRaise * 10) {
            value = minRaise * 10 / stack;
        }

        if (value > 5) {
            value = 5;
        }

        return -value;
    }

}
