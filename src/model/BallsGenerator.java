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
        }
    }

    private void placeBalls(){
        for (int i = 0; i < _field.getWidth(); i++){
            _field.getBalls().forEach((ball -> ball.setPosition(ball.shiftUp())));
        }
        for (int i = 0; i < _balls.size();i++){
            _balls.get(i).setPosition(new CellPosition(1,i));
        }
    }

    public void fillTheField(){
        for (int i = 0; i < _field.getHeight()/2; i++){
            placeNewRowBalls();
        }
    }
}
