package model.navigation;

public class CellRange {

    // ------------------ Возможные значения ------------------
    private  int _min = 0;
    private  int _max = 0;

    public CellRange(int min, int max){
        if(min < 0)     min = 0;
        if(max < min)   max = min;

        _min = min;
        _max = max;
    }

    public int getMin(){
        return _min;
    }

    public int getMax(){
        return _max;
    }

    public int getLength(){
        return _max - _min + 1;
    }

    public static boolean isValidRange(int min, int max) {
        return min > 0 && max >= min;
    }
}

