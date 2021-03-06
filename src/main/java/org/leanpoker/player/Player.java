package org.leanpoker.player;

import com.wcs.poker.bloodorange.evaluationphase.EvaluationPhase;
import com.wcs.poker.bloodorange.evaluationphase.Evaluator;
import com.wcs.poker.bloodorange.evaluationphase.HandEvaluationPhase;
import com.wcs.poker.bloodorange.evaluationphase.RaiseMoneyEvaulationPhase;
import com.wcs.poker.bloodorange.evaluationphase.StackEvaluationPhase;
import com.wcs.poker.bloodorange.evaluationphase.afterflop.AfterFlopHandEvaluationPhase;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    static final String VERSION = "BloodOrange";

    static List<EvaluationPhase> phases = new ArrayList<>();

    public static int betRequest(GameState gameState) {
        Evaluator preFlopEvaluator = new Evaluator(Arrays.asList(new EvaluationPhase[]{
            new HandEvaluationPhase(),
            new StackEvaluationPhase(),
            new RaiseMoneyEvaulationPhase()
        }));

        if (gameState.getCommunityCards().isEmpty()) {
            return preFlopEvaluator.evaluate(gameState);
        } else {
            return new AfterFlopHandEvaluationPhase().eval(gameState);
        }
    }

    public static void showdown(GameState gameState) {
    }
}
