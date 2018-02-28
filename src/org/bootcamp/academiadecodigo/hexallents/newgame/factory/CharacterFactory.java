package org.bootcamp.academiadecodigo.hexallents.newgame.factory;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;


public class CharacterFactory {


    public static Character getNewCharacter(int x, int y) {
        return new Character(x, y);
    }
}
