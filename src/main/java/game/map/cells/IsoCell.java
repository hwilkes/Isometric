package main.java.game.map.cells;

import main.java.game.map.cells.CellType;

/**
 * Created by Henry on 02/02/2016.
 */
public abstract class IsoCell {
    private CellType type;

    public IsoCell(CellType type){
        this.type = type;
    }

}
