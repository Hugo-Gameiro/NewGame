package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;

public class Enemy {

    private int health;
    private boolean dead;
    private EnemyType enemyType;
    private EnemyGfx enemyGfx;
    private int x;
    private int y;


    public Enemy(EnemyType enemyType){
        this.enemyType = enemyType;
        health = enemyType.getHealth();

    }



}
