package de.jonas.viergewinnt;

import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Das Graphical-User-Interface, auf dem das Spiel, für den Nutzer grafisch dargestellt wird.
 */
public class GUI {


    //<editor-fold desc="CONSTANTS">
    /** Die Breite des Fentsers. */
    private static final int WIDTH = 750;
    /** Die Höhe des Fensters. */
    @Getter
    private static final int HEIGHT = 500;
    /** Anzahl an Buttons. */
    private static final int BUTTON_AMOUNT = 6;
    /** Die buttons, die im Hintergrund alles regeln xD. */
    @Getter
    private static final JButton[] BUTTONS = new JButton[BUTTON_AMOUNT];
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt ein neues und unabhängiges {@link GUI} Graphical-User-Interface.
     */
    public GUI() {
        openFrame();
    }
    //</editor-fold>


    /**
     * Öffnet das Haupt-Fenster, in dem das Spiel dargestellt wird.
     */
    private void openFrame() {
        final JFrame frame = new JFrame("Vier Gewinnt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        Draw draw = new Draw();
        draw.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        draw.setVisible(true);

        for (int i = 0; i < BUTTONS.length; i++) {
            BUTTONS[i] = new JButton();
            BUTTONS[i].setFocusPainted(false);
            BUTTONS[i].setContentAreaFilled(false);
            BUTTONS[i].setBorder(null);
            BUTTONS[i].addActionListener(new ActionHandler());
            frame.add(BUTTONS[i]);
        }

        placeButtons();

        frame.add(draw);
        frame.setVisible(true);
    }

    /**
     * Setzt die Buttons alle an dessen richtige Position.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    private void placeButtons() {
        BUTTONS[0].setBounds(0, 0, 123, HEIGHT);
        BUTTONS[1].setBounds(123, 0, 123, HEIGHT);
        BUTTONS[2].setBounds(246, 0, 123, HEIGHT);
        BUTTONS[3].setBounds(369, 0, 123, HEIGHT);
        BUTTONS[4].setBounds(492, 0, 123, HEIGHT);
        BUTTONS[5].setBounds(615, 0, 123, HEIGHT);
    }
}
