package model;

import model.navigation.Cell;
import model.navigation.CellPosition;
import model.navigation.Direction;


import javax.swing.*;
import java.security.InvalidParameterException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ball {

    private boolean _exploded = false;

    private void explode(){
        this._exploded = true;
    }

    private boolean getExplode(){
        return this._exploded;
    }

    private Cell _cell;

    public Cell get_cell() {
        return _cell;
    }

    public void setCell(Cell cell){
        this._cell = cell;
    }

    private CellPosition _pos;

    private final Color _color;

    public Color getColor(){
        return _color;
    }
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

    public boolean blowUp(Cell cellNeighbour){
            this.explode();

            for (Cell neighbour : this.get_cell().parser(this.get_cell().neighbors())) {
                if (!neighbour.getBall().getExplode()){
                    if(neighbour.getBall().getColor() == this.getColor()){
                        neighbour.getBall().explode();
                        blowUp(neighbour);
                    }
                    else {
                        return false;
                    }
                }
            }
        return true;
    }


    public CellPosition shiftUp(){
        return new CellPosition(_pos.getRow() + 1,_pos.getColumn() );
    }
}
