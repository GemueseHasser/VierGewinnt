package de.jonas.viergewinnt;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;

/**
 * Über den {@link GameState} wird geregelt, wer gerade am Zug ist und welche Chip-Farbe dieser hat.
 */
public enum GameState {

    /** Der Spiel-Status eines Spielers. */
    PLAYER(
        Color.YELLOW
    ),
    /** Der Spiel-Status eines Computers bzw Bots. */
    COMPUTER(
        Color.RED
    ),
    /** Der Spiel-Status, für nichts. ALso ein leerer Spiel-Status. */
    NOTHING(
        Color.WHITE
    );

    /** {@link GameState} des {@link GameState Spiel-Status}. */
    @Getter
    @Setter
    private static GameState state;

    /** Farbe des des {@link GameState Spiel-Status}. */
    @Getter
    private final Color color;

    /**
     * Erstellt ein neuen {@link GameState}. Die übergebene {@link Color Farbe} wird als Farbe, beim setzen der
     * Spiel-Chips durch den {@link ChipPlacer} genutzt.
     *
     * @param color Die {@link Color Farbe}, die als Anzeige-Farbe der gesetzten und ungesetzten Chips bzw Chip-Flächen
     *              dient.
     */
    GameState(
        @NotNull final Color color
    ) {
        this.color = color;
    }

}
