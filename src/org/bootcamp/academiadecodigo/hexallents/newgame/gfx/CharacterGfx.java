package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;

public class CharacterGfx implements Movable{

    private Picture picture;


    public CharacterGfx(CharacterType characterType, Character character){
        picture = new Picture(character.getX(), character.getY(), characterType.getCharacterPictureOne());
    }
    @Override
    public void move(int distanceX, int distanceY) {

        picture.draw();

    }

    public void draw(){
        picture.draw();
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
