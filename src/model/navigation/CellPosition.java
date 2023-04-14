package model.navigation;

public class CellPosition {

    private boolean _empty = true;

    public boolean isEmpty(){
        return this._empty;
    }

    // ------------------ Позиция  ---------------------

    private int _row;
    private int _column;

    public CellPosition(int row, int col)
    {
        _row = row;
        _column = col;
    }

    public int getRow(){

        return _row;
    }

    public int getColumn(){

        return _column;
    }
}
