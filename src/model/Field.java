package model;

import model.navigation.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import model.navigation.Cell;

public class Field implements Iterable<Cell>{

    // ------------------------------ Размеры ---------------------------

    private final int _widht;

    private final int _height;
    public int getWidth() {
        return _widht;
    }

    public int getHeight() {
        return _height;
    }


    // --------------------------- Ячейки ----------------------

    private final HashMap<CellPosition, Cell> _cells = new HashMap<>();

    public Cell cell(CellPosition pos) {
        return _cells.get( pos );
    }

    public Cell cell(int row, int col) {
        return cell(new CellPosition(row, col));
    }

    @Override
    public Iterator<Cell> iterator() {
        return new FieldIterator( this );
    }

    // -------------------------------- Порождение -------------------------

    public Field (int width, int height){
        if(width <= 0 && height <=0)
            throw new InvalidParameterException("Размеры должны быть положительными!");
        this._widht = width;
        this._height = height;

        buildField();
    }

    private void buildField(){
        // Создаем ячейки
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                CellPosition pos = new CellPosition(row, col);
                _cells.put(pos, new Cell(pos));
            }
        }

        // Связываем ячейки
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {

                Cell cell = cell(row, col);

                if (getHeight() > 1 && row < getHeight() - 1) {
                    cell.setNeighbor(Direction.south(), cell(row + 1, col));
                }
                if (row > 0) {
                    cell.setNeighbor(Direction.north(), cell(row - 1, col));
                }
                if (getWidth() > 1 && col < getWidth() - 1) {
                    cell.setNeighbor(Direction.east(), cell(row, col + 1));
                }
                if (col > 0) {
                    cell.setNeighbor(Direction.west(), cell(row, col - 1));
                }
            }
        }
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

    // --------------- Итератор по ячейкам ----------------

    private  class FieldIterator implements Iterator<Cell> {

        private Cell _cell = null;
        private final Field _field;

        public FieldIterator(Field field) {
            _field = field;
        }

        @Override
        public boolean hasNext() {

            return nextCell( _cell ) != null;
        }

        @Override
        public Cell next() {
            _cell = nextCell(_cell);
            return _cell;
        }

        private Cell nextCell(Cell cell) {
            Cell next_cell = null;

            if(cell == null) {
                next_cell = _field.cell(0, 0);
            } else {
                next_cell = cell.neighbor( Direction.east() );
                if( next_cell == null && cell.position().getRow() < _field.getHeight()-1 ) {
                    next_cell = _field.cell( cell.position().getRow() + 1 , 0 );
                }
            }

            return next_cell;
        }
    }
}
