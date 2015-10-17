package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;

/**
 * @author athalay
 */
public class RaiseMoneyEvaulationPhase implements EvaluationPhase {

    @Override
    public int eval(GameState gameState) {
        int result = gameState.getMinimumRaise() * 10 / gameState.getCall();

        return Math.min(result, 3);
    }

}
