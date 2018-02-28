package org.bootcamp.academiadecodigo.hexallents.newgame.factory;

import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.BulletType;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

public class BulletFactory {

    private BulletFactory() {
    }

    public static Bullet getNewBullet(double x, double y, Grid grid) {

        int random = (int) (Math.random() * BulletType.values().length);
        BulletType bulletType = BulletType.values()[random];

        return new Bullet((int) x, (int) y, bulletType, grid);
    }
}
