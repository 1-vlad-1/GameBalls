import model.GameModel;
import view.BallsRendering;


import javax.swing.*;
import java.awt.*;

public class BallsGame extends JFrame{
    private GameModel _model;

    final int WINDOW_WIDTH = 650;

    final int WINDOW_HEIGHT = 650;

    private BallsRendering _gamePanel;

    //===================================================================== main
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BallsGame();
            }
        });
    }

    //============================================================== constructor
    public BallsGame() {

        _model = new GameModel();
        _model.start();
        _gamePanel = new BallsRendering(_model);


        setTitle("Шарики");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        _gamePanel.setFocusable(true);
        _gamePanel.setVisible(true);
    }
}