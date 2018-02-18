package org.bootcamp.academiadecodigo.hexallents.newgame.bullet;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;

public enum BulletType {

    BULLET_1(2, 0, "res/bulletCalmNun.png", "res/bulletCalmNun.png"),
    BULLET_2(5, 0, "res/bulletCalmNun.png", "res/bulletCalmNun.png"),
    BULLET_3(8, 0, "res/bulletCalmNun.png", "res/bulletCalmNun.png");

    private String bulletPictureOne;
    private String bulletPictureTwo;
//    private String enemyPictureThree;
    private int xSpeed;
    private int ySpeed;
    private Character character;


    BulletType(int xSpeed, int ySpeed, String bulletPictureOne, String bulletPictureTwo){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.bulletPictureOne = bulletPictureOne;
        this.bulletPictureTwo = bulletPictureTwo;
//        this.bulletPictureThree = bulletPictureThree;
    }

    public String getBulletPictureTwo() {
        return bulletPictureTwo;
    }

    public String getBulletPictureOne() {
        return bulletPictureOne;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }
}
