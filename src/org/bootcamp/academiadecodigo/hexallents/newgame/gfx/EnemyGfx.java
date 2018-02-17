package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;

public class EnemyGfx implements Movable{

    private Picture[] pictures;

    public EnemyGfx(EnemyType enemyType){
        pictures = new Picture[3];

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
        return 0;
    }

    @Override
    public int getOffsetY() {
        return 0;
    }

    @Override
    public void delete() {

    }
}
