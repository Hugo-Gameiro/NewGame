package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

    CHARACTER_1(100, 0, 1, 1, "res/walk1.png"),
    CHARACTER_2(200, 0,2, 2, "res/walk1.png"),
    CHARACTER_3(300, 0,3, 3, "res/walk1.png");

    private String characterPicture;
    private int damage;
    private int health;
    private int x;
    private int y;

    CharacterType(int x, int y, int damage, int health, String characterPicture){

        this.x = x;
        this.y = y;
        this.damage = damage;
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
