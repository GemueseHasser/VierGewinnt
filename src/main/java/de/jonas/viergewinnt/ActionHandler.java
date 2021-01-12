package de.jonas.viergewinnt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Es wird im {@link ActionHandler} abgefragt, ob der Spieler am Zug ist, und es auch sonst keine Komplikationen gibt,
 * und dann wird hierdurch das Setzen der Spiel-Chips durch den {@link ChipPlacer} angeregt.
 */
public class ActionHandler implements ActionListener {

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public void actionPerformed(final ActionEvent e) {
        if (AnimationState.getAnimationState() != AnimationState.NULL) {
            return;
        }
        if (GameState.getState() == GameState.COMPUTER) {
            return;
        }
        for (int i = 0; i < GUI.getBUTTONS().length; i++) {
            if (e.getSource() != GUI.getBUTTONS()[i]) {
                continue;
            }
            if (ChipPlacer.placeChip(i) == -1) {
                System.out.println("Die Spalte ist voll!");
                return;
            }
        }
    }
}
