package org.bootcamp.academiadecodigo.hexallents.newgame.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridGfx implements Grid {

    private static int gridWidth;
    private static int gridHeight;
    private Picture canvas;

    public GridGfx(){
        canvas = new Picture(0,0,"res/tiles.png");
        canvas.draw();
        gridWidth = canvas.getWidth();
        gridHeight = canvas.getHeight();
    }

    @Override
    public void init() {
        canvas.draw();

    }

    @Override
    public int getWidth() {
        return gridWidth;
    }

    public static int getGridWidth(){
        return gridWidth;
    }
    @Override
    public int getHeight() {
        return gridHeight;
    }

}
