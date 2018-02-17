package org.bootcamp.academiadecodigo.hexallents.newgame.enemy;

public enum  EnemyType {

    ENEMY_1(1, 1, 100,100,"res/an.png", "res/an.png","res/an.png"),
    ENEMY_2(2, 2,0,0,"", "", ""),
    ENEMY_3(3, 3,0,0,"", "", "");

    private int damage;
    private int health;
    private String enemyPictureOne;
    private String enemyPictureTwo;
    private String enemyPictureThree;
    private int x;
    private int y;

    EnemyType(int damage, int health, int x, int y, String enemyPictureOne, String enemyPictureTwo, String enemyPictureThree){
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.enemyPictureOne = enemyPictureOne;
        this.enemyPictureTwo = enemyPictureTwo;
        this.enemyPictureThree = enemyPictureThree;
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

    public String getEnemyPictureOne() {
        return enemyPictureOne;
    }

    public String getEnemyPictureTwo() {
        return enemyPictureTwo;
    }

    public String getEnemyPictureThree() {
        return enemyPictureThree;
    }
}






