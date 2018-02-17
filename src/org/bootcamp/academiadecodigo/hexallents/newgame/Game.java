package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.CharacterFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.EnemyFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

public class Game{

    private Grid grid;
    private EnemyFactory factory;
    private Enemy enemy;
    private EnemyGfx enemyGfx;
    private Character character;
    private CharacterGfx characterGfx;
    private CharacterFactory characterFactory;

    public Game(){
        this.factory = new EnemyFactory();
        this.enemyGfx = new EnemyGfx(EnemyType.ENEMY_1);
        this.characterFactory = new CharacterFactory();

        this.characterGfx = new CharacterGfx(CharacterType.CHARACTER_1);


    }


    public void init(){
        grid = new GridGfx();
        enemy = factory.getNewEnemy();
        enemyGfx.draw();
        characterGfx.draw();

    }



}
