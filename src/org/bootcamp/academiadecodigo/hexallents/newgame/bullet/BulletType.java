package org.bootcamp.academiadecodigo.hexallents.newgame.bullet;

public enum BulletType {

    BULLET_1(10, 0, "res/bulletCalmNun.png"),
    BULLET_2(20, 0, "res/bulletCalmNun.png"),
    BULLET_3(30, 0, "res/bulletCalmNun.png");

    private String bulletPictureOne;
    private int xSpeed;
    private int ySpeed;


    BulletType(int xSpeed, int ySpeed, String bulletPictureOne) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.bulletPictureOne = bulletPictureOne;
    }

    public String getBulletPicturePath() {
        return bulletPictureOne;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }
}
