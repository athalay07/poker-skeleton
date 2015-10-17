/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.bloodorange.evaluationphase.EvaluationPhase;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Athalay
 */
public class AfterFlopHandEvaluationPhase implements EvaluationPhase {

    List<HandEvaluator> evaluators = Arrays.asList(new HandEvaluator[]{
        new PokerCardsEvaluator(),
        new FlushEvaluator(),
        new DrillCardsEvaluator(),
        new TwoPairsCardsEvaluator(),
        new PairCardsEvaluator()
    });

    @Override
    public int eval(GameState gameState) {
        List<Card> cards = new ArrayList<>(7);
        cards.addAll(gameState.getCommunityCards());
        cards.addAll(gameState.getPlayers().get(gameState.getInAction()).getHoleCards());

        for (HandEvaluator evaluator : evaluators) {
            int result = evaluator.eval(cards);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

}
