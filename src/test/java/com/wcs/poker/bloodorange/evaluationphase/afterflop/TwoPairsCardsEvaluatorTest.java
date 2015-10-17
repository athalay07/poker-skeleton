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
public class TwoPairsCardsEvaluatorTest {

    public TwoPairsCardsEvaluatorTest() {
    }

    @Test
    public void testSomeMethod() {
        List<Card> cards = Arrays.asList(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.DIAMONDS)
        );

        assertEquals(14, new TwoPairsCardsEvaluator().eval(cards));
    }

    @Test
    public void testOnePair() {
        List<Card> cards = Arrays.asList(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.HEARTS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.JACK, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.DIAMONDS)
        );

        assertEquals(0, new TwoPairsCardsEvaluator().eval(cards));
    }

}
