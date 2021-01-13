package de.jonas.viergewinnt;

/**
 * Das setzen der Animationen wird durch dieses Interface angeregt.
 */
public interface Animation {

    /**
     * Einzelne Animationen werden abhängig vom {@link AnimationState} gesetzt.
     *
     * @param animationState der {@link AnimationState}
     * @param gameState  der {@link GameState}
     */
    void setAnimation(AnimationState animationState, GameState gameState);

}
