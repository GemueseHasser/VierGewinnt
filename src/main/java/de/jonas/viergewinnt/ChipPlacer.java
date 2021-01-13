package de.jonas.viergewinnt;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Mit dem {@link ChipPlacer} setzt der Bot seine Chips automatisiert und überprüft gleichzeitig, ob das Spielfeld voll
 * ist. Wenn dies der Fall ist, kommt die {@link Animation} zum Einsatz, die für das herausfallen der Chips zuständig
 * ist.
 */
public class ChipPlacer implements Animation {


    //<editor-fold desc="CONSTANTS">
    /** In welchen Abständen (in Milli-Sekunden) der Bot das Spiel überprüft und setzt. */
    private static final int TIMER_DELAY = 100;
    /** {@link Timer}, der in regelmäßigem abstand {@value TIMER_DELAY} den Bot laufen lässt. */
    private static final Timer TIMER = new Timer();
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Der {@link Timer} des Bot wird ausgeführt und das Spiel wird geprüft.
     */
    public ChipPlacer() {
        TIMER.scheduleAtFixedRate(new TimerTask() {
            @Override
            @SuppressWarnings("checkstyle:MagicNumber")
            public void run() {
                if (isFull()) {
                    AnimationState.setAnimationState(AnimationState.CHIPS_FALL_OUT);
                    setAnimation(AnimationState.CHIPS_FALL_OUT);
                }
                if (GameState.getState() != GameState.COMPUTER) {
                    return;
                }
                int random = (int) Math.round(Math.random() * 5);
                if (placeChip(random) == -1) {
                    GameState.setState(GameState.COMPUTER);
                    return;
                }
                GameState.setState(GameState.PLAYER);
            }
        }, 0, TIMER_DELAY);
    }
    //</editor-fold>


    /**
     * Ein Chip, von dem Spieler der gerade am Zug ist, wird an den ersten freien Punkt von unten, in eine angeklickte
     * Spalte gelegt.
     *
     * @param spalte Die Spalte, in die der Chip gelegt werden soll
     *
     * @return Ob der Chip hereingelegt wurde, oder ob die Spalte schon voll war, und es erneut versucht werden muss
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public static int placeChip(final int spalte) {
        for (int i1 = ((spalte + 1) * 4) - 1; i1 > (spalte * 4) - 1; i1--) {
            if (FieldData.getGameStates()[i1] != GameState.NOTHING) {
                if (FieldData.getGameStates()[((spalte + 1) * 4) - 1] != GameState.NOTHING
                    && FieldData.getGameStates()[((spalte + 1) * 4) - 2] != GameState.NOTHING
                    && FieldData.getGameStates()[((spalte + 1) * 4) - 3] != GameState.NOTHING
                    && FieldData.getGameStates()[((spalte + 1) * 4) - 4] != GameState.NOTHING
                ) {
                    return -1;
                }
                continue;
            }
            FieldData.getGameStates()[i1] = GameState.getState();
            switch (GameState.getState()) {
                case COMPUTER:
                    GameState.setState(GameState.PLAYER);
                    break;

                case PLAYER:
                    GameState.setState(GameState.COMPUTER);
                    break;

                default:
                    break;
            }
            return 0;
        }
        return -1;
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
    public void setAnimation(final AnimationState state) {
        if (AnimationState.getAnimationState() == AnimationState.NULL) {
            return;
        }
        if (state == AnimationState.CHIPS_FALL_OUT) {
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
                    AnimationState.setAnimationState(AnimationState.NULL);
                    GameState.setState(GameState.PLAYER);
                    System.out.println("Animation-State: " + AnimationState.getAnimationState().name());
                    System.out.println("Game-State: " + GameState.getState().name());
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
                    return;
                }
                FieldData.getFallingY()[i] += 15;
            }
        }
    }
}
