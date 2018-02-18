package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

    CHARACTER_1(100, 0, 1, 1, "res/walk1.png"),
    CHARACTER_2(50, 100,2, 2, ""),
    CHARACTER_3(50, 100,3, 3, "");

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
