package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "BloodOrange";

    public static int betRequest(GameState gameState) {
        com.wcs.poker.gamestate.Player player = gameState.getPlayers().get(gameState.getInAction());
        if (player.getHoleCards().get(0).getRank().equals(player.getHoleCards().get(1).getRank())) {
            return gameState.getCurrentBuyIn() - player.getBet() + gameState.getMinimumRaise();
        }

        return 0;
    }

    public static void showdown(GameState gameState) {
    }
}
