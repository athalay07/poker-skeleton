package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;
import java.util.List;

/**
 * @author athalay
 */
public class Evaluator {

    List<EvaluationPhase> phases;

    public Evaluator(List<EvaluationPhase> phases) {
        this.phases = phases;
    }

    public int evaluate(GameState gameState) {
        int goodness = 0;
        for (EvaluationPhase phase : phases) {
            goodness += phase.eval(gameState);
        }

        if (goodness <= 0) {
            return 0;
        }

        if (goodness <= 12) {
            return gameState.getCall();
        }

        if (goodness > 12 && goodness <= 14) {
            return gameState.getRaise();
        }

        if (goodness > 14 && goodness <= 18) {
            return gameState.getRaise() + gameState.getMinimumRaise(); //getraise contains one min raise already
        }
        if (goodness > 18) {
            return gameState.getRaise() + gameState.getMinimumRaise() * 2; //getraise contains one min raise already
        }

        return goodness;
    }

}
