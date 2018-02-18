package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;

public class EnemyGfx implements Movable{

    private Picture[] pictures;
    private int pictureNumber;
    private int x;
    private int y;


    public EnemyGfx(EnemyType enemyType, int y){
        this.x = enemyType.getStart();
        this.y = y;
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
        return pictures[0].getWidth();
    }

    @Override
    public int getOffsetY() {
        return pictures[0].getHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void delete() {
        for(Picture p: pictures){
            p.delete();
        }
    }


}
