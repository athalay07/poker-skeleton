/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author athalay
 */
public class RaiseMoneyEvaulationPhaseTest {

    public RaiseMoneyEvaulationPhaseTest() {
    }

    @Test
    public void testWereGood() throws IOException, URISyntaxException {
        GameState gameState = getGameState();
        RaiseMoneyEvaulationPhase phase = new RaiseMoneyEvaulationPhase();
        int eval = phase.eval(gameState);
        Assert.assertEquals(0, eval);
    }

    public GameState getGameState() throws IOException, URISyntaxException {
        URL resource = getClass().getResource("/testGameState_raise_money_1.json");
        Files.readAllBytes(Paths.get(resource.toURI()));
        String json = new String(Files.readAllBytes(Paths.get(resource.toURI())), StandardCharsets.UTF_8);
        GameState gameState = new JsonConverter<>(GameState.class).fromJson(json);
        return gameState;
    }

}
