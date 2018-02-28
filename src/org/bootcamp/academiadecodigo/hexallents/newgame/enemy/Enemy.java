package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

import org.bootcamp.academiadecodigo.hexallents.newgame.Collidable;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

public class Enemy implements Collidable {

    private EnemyType enemyType;
    private int x;
    private int y;
    private Movable enemyPicture;
    private Grid grid;

    public Enemy(EnemyType enemyType, Grid grid) {
        this.enemyType = enemyType;
        this.y = enemyPositionY();
        this.x = enemyType.getStart();
        this.enemyPicture = new EnemyGfx(enemyType, y);
        this.grid = grid;
    }

    public void move() {
        if (x < 70) {
            enemyPicture.delete();
            return;
        }
        enemyPicture.move(getXSpeed(), getYSpeed());
        x += getXSpeed();
        y += getYSpeed();
    }

    public int enemyPositionY() {
        return ((int) ((Math.random() * (600 - 100)) + 100) / 100) * 100;
    }

    @Override
    public boolean isOutOfBounds() {
        return getY() > grid.getHeight() || getX() > grid.getWidth();
    }

    public int getXSpeed() {
        return enemyType.getxSpeed();
    }

    public int getYSpeed() {
        return enemyType.getySpeed();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void die() {
        enemyPicture.delete();
    }
}
