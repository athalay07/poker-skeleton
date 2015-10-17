package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;

/**
 * @author athalay
 */
public class RaiseMoneyEvaulationPhase implements EvaluationPhase {

    @Override
    public int eval(GameState gameState) {
        int call = gameState.getCall();

        if (call == 0) {
            return 0;
        }

        int result = gameState.getMinimumRaise() * 10 / call;

        return Math.min(result, 3);
    }

}
