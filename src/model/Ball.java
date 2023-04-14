package model;

import model.navigation.CellPosition;


import javax.swing.*;
import java.security.InvalidParameterException;
import java.awt.Color;

public class Ball {

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

    public void setPosition(CellPosition position){
        _pos = position;
    }

    public CellPosition getPosition(){
        return _pos;
    }

    public boolean blowUp(){
        int counter = numberOfOneColorNeighbours();
        if (counter >=3){

        }
        return false;
    }

    private int numberOfOneColorNeighbours(){
        return 1;
    }
}
