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
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author athalay
 */
public class EvaluatorTest {


    public EvaluatorTest() {
    }

    @Test
    public void evaluationTest() throws IOException, URISyntaxException {
        Evaluator evaluator = createPhase(2);
        GameState gameState = getGameState();

        assertEquals(gameState.getCall(), evaluator.evaluate(gameState));
    }

    @Test
    public void evaluationTestMinRaise() throws IOException, URISyntaxException {
        Evaluator evaluator = createPhase(7);
        GameState gameState = getGameState();

        assertEquals(gameState.getRaise(), evaluator.evaluate(gameState));
    }
    @Test
    public void evaluationTestFold() throws IOException, URISyntaxException {
        Evaluator evaluator = createPhase(-2);
        GameState gameState = getGameState();

        assertEquals(0, evaluator.evaluate(gameState));
    }
    @Test
    public void evaluationTestBigRaise() throws IOException, URISyntaxException {
        Evaluator evaluator = createPhase(11);
        GameState gameState = getGameState();

        assertEquals(gameState.getRaise() + gameState.getMinimumRaise(), evaluator.evaluate(gameState));
    }

    public GameState getGameState() throws IOException, URISyntaxException {
        URL resource = getClass().getResource("/testGameState.json");
        Files.readAllBytes(Paths.get(resource.toURI()));
        String json = new String(Files.readAllBytes(Paths.get(resource.toURI())), StandardCharsets.UTF_8);
        GameState gameState = new JsonConverter<>(GameState.class).fromJson(json);
        return gameState;
    }

    public static Evaluator createPhase(final int goodness) {
        return new Evaluator(Arrays.asList(new EvaluationPhase[]{new EvaluationPhase() {
            @Override
            public int eval(GameState gameState) {
                return goodness;
            }
        }}));
    }

}
