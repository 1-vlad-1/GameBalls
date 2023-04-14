package model;

import model.navigation.CellPosition;

import java.util.ArrayList;

public class BallsGenerator {

    private Field _field;

    private ArrayList<Ball> _balls;

    public void placeNewRowBalls(){
        createRowBalls();
        placeBalls();
        _balls.clear();
    }

    private void createRowBalls(){
        for (int i = 0; i < _field.getWidth();i++){
            Ball newBall = new Ball(Ball.COLORS.RED);
            _balls.add(newBall);
        }
    }

    private void placeBalls(){
        for (int i = 0; i < _balls.size();i++){
            _balls.get(i).setPosition(new CellPosition(1,i));
        }
    }
}
