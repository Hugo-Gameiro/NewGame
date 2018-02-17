package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

public enum  EnemyType {

    ENEMY_1(1, 1, 0,0,""),
    ENEMY_2(2, 2,0,0,""),
    ENEMY_3(3, 3,0,0,"");

    private int damage;
    private int health;
    private String enemyPicture;
    private int x;
    private int y;

    EnemyType(int damage, int health, int x, int y, String enemyPicture){
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.enemyPicture = enemyPicture;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
