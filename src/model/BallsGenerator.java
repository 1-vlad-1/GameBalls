package model;

import model.navigation.Cell;
import model.navigation.CellPosition;

import java.util.ArrayList;

public class BallsGenerator {

    private Field _field;

    private ArrayList<Ball> _balls;

    public void placeNewRowBalls(){
        createRowBalls();
        placeBalls();
        this._balls.clear();
    }

    private void createRowBalls(){
        for (int i = 0; i < _field.getWidth();i++){
            int colorNumber = (int) (Math.random() * 2);
            Ball newBall;
            if (colorNumber == 0){
                newBall = new Ball(Ball.COLORS.RED);
            } else if (colorNumber == 1) {
                newBall = new Ball(Ball.COLORS.BLUE);
            }else {
                newBall = new Ball(Ball.COLORS.GREEN);
            }
            _balls.add(newBall);
            _field.getBalls().add(newBall);
        }
    }

    private void placeBalls(){
        _field.getBalls().forEach((ball -> ball.setPosition(ball.shiftUpPos())));
        _field.getBalls().forEach(ball -> ball.setCell(_field.cell(ball.getPosition())));

        for (int i = 0; i < _balls.size();i++){
            _balls.get(i).setPosition(new CellPosition(0,i));
            _balls.get(i).setCell(_field.cell(0,i));
        }
    }

    public void fillTheField(){
        for (int i = 0; i < _field.getHeight()/2; i++){
            placeNewRowBalls();
        }
    }
}
