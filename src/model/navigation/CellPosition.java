package model.navigation;

public class CellPosition {

    // -- Диапазоны возможных значений по горизонтали и вертикали для всех позиций --

    private static CellRange _horizontalRange = new CellRange(0, 0);
    private static CellRange _verticalRange = new CellRange(0, 0);

    private boolean _empty = true;

    public boolean isEmpty(){
        return this._empty;
    }

    public static void setHorizontalRange(int min, int max){
        if(CellRange.isValidRange(min, max))
        { _horizontalRange = new CellRange(min, max); }
    }

    public static CellRange horizontalRange(){
        return _horizontalRange;
    }

    public static void setVerticalRange(int min, int max){
        if(CellRange.isValidRange(min, max))
        { _verticalRange = new CellRange(min, max); }
    }

    public static CellRange verticalRange(){
        return _verticalRange;
    }

    // ------------------ Позиция внутри диапазона ---------------------

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
