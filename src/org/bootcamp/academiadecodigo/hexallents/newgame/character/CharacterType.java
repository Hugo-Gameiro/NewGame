package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

    CHARACTER_1(1, 1, "res/walk1.png"),
    CHARACTER_2(2, 2, "res/walk1.png"),
    CHARACTER_3(3, 3, "res/walk1.png");

    private String characterPicture;
    private int damage;
    private int health;

    CharacterType(int damage, int health, String characterPicture){

        this.damage = damage;
        this.characterPicture = characterPicture;

    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public String getCharacterPictureOne() {
        return characterPicture;
    }
}
