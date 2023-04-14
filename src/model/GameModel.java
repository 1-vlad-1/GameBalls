package model;

import java.util.Random;
import model.navigation.CellPosition;

public class GameModel {

    Field _field = new Field(5,5);

    public Field getField(){
        return _field;
    }

    public void start(){
        generateField();

        identifyGameOver();
    }

    private void generateField(){
        Random _numberColor = new Random();

        for (int i = 0; i < (double) _field.getHeight()/2; i++){
            for (int j = 0; j < (double) _field.getWidth();j++){
                int numberColor = _numberColor.nextInt(3);
                if (numberColor == 1){
                    _field.addBall(new CellPosition(i,j),new Ball(Ball.COLORS.RED));
                } else if (numberColor == 2) {
                    _field.addBall(new CellPosition(i,j),new Ball(Ball.COLORS.BLUE));
                } else {
                    _field.addBall(new CellPosition(i,j),new Ball(Ball.COLORS.GREEN));
                }
            }
        }
    }

    private void identifyGameOver(){

    }
}
