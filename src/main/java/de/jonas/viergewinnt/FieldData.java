package de.jonas.viergewinnt;

import lombok.Getter;
import lombok.Setter;

/**
 * Es werden alle Informationen zum Zeichnen der Chip-Felder durch die {@link Draw Zeichnen} Klasse gespeichert.
 */
public class FieldData {

    //<editor-fold desc="CONSTANTS">
    /**
     * Die X-Positionen aller Chip-Felder werden gespeichert, um sie von hier beim zeichnen dieser Felder aus der {@link
     * Draw Zeichnen} Klasse auslesen zu können.
     */
    @Getter
    private static final int[] X = {
        22,
        22,
        22,
        22,
        142,
        142,
        142,
        142,
        267,
        267,
        267,
        267,
        392,
        392,
        392,
        392,
        516,
        516,
        516,
        516,
        630,
        630,
        630,
        630,
    };

    /**
     * Die Y-Positionen aller Chip-Felder werden gespeichert, um sie von hier beim zeichnen dieser Felder aus der {@link
     * Draw Zeichnen} Klasse auslesen zu können.
     */
    @Getter
    private static final int[] Y = {
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        252,
        353,
    };
    //</editor-fold>

    /**
     * Die Y-Positionen aller Chip-Felder werden gespeichert, um sie durch die {@link Animation} beim herausfallen der
     * Chips stetig neu zu berechnen und die Felder durch die {@link Draw Zeichnen} Klasse neu zeichnen zu lassen.
     */
    @Getter
    @Setter
    @SuppressWarnings("checkstyle:MagicNumber")
    private static int[] fallingY = {
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        253,
        352,
        52,
        152,
        252,
        353,
    };

    /**
     * Der {@link GameState Spiel-Status} der einzelnen Chip-Felder.
     */
    @Getter
    @Setter
    private static GameState[] gameStates = {
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
        GameState.NOTHING,
    };

}
