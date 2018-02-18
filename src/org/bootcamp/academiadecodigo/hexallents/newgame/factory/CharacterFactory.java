package org.bootcamp.academiadecodigo.hexallents.newgame.factory;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;


public class CharacterFactory {


    public static Character getNewCharacter(int x, int y) {

        int random = (int) (Math.random() * CharacterType.values().length);
        CharacterType characterType = CharacterType.values()[random];

        switch (characterType) {
            case CHARACTER_1:
                return new Character(characterType, x, y);

            case CHARACTER_2:
                return new Character(characterType, x, y);

            case CHARACTER_3:
                return new Character(characterType, x, y);
        }

        return null;
    }
}
