package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.BulletType;

public class BulletGfx implements Movable {

    private Picture picture;

    public BulletGfx(int x, int y, BulletType bulletType) {
        picture = new Picture(x + 100, y, bulletType.getBulletPicturePath());
        picture.draw();
    }

    @Override
    public void move(int distanceX, int distanceY) {
        picture.translate(distanceX, distanceY);
        System.out.println(getX());
        System.out.println(getY());
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    @Override
    public void delete() {
        picture.delete();
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }
}
