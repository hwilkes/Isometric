package main.java.game.map;

import main.java.game.map.cells.IsoCell;

/**
 * Created by Henry on 02/02/2016.
 */
public class IsoMap {
    private IsoCell[][] cells;

    public IsoCell[][] getIsoCells(){
        return cells;
    }

    public IsoMap(int x, int y){
        if(x < 1 || y < 1){
            throw new IllegalArgumentException("Array sizes must be positive");
        }
        cells = new IsoCell[x][y];
    }

    public IsoCell getCell(int x, int y){
        if(x < 1 | y < 1 | x >= cells.length | y >= cells[0].length){
            throw new IllegalArgumentException();
        }

        return cells[x][y];
    }

    public void setCell(int x, int y, IsoCell c){
        if(x < 1 | y < 1 | x >= cells.length | y >= cells[0].length){
            throw new IllegalArgumentException();
        }

        cells[x][y] = c;
    }

}
