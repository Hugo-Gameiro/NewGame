package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;

public class EnemyGfx implements Movable{

    private Picture[] pictures;
<<<<<<< HEAD
    private int pictureNumber;

=======
    private int y;

    public EnemyGfx(EnemyType enemyType){
        pictures = new Picture[3];
        this.y = getOffsetY();
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b

    public EnemyGfx(EnemyType enemyType, int y){
        pictureNumber = 0;
        pictures = new Picture[3];

        pictures[0] = new Picture(enemyType.getStart(), y, enemyType.getEnemyPictureOne());
        pictures[1] = new Picture(enemyType.getStart(),y, enemyType.getEnemyPictureTwo());
        pictures[2] = new Picture(enemyType.getStart(), y, enemyType.getEnemyPictureThree());

    }

/*    public void draw(){
        pictures[0].draw();

    }*/


    @Override
    public void move(int distanceX, int distanceY) {
        pictures[pictureNumber].delete();
        pictureNumber = pictureNumber == pictures.length - 1 ? 0 : ++pictureNumber;
        pictures[pictureNumber].translate(distanceX*pictures.length, distanceY);
        pictures[pictureNumber].draw();
    }

    @Override
    public int getOffsetX() {
<<<<<<< HEAD
        return pictures[0].getWidth();
=======
        return 900;
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    }

    @Override
    public int getOffsetY() {
<<<<<<< HEAD
        return pictures[0].getHeight();
=======
        y = (int) ((Math.random() * (600 - 100)) + 100) / 100;

        switch (y){
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
        return -1;
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    }

    @Override
    public void delete() {
        for(Picture p: pictures){
            p.delete();
        }
    }


}
