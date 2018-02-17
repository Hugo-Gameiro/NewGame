package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

    CHARACTER_1(1, 1, ""),
    CHARACTER_2(2, 2, ""),
    CHARACTER_3(3, 3, "");

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
}
