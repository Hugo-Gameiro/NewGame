package org.bootcamp.academiadecodigo.hexallents.newgame;

public interface Movable {

    void move(int distanceX, int distanceY);

    int getWidth();

    int getHeight();

    void delete();
}
