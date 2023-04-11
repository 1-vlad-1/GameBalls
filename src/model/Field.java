package model;

import model.navigation.CellPosition;

import java.util.ArrayList;

public class Field {

    // ------------------------------ Размеры ---------------------------

    public Field (){
        setSize(10, 10);
    }

    public final void setSize(int width, int height) {
        CellPosition.setHorizontalRange(1, width);
        CellPosition.setVerticalRange(1, height);
    }

    public int getWidth() {
        return CellPosition.horizontalRange().getLength();
    }

    public int getHeight() {
        return CellPosition.verticalRange().getLength();
    }

    //---------------------- Шарики -----------------------------------
    private ArrayList<Ball> _balls = new ArrayList<>();

    public ArrayList<Ball> getBalls(){
        return _balls;
    }

    public void addBall(CellPosition position, Ball ball){
        ball.setPosition(position);
        _balls.add(ball);
    }

    private void deleteBall(int x, int y) {
        for (int i = _balls.size() - 1; i > -1; i--) {
            double dx = _balls.get(i).getX() + (double)_balls.get(i).getWidth()/2 - x;
            double dy = _balls.get(i).getY()  + (double)_balls.get(i).getWidth()/2 - y;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d < (double) _balls.get(i).getWidth()/2) {
                _balls.remove(i);
                break;
            }
        }
    }
}
