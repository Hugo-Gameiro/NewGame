package org.bootcamp.academiadecodigo.hexallents.newgame.bullet;

import org.bootcamp.academiadecodigo.hexallents.newgame.Collidable;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.BulletGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

public class Bullet implements Collidable {

    private BulletType bulletType;
    private BulletGfx bulletPicture;
    private Grid grid;


    public Bullet(int x, int y, BulletType bulletType, Grid grid) {
        this.bulletType = bulletType;
        this.bulletPicture = new BulletGfx(x + 1, y + 1, bulletType);
        this.grid = grid;
    }

    public void move() {
        if (getX() > 820) {
            bulletPicture.delete();
            return;
        }
        bulletPicture.move(getXSpeed(), getYSpeed());
    }

    @Override
    public boolean isOutOfBounds() {
        return getX() > grid.getWidth() || getY() > grid.getHeight();
    }

    @Override
    public double getX() {
        return bulletPicture.getX();
    }

    @Override
    public double getY() {
        return bulletPicture.getY();
    }

    public int getXSpeed() {
        return bulletType.getxSpeed();
    }

    public int getYSpeed() {
        return bulletType.getySpeed();
    }

    @Override
    public void die() {
        bulletPicture.delete();
    }
}