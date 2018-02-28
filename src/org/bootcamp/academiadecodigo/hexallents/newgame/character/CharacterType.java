package org.bootcamp.academiadecodigo.hexallents.newgame.character;

public enum CharacterType {

    CHARACTER_1("res/blackJesus.png");

    private String characterPicture;

    CharacterType(String characterPicture) {
        this.characterPicture = characterPicture;
    }

    public String getCharacterPicturePath() {
        return characterPicture;
    }
    }
