package de.jonas;

import de.jonas.viergewinnt.AnimationState;
import de.jonas.viergewinnt.ChipPlacer;
import de.jonas.viergewinnt.GUI;
import de.jonas.viergewinnt.GameState;
import de.jonas.viergewinnt.WinAlgorithms;

/**
 * Die Haupt- und Main-Klasse der Applikation.
 */
public class VierGewinnt {

    /**
     * Die Applikation wird hiermit gestartet.
     *
     * @param args .
     */
    public static void main(final String[] args) {
        GameState.setState(GameState.PLAYER);
        AnimationState.setAnimationState(AnimationState.NULL);
        new GUI(0);
        new ChipPlacer();
        new WinAlgorithms();
    }

}
