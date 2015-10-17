/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.bloodorange.evaluationphase.afterflop;

import com.wcs.poker.gamestate.Card;
import java.util.List;

/**
 *
 * @author Timi
 */
public interface HandEvaluator {
    
    public int eval(List<Card> cards);
}
