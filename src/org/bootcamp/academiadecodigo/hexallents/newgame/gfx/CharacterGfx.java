package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;

public class CharacterGfx implements Movable{

    private Picture picture;


    public CharacterGfx(CharacterType characterType){
        picture = new Picture(characterType.getX(), characterType.getY(), characterType.getCharacterPictureOne());
    }
    @Override
    public void move(int distanceX, int distanceY) {


    }

    @Override
    public int getOffsetX() {
        return picture.getWidth();
    }

    @Override
    public int getOffsetY() {
        return picture.getHeight();
    }

    @Override
    public void delete() {
        picture.delete();
    }



}
