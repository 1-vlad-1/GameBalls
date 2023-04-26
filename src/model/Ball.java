package model;

import model.navigation.Cell;
import model.navigation.CellPosition;


import javax.swing.*;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Ball {

    private Cell _cell;

    public void setCell(Cell cell){
        _cell = cell;
    }
    private CellPosition _pos;

    private final Color _color;
    public enum COLORS {RED, BLUE, GREEN}

    Ball(COLORS color) {
        if (color == COLORS.RED){
            _color = Color.red;
        } else if (color == COLORS.BLUE) {
            _color = Color.blue;
        } else if (color == COLORS.GREEN){
            _color = Color.green;
        } else {
            throw new InvalidParameterException("Неверный цвет шарика");
        }
    }

    void setPosition(CellPosition position){
        _pos = position;
    }

    public CellPosition getPosition(){
        return _pos;
    }

    public boolean blowUp(){
        ArrayList<Ball> explodedBalls = new ArrayList<Ball>();
        //!!!
        //_cell.neighbors().forEach();
        return false;
    }


    public CellPosition shiftUpPos(){
        ///сигнал конца игры
        return new CellPosition(_pos.getRow() + 1,_pos.getColumn() );
    }
}
