package org.bootcamp.academiadecodigo.hexallents.newgame.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private Picture canvas;

    public Grid() {
        canvas = new Picture(0, 0, "res/background.png");
        canvas.draw();
    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public int getHeight() {
        return canvas.getHeight();
    }
}
