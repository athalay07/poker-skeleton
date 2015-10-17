package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;

/**
 * @author athalay
 */
public interface EvaluationPhase {
    public int eval(GameState gameState);
}
