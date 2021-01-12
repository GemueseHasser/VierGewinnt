package de.jonas.viergewinnt;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Es werden Grafiken auf das {@link GUI} Graphical-User-Interface gezeichnet.
 */
public class Draw extends JLabel {

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g.setColor(Color.BLACK);

        g.drawRect(
            8,
            38,
            this.getWidth() - 27,
            this.getHeight() - 90
        );

        g.setColor(Color.BLUE);

        g.fillRect(
            10,
            40,
            this.getWidth() - 30,
            this.getHeight() - 90
        );

        for (int i = 0; i < FieldData.getGameStates().length; i++) {
            g.setColor(GameState.NOTHING.getColor());
            g.fillOval(FieldData.getX()[i], FieldData.getY()[i], 80, 80);
        }

        if (AnimationState.getAnimationState() == AnimationState.CHIPS_FALL_OUT) {
            for (int i = 0; i < FieldData.getGameStates().length; i++) {
                switch (FieldData.getGameStates()[i]) {
                    case PLAYER:
                        g.setColor(GameState.PLAYER.getColor());
                        g.fillOval(FieldData.getX()[i], FieldData.getFallingY()[i], 80, 80);
                        break;

                    case COMPUTER:
                        g.setColor(GameState.COMPUTER.getColor());
                        g.fillOval(FieldData.getX()[i], FieldData.getFallingY()[i], 80, 80);
                        break;

                    default:
                        break;
                }
                g.setColor(Color.BLACK);

                g.drawOval(
                    FieldData.getX()[i],
                    FieldData.getY()[i],
                    81,
                    81
                );
            }
        } else {
            for (int i = 0; i < FieldData.getGameStates().length; i++) {
                switch (FieldData.getGameStates()[i]) {
                    case PLAYER:
                        g.setColor(GameState.PLAYER.getColor());
                        g.fillOval(FieldData.getX()[i], FieldData.getY()[i], 80, 80);
                        break;

                    case COMPUTER:
                        g.setColor(GameState.COMPUTER.getColor());
                        g.fillOval(FieldData.getX()[i], FieldData.getY()[i], 80, 80);
                        break;

                    default:
                        break;
                }
                g.setColor(Color.BLACK);

                g.drawOval(
                    FieldData.getX()[i],
                    FieldData.getY()[i],
                    81,
                    81
                );
            }
        }

        repaint();
    }
}
