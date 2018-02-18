package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;

public class Enemy {

    private int health;
    private boolean dead;
    private EnemyType enemyType;
    private EnemyGfx enemyGfx;
    private int x;
    private int y;
    private int start;
    private Movable enemyPicture;
    private static int enemyPosition;

    public Enemy(EnemyType enemyType){
        this.enemyType = enemyType;
        this.start = enemyType.getStart();
        this.y = enemyPositionY();
        health = enemyType.getHealth();
<<<<<<< HEAD
        this.enemyPicture = new EnemyGfx(enemyType, y);
        this.dead = false;

    }

    public void move() {
        enemyPicture.move(getXSpeed(), getYSpeed());
        x += getXSpeed();
        y += getYSpeed();
    }

    public int enemyPositionY(){
       if (enemyPosition == 0){
            enemyPosition++;
            return 70;
        }
        if (enemyPosition == 1) {
            enemyPosition++;
            return 170;
        }
        if (enemyPosition == 2){
            enemyPosition++;
            return 270;
        }
        if (enemyPosition == 3){
            enemyPosition++;
            return 370;
        }
        enemyPosition = 0;
        return 470;
=======
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    }

    public int getXSpeed(){
        return enemyType.getxSpeed();
    }

    public int getYSpeed(){
        return enemyType.getySpeed();
    }

    public int getXLimite(){
        return x + enemyPicture.getOffsetX();
    }

    public int getYLimite(){
        return y + enemyPicture.getOffsetY();
    }




    public boolean isDead() {
        return dead;
    }
}
