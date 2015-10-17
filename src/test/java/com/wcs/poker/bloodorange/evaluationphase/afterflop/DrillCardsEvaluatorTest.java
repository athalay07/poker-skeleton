/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import com.wcs.poker.gamestate.Suit;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author athalay
 */
public class DrillCardsEvaluatorTest {

    @Test
    public void testDrill() {
        List<Card> cards = Arrays.asList(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.HEARTS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.KING, Suit.DIAMONDS)
        );

        assertEquals(16, new DrillCardsEvaluator().eval(cards));
    }
    @Test
    public void testNoDrill() {
        List<Card> cards = Arrays.asList(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.HEARTS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.KING, Suit.DIAMONDS)
        );

        assertEquals(0, new DrillCardsEvaluator().eval(cards));
    }

}
