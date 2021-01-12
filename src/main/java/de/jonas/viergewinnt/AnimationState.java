package de.jonas.viergewinnt;

import lombok.Getter;
import lombok.Setter;

/**
 * Durch den {@link AnimationState} kann die Animation, explizit bestimmt werden und somit auch explizit definiert
 * werden.
 */
public enum AnimationState {

    /**
     * Der {@link AnimationState} für die {@link Animation}, wenn das Spiel vorbei ist und alle Chips aus dem Spielfeld
     * herausfallen.
     */
    CHIPS_FALL_OUT,
    /**
     * Der {@link AnimationState}, für eine "leere" Animation, bzw keine Animation. Durch diesen {@link AnimationState}
     * werden alle anderen States "deaktiviert", bzw da immer nur ein {@link AnimationState} aktiv sein kann, ist dann
     * nur noch dieser "leere" {@link AnimationState} aktiv.
     */
    NULL;

    /** {@link AnimationState} um die einzelnen Konstanten des {@link AnimationState} zu setzen oder zu bekommen. */
    @Getter
    @Setter
    private static AnimationState animationState;

}
