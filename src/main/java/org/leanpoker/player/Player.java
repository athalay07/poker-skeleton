package org.leanpoker.player;

import com.wcs.poker.bloodorange.evaluationphase.EvaluationPhase;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.List;

public class Player {

    static final String VERSION = "BloodOrange";

    static List<EvaluationPhase> phases = new ArrayList<>();

    public static int betRequest(GameState gameState) {
        com.wcs.poker.gamestate.Player player = gameState.getPlayers().get(gameState.getInAction());
        if (player.getHoleCards().get(0).getRank().equals(player.getHoleCards().get(1).getRank())) {
            return gameState.getCurrentBuyIn() - player.getBet() + gameState.getMinimumRaise();
        }

        int sum = 0;

        for (EvaluationPhase phase : phases) {
            sum += phase.eval(gameState);
        }

        return gameState.getCurrentBuyIn() - player.getBet();
    }

    public static void showdown(GameState gameState) {
    }
}
