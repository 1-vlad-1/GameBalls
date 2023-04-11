package model;

import model.navigation.CellPosition;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.awt.Color;

public class Ball extends JFrame {

    private CellPosition _pos;

    private Color _color;
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

}
