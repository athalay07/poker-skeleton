package com.wcs.poker.bloodorange.evaluationphase;


import com.wcs.poker.bloodorange.evaluationphase.HandEvaluationPhase;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Timi
 */
public class HandEvaluationPhaseTest {

    public HandEvaluationPhaseTest() {
    }

    @Test
    public void test() throws IOException, URISyntaxException {
        HandEvaluationPhase HandEvaluationPhase = new HandEvaluationPhase();
        URL resource = getClass().getResource("/testGameState.json");
        Files.readAllBytes(Paths.get(resource.toURI()));
        String json = new String(Files.readAllBytes(Paths.get(resource.toURI())), StandardCharsets.UTF_8);

        GameState gameState = new JsonConverter<>(GameState.class).fromJson(json);
        
        Assert.assertEquals(2, HandEvaluationPhase.eval(gameState));
    }

}
