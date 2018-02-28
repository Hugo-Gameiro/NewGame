package org.bootcamp.academiadecodigo.hexallents.newgame.character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Collidable;

public class Character implements Collidable {

    private int x;
    private int y;
    private Picture characterPicture;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        characterPicture = new Picture(x, y, CharacterType.CHARACTER_1.getCharacterPicturePath());
        characterPicture.draw();
    }

    @Override
    public boolean isOutOfBounds() {
        return (x >= 100 && x < 900) && (y >= 100 && y < 600);
    }

    @Override
    public void die() {
        characterPicture.delete();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

}
