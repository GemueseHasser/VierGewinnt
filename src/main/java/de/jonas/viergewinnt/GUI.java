package de.jonas.viergewinnt;

import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Das Graphical-User-Interface, auf dem das Spiel und dessen Unter-Fenster, für den Nutzer grafisch dargestellt wird.
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
    /** Die Schriftart, die in allen Fenstern genutzt wird. */
    private static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 19);
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue und unabhängige Instanz des {@link GUI Graphical-User-Interface}.
     * @param state Die Art, welches GUI geöffnet werden soll. Entweder das normale Spiel (0) oder das Fenster für
     *              unentschieden (1)
     */
    public GUI(final int state) {
        if (state == 0) {
            openGameFrame();
        } else if (state == 1) {
            createFrameOnTop("Es ist unentschieden!");
        }
    }

    /**
     * Erzeugt eine neue und unabhängige Instanz des {@link GUI Graphical-User-Interface}.
     * @param state Gibt den Spieler an, der gewonnen hat
     */
    public GUI(final GameState state) {
        if (state == GameState.COMPUTER) {
            createFrameOnTop("Der Computer hat gewonnen!");
        } else {
            createFrameOnTop("Du hast gewonnen!");
        }
    }
    //</editor-fold>


    /**
     * Öffnet das Haupt-Fenster, in dem das Spiel dargestellt wird.
     */
    private void openGameFrame() {
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

    @SuppressWarnings("checkstyle:MagicNumber")
    private void createFrameOnTop(final String text) {
        final JFrame frame = new JFrame(text);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(0, 0, 300, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setBackground(Color.GRAY);
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);

        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(DEFAULT_FONT);
        label.setBounds(-5, 30, frame.getWidth(), 50);

        JButton newGame = new JButton("Neues Spiel");
        newGame.setBounds(50, 100, 200, 40);
        newGame.setOpaque(true);
        newGame.setBackground(Color.DARK_GRAY);
        newGame.setForeground(Color.WHITE);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frame.dispose();
                GameState.setState(GameState.PLAYER);
                AnimationState.setAnimationState(AnimationState.NULL);
            }
        });

        JButton stop = new JButton("Beenden");
        stop.setBounds(50, 160, 200, 40);
        stop.setOpaque(true);
        stop.setBackground(Color.DARK_GRAY);
        stop.setForeground(Color.WHITE);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        frame.add(label);
        frame.add(newGame);
        frame.add(stop);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
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
