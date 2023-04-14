package model.navigation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cell {
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
}
