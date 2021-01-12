package de.jonas.viergewinnt;

/**
 * Das setzen der Animationen wird durch dieses Interface angeregt.
 */
public interface Animation {

    /**
     * Einzelne Animationen werden abhängig vom {@link AnimationState} gesetzt.
     *
     * @param state der {@link AnimationState}
     */
    void setAnimation(AnimationState state);

}
