package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;

public class EnemyGfx implements Movable{

    private Picture[] pictures;
    private int y;

    public EnemyGfx(EnemyType enemyType){
        pictures = new Picture[3];
        this.y = getOffsetY();

        pictures[0] = new Picture(enemyType.getX(), enemyType.getY(), enemyType.getEnemyPictureOne());

        pictures[1] = new Picture(enemyType.getX(), enemyType.getY(), enemyType.getEnemyPictureOne());
        pictures[2] = new Picture(enemyType.getX(), enemyType.getY(), enemyType.getEnemyPictureOne());

    }

    public void draw(){
        pictures[0].draw();

    }


    @Override
    public void move(int distanceX) {

    }

    @Override
    public int getOffsetX() {
        return 900;
    }

    @Override
    public int getOffsetY() {
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
    }

    @Override
    public void delete() {

    }
}
