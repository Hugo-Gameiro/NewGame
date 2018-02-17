package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

public class Game {

    private Grid grid;


    public void init(){
        grid = new GridGfx();
    }
}
