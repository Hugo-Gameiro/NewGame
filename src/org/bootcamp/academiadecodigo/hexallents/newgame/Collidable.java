package org.bootcamp.academiadecodigo.hexallents.newgame;

public interface Collidable {

    double getX();

    double getY();

    boolean isOutOfBounds();

    void die();
}
