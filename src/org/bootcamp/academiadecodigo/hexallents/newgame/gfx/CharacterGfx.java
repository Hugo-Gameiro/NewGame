package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;

public class CharacterGfx implements Movable {

    private Picture picture;

<<<<<<< HEAD

    public CharacterGfx(CharacterType characterType){
=======
    public CharacterGfx(CharacterType characterType) {
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
        picture = new Picture(characterType.getX(), characterType.getY(), characterType.getCharacterPictureOne());
    }

    @Override
    public void move(int distanceX, int distanceY) {


    }

    @Override
    public int getOffsetX() {
<<<<<<< HEAD
        return picture.getWidth();
=======

        int x = (int) ((Math.random() * 900) / 100);

        if (x < 900) {

            switch (x) {
                case 0:
                    return 0;

                case 1:
                    return 100;

                case 2:
                    return 200;

                case 3:
                    return 300;

                case 4:
                    return 400;

                case 5:
                    return 500;

                case 6:
                    return 600;

                case 7:
                    return 700;

                case 8:
                    return 800;

                case 9:
                    return 900;
            }
        }
        return 0;
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    }

    @Override
    public int getOffsetY() {
<<<<<<< HEAD
        return picture.getHeight();
=======

        int y = 0; // esta variavel nao faz aqui nada era so para poder realizar o resto do codigo

        //temos de por aqui uma exceção
        if (y < 100) {
            //não fazer nada, apanhar uma excepção?
        }

        y = (int) ((Math.random() * 900) / 100);

        if (y < 900) {

            switch (y) {
                case 0:
                    return 0;

                case 1:
                    return 100;

                case 2:
                    return 200;

                case 3:
                    return 300;

                case 4:
                    return 400;

                case 5:
                    return 500;
            }
        }
        return 0;

>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    }

    @Override
    public void delete() {
        picture.delete();
    }



}

