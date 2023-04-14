package view;

import model.Ball;
import model.Field;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class BallsRendering extends JFrame {

    private GameModel _model;

    // ------------------------------ Размеры ---------------------------------

    private static final int CELL_SIZE = 30;

    private static final int GAP = 2;

    private static final Color BACKGROUND_COLOR = new Color(255,255,255);

    private static final Color GRID_COLOR = Color.black;

    public BallsRendering(GameModel model) {

        _model = model;

        // Инициализация графики
        int width = 2*GAP + CELL_SIZE * _model.getField().getWidth();
        int height = 2*GAP + CELL_SIZE * _model.getField().getHeight();
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.RED);

//        _model.robot().addRobotActionListener(new GameFieldPanel.RepaintByAction());
//        addKeyListener(this);

    }

    /** Рисуем поле */

    public void paintComponent(Graphics g) {

        // Отрисовка фона
        int width = getWidth();
        int height = getHeight();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);   // восстнанваливаем цвет пера

        // Отрисовка сетки
        darwGrid(g);
    }

    private void darwGrid(Graphics g) {
        int width  = getWidth();
        int height = getHeight();

        g.setColor(GRID_COLOR);

        for(int i = 1; i <= _model.getField().getWidth()+1; i++)  // вертикальные линии
        {
            int x = GAP + CELL_SIZE*(i-1);
            g.drawLine(x, 0, x, height);
        }

        for(int i = 1; i <= _model.getField().getWidth()+1; i++)  // горизонтальные линии
        {
            int y = GAP + CELL_SIZE*(i-1);
            g.drawLine(0, y, width, y);
        }

    }

//    private class Canvas extends JPanel {
//        @Override
//        public void paint(Graphics g) {
//            super.paint(g);
//            // рисуем окружности
//            for (Ball ball : getBalls()) {
//                ball.paint(g);
//            }
//        }
//    }
}
