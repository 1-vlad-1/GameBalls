package model;

import model.navigation.*;

import java.util.ArrayList;

public class Field {

    // ------------------------------ Размеры ---------------------------

    private int _widht;

    private int _height;
    public Field (int width, int height){
        setSize(width, height);
        this._widht = width;
        this._height = height;
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
}
