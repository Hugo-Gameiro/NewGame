package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

public enum  EnemyType {

    ENEMY_1(880, -5, 0,"res/walk1.png", "res/walk2.png","res/walk3.png"),
    ENEMY_2(880, -10, 0,"res/GreenOne.png", "res/Green2.png","res/Green3.png"),
    ENEMY_3(880, -15, 0,"res/RedOne.png", "res/Red2.png","res/Red3.png");

    private int damage;
    private int health;
    private String enemyPictureOne;
    private String enemyPictureTwo;
    private String enemyPictureThree;
    private int start;
    private int xSpeed;
    private int ySpeed;

    EnemyType(int start, int xSpeed, int ySpeed, String enemyPictureOne, String enemyPictureTwo, String enemyPictureThree){
        this.damage = damage;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.start = start;
        this.enemyPictureOne = enemyPictureOne;
        this.enemyPictureTwo = enemyPictureTwo;
        this.enemyPictureThree = enemyPictureThree;
    }




    public int getStart() {
        return start;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public String getEnemyPictureOne() {
        return enemyPictureOne;
    }

    public String getEnemyPictureTwo() {
        return enemyPictureTwo;
    }

    public String getEnemyPictureThree() {
        return enemyPictureThree;
    }
}
