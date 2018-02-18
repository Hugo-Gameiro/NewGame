package org.bootcamp.academiadecodigo.hexallents.newgame.bullet;

import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;

public enum BulletType {

    BULLET_1(2, 0, "", ""),
    BULLET_2(5, 0, "", ""),
    BULLET_3(8, 0, "", "");

    private String enemyPictureOne;
    private String enemyPictureTwo;
//    private String enemyPictureThree;
    private int xSpeed;
    private int ySpeed;
    private Character character;


    BulletType(int xSpeed, int ySpeed, String enemyPictureOne, String enemyPictureTwo){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.enemyPictureOne = enemyPictureOne;
        this.enemyPictureTwo = enemyPictureTwo;
//        this.enemyPictureThree = enemyPictureThree;
    }

    public String getEnemyPictureTwo() {
        return enemyPictureTwo;
    }

    public String getEnemyPictureOne() {
        return enemyPictureOne;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }
}
