package de.jonas.viergewinnt;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Es werden alle gesetzten Chips ausgewertet und überprüft ob der Spieler, der Computer, oder noch niemand gewonnen
 * hat. Falls jemand gewonnen hat, wird ein Fenster geöffnet, worin angezeigt wird, wer gewonnen hat und er wird
 * gefragt, ob er eine neue Runde starten möchte, oder ob er das Spiel beenden möchte.
 */
public class WinAlgorithms implements Animation {


    //<editor-fold desc="CONSTANTS">
    /** Der {@link Timer}, der in einem regelmäßigen Abstand, das Spiel auf einen Gewinn überprüft. */
    private static final Timer TIMER = new Timer();
    /** Der zeitliche Abstand in Millisekunden, in dem der {@link Timer} das Spiel auf einen Gewinn überprüft. */
    private static final int TIMER_DELAY = 100;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Es wird eine neue und unabhänige Instanz des {@link WinAlgorithms} erstellt, worin der {@link Timer} der das
     * gesamte Spiel alle {@value TIMER_DELAY} überprüft und auswertet.
     */
    public WinAlgorithms() {
        TIMER.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (isFull()) {
                    AnimationState.setAnimationState(AnimationState.CHIPS_FALL_OUT);
                    setAnimation(AnimationState.CHIPS_FALL_OUT, GameState.NOTHING);
                    new GUI(2);
                }
                if (GameState.getState() == GameState.NOTHING) {
                    return;
                }
                if (isQuer(GameState.PLAYER)
                    || isHoch(GameState.PLAYER)
                    || isSchreag(GameState.PLAYER)
                ) {
                    AnimationState.setAnimationState(AnimationState.CHIPS_FALL_OUT);
                    setAnimation(AnimationState.CHIPS_FALL_OUT, GameState.PLAYER);
                }

                if (isQuer(GameState.COMPUTER)
                    || isHoch(GameState.COMPUTER)
                    || isSchreag(GameState.COMPUTER)
                ) {
                    AnimationState.setAnimationState(AnimationState.CHIPS_FALL_OUT);
                    setAnimation(AnimationState.CHIPS_FALL_OUT, GameState.COMPUTER);
                }
            }
        }, 0, TIMER_DELAY);
    }
    //</editor-fold>

    /**
     * Es wird überprüft, ob in dem Spiel vier aneinander-liegende Chips mit demselben {@link GameState GameState} in
     * einer Reihe liegen.
     *
     * @param state Der {@link GameState GameState}, auf den die vier aneinander-liegenden Chips überprüft werden
     *
     * @return Liegen irgendwo im Spiel vier gleiche Chips unmittelbar aneinander in einer Reihe oder nicht
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    private boolean isQuer(@NotNull final GameState state) {
        // vier mögliche Reihen
        for (int i = 0; i < 4; i++) {
            // drei mögliche Zustände pro Reihe
            for (int i1 = 0; i1 < 3; i1++) {
                int start = i1 * 4;
                int one = i + start;
                int two = i + start + 4;
                int three = two + 4;
                int four = three + 4;
                if (FieldData.getGameStates()[one] == state
                    && FieldData.getGameStates()[two] == state
                    && FieldData.getGameStates()[three] == state
                    && FieldData.getGameStates()[four] == state
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Es wird überprüft, ob in dem Spiel vier aneinander-liegende Chips mit demselben {@link GameState GameState} in
     * einer Spalte liegen.
     *
     * @param state Der {@link GameState GameState}, auf den die vier aneinander-liegenden Chips überprüft werden
     *
     * @return Liegen irgendwo im Spiel vier gleiche Chips unmittelbar aneinander in einer Spalte oder nicht
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    private boolean isHoch(@NotNull final GameState state) {
        for (int i = 0; i < 20; i += 4) {
            if (FieldData.getGameStates()[i] == state
                && FieldData.getGameStates()[i + 1] == state
                && FieldData.getGameStates()[i + 2] == state
                && FieldData.getGameStates()[i + 3] == state
            ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Es wird überprüft, ob in dem Spiel vier aneinander-liegende Chips schräk mit demselben {@link GameState
     * GameState} liegen.
     *
     * @param state Der {@link GameState GameState}, auf den die vier aneinander-liegenden Chips überprüft werden
     *
     * @return Liegen irgendwo im Spiel vier gleiche Chips unmittelbar aneinander in einer Spalte oder nicht
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    private boolean isSchreag(@NotNull final GameState state) {
        for (int i = 0; i < 20; i += 4) {
            if (i < 12) {
                // schräk nach unten von links nach rechts
                if (FieldData.getGameStates()[i] == state
                    && FieldData.getGameStates()[i + 5] == state
                    && FieldData.getGameStates()[i + 10] == state
                    && FieldData.getGameStates()[i + 15] == state
                ) {
                    return true;
                }
            } else {
                // schräk nach unten von rechts nach links
                if (FieldData.getGameStates()[i] == state
                    && FieldData.getGameStates()[i - 3] == state
                    && FieldData.getGameStates()[i + 6] == state
                    && FieldData.getGameStates()[i + 9] == state
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Es wird abgefragt, ob das Spielfeld voll ist.
     *
     * @return Ob das Spielfeld voll ist oder nicht
     */
    private boolean isFull() {
        for (int i = 0; i < FieldData.getGameStates().length; i++) {
            if (FieldData.getGameStates()[i] == GameState.NOTHING) {
                return false;
            }
        }
        return true;
    }

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public void setAnimation(final AnimationState animationState, final GameState gameState) {
        if (AnimationState.getAnimationState() == AnimationState.NULL) {
            return;
        }
        if (animationState == AnimationState.CHIPS_FALL_OUT) {
            AnimationState.setAnimationState(AnimationState.CHIPS_FALL_OUT);
            for (int i = 0; i < FieldData.getGameStates().length; i++) {
                if (FieldData.getFallingY()[0] > GUI.getHEIGHT() + 20) {
                    System.out.println("-----------------------");
                    System.out.println("Animation complete!");
                    FieldData.setGameStates(new GameState[]{
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
                    });
                    System.out.println("Set GameState[]");
                    FieldData.setFallingY(new int[]{
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
                    });
                    System.out.println("Set Falling Y coordinate to 'DEFAULT'");
                    System.out.println("-----------------------");
                    if (gameState == GameState.NOTHING) {
                        return;
                    }
                    new GUI(gameState);
                    return;
                }
                FieldData.getFallingY()[i] += 15;
            }
        }
    }
}
