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

    }

    private void identifyGameOver(){

    }
}
