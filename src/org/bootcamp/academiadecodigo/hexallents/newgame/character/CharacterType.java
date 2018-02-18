package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

<<<<<<< HEAD
    CHARACTER_1(250, 300, 1, 1, "res/walk1.png"),
=======
    CHARACTER_1(0, 0, 1, 1, "res/an.png"),
>>>>>>> 585d5b55e0d65e854baaa78b113f7e01ee4d2f2b
    CHARACTER_2(50, 100,2, 2, ""),
    CHARACTER_3(150, 100,3, 3, "");

    private String characterPicture;
    private int damage;
    private int health;
    private int x;
    private int y;

    CharacterType(int x, int y, int damage, int health, String characterPicture){

        this.x = x;
        this.y = y;
        this.damage = damage;
        //this.health = health; tb está no character!
        this.characterPicture = characterPicture;

    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCharacterPictureOne() {
        return characterPicture;
    }
}
