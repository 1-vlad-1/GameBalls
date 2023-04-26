package model.navigation;

import model.Ball;

import java.util.*;

public class Cell {
    // ----------------------- Шарик --------------------------
    private Ball _ball;

    public void setBall(Ball _ball) {
        this._ball = _ball;
    }

    public Ball getBall() {
        return _ball;
    }

    // ----------------------- Позиция --------------------------

    private final CellPosition _pos;

    public CellPosition position() {
        return _pos;
    }


    // ----------------------- Порождение --------------------------

    public Cell(CellPosition position) {
        _pos = position;
    }

    // ---------------------- Соседи -----------------------
    private final Map<Direction, Cell> _neighbors = new HashMap<>();

    public Cell neighbor(Direction direct) {

        if(_neighbors.containsKey(direct)) {
            return _neighbors.get(direct);
        }

        return null;
    }

    public Map<Direction, Cell> neighbors() {
        return Collections.unmodifiableMap(_neighbors);
    }

    public void setNeighbor(Direction direct, Cell neighbor) {
        if(neighbor != this && !isNeighbor(neighbor)) {
            _neighbors.put(direct, neighbor);
            neighbor.setNeighbor(direct.opposite(), this);
        }
    }

    public boolean isNeighbor(Cell other) {
        return _neighbors.containsValue(other);
    }

    public List<Cell> parser(Map<Direction, Cell> map){
        List<Cell> neighbours = new ArrayList<>(this.neighbors().values());
        return neighbours;
    }
}
