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
    private int enemyPosition;

    public Enemy(EnemyType enemyType){
        this.enemyType = enemyType;
        this.start = enemyType.getStart();
        this.y = enemyPositionY();
        this.x = enemyType.getStart();
        health = enemyType.getHealth();
        this.enemyPicture = new EnemyGfx(enemyType, y);
        this.dead = false;

    }

    public void move() {
        if( x < 100){
            enemyPicture.delete();
            return;
        }
            enemyPicture.move(getXSpeed(), getYSpeed());
            x += getXSpeed();
            y += getYSpeed();
    }

    public int enemyPositionY(){

        enemyPosition = (int) ((Math.random() * (600 - 100)) + 100) / 100;


        switch (enemyPosition){
            case 1:
                return 100;

            case 2:
                return 200;

            case 3:
                return 300;

            case 4:
                return 400;

            case 5:
                return 500;
        }
        return -1;

        }

/*

        if (enemyPosition == 0){
            enemyPosition++;
            return 100;
        }
        if (enemyPosition == 1) {
            enemyPosition++;
            return 200;
        }
        if (enemyPosition == 2){
            enemyPosition++;
            return 300;
        }
        if (enemyPosition == 3){
            enemyPosition++;
            return 400;
        }
        enemyPosition = 0;
        return 500;
    }
*/


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
