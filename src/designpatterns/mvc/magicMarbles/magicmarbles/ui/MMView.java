package designpatterns.mvc.magicMarbles.magicmarbles.ui;

import designpatterns.mvc.magicMarbles.magicmarbles.model.MMException;
import designpatterns.mvc.magicMarbles.magicmarbles.model.MMFieldState;
import designpatterns.mvc.magicMarbles.magicmarbles.model.MMGame;
import designpatterns.mvc.magicMarbles.magicmarbles.model.MMGameImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.prefs.Preferences;

public class MMView {
    private MMGame game;
    private JFrame frame;
    private JPanel drawPanel;
    private Image image;

    private JLabel points;
    private JLabel high_score;

    private final int fieldSize = 40;


    public static void main(String[] args) {
        new MMView(new MMGameImpl(10, 10));
    }

    MMView(MMGame game) {
        this.game = game;
        this.game.addValueChangeListener(changeListener);
        buildFrame();
        drawField();
    }

    private final MMChangeListener changeListener = new MMChangeListener() {
        @Override
        public void fieldChanged(MMChangeEvent evt) {
            points.setText("Points: " + game.getGamePoints());
            drawField();
            if (evt.isGameOver()) {
                Preferences preferences = Preferences.userNodeForPackage(MMView.class);
                if (game.getGamePoints() > Integer.parseInt(preferences.get("high_score_" + game.getWidth() + "_" + game.getHeight(), "0"))) {
                    preferences.put("high_score_" + game.getWidth() + "_" + game.getHeight(), String.valueOf(game.getGamePoints()));
                    high_score.setText("High Score: " + preferences.get("high_score_" + game.getWidth() + "_" + game.getHeight(), "0"));
                }

                JOptionPane.showMessageDialog(frame, "You achieved " + game.getGamePoints() + " Points", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    };

    private void drawField() {
        for (int i = 0; i < this.game.getWidth(); i++) {
            for (int j = 0; j < this.game.getHeight(); j++) {
                drawField(i, j, this.game.getFieldState(j, i));
            }
        }

        Preferences preferences = Preferences.userNodeForPackage(MMView.class);
        high_score.setText("High Score: " + preferences.get("high_score_" + game.getWidth() + "_" + game.getHeight(), "0"));
    }

    private void drawField(int x, int y, MMFieldState state) {
        Graphics g = image.getGraphics();
        switch (state) {
            case RED -> g.setColor(Color.RED);
            case GREEN -> g.setColor(Color.GREEN);
            case BLUE -> g.setColor(Color.BLUE);
            default -> g.setColor(Color.WHITE);
        }
        g.fillOval(x * fieldSize, y * fieldSize, fieldSize - 2, fieldSize - 2);
        drawPanel.repaint();
    }

    public void buildFrame() {
        frame = new JFrame("Magic Marbles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem newGame = new JMenuItem("New");
        newGame.addActionListener(e -> {
            String width = JOptionPane.showInputDialog(frame, "Width", game.getWidth());
            String height = JOptionPane.showInputDialog(frame, "Height", game.getHeight());
            game = new MMGameImpl(Integer.parseInt(width), Integer.parseInt(height));
            game.addValueChangeListener(changeListener);

            drawPanel.removeAll();

            image = new BufferedImage(Math.max(game.getWidth() * fieldSize, 220), game.getHeight() * fieldSize, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().fillRect(0, 0, Math.max(game.getWidth() * fieldSize, 220), game.getHeight() * fieldSize);

            JLabel label = new JLabel(new ImageIcon(image));

            drawPanel.add(label);

            frame.pack();
            drawField();
        });
        menu.add(newGame);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        menu.add(exit);


        drawPanel = new JPanel();
        drawPanel.addMouseListener(mouseListener);
        frame.add(drawPanel);

        image = new BufferedImage(game.getWidth() * fieldSize, game.getHeight() * fieldSize, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().fillRect(0, 0, game.getWidth() * fieldSize, game.getHeight() * fieldSize);

        JLabel label = new JLabel(new ImageIcon(image));
        drawPanel.add(label);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 2));
        frame.add(infoPanel, BorderLayout.SOUTH);

        points = new JLabel("Points: 0");
        infoPanel.add(points);

        Preferences preferences = Preferences.userNodeForPackage(MMView.class);
        high_score = new JLabel("High Score: " + preferences.get("high_score_" + game.getWidth() + "_" + game.getHeight(), "0"));
        infoPanel.add(high_score);

        frame.pack();
    }

    private final MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            int x = (mouseEvent.getX() - 4) / fieldSize;
            int y = (mouseEvent.getY() - 4) / fieldSize;
            try {
                game.select(y, x);
            } catch (MMException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    };
}
