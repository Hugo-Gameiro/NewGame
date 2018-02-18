package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.CharacterFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.EnemyFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.BulletGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

import java.lang.reflect.Field;

public class Game{

    private Grid grid;
    private EnemyFactory factory;
    private Enemy[] enemy;
    private EnemyGfx enemyGfx;
    private Character[] character;
    private CharacterGfx characterGfx;
    private CharacterFactory characterFactory;
    private Player player;
    private Bullet[] bullet;
    private BulletGfx bulletGfx;

    public Game(){
        this.factory = new EnemyFactory();
        this.enemy = new Enemy[13];
        /*for (int i = 0; i < enemy.length; i++){
            enemy[i] = EnemyFactory.getNewEnemy();
        }*/
        this.character = new Character[3];
        this.characterFactory = new CharacterFactory();
        this.player = new Player();
        this.bullet = new Bullet[3];

    }


    public void init() throws InterruptedException {
        grid = new GridGfx();
        start();
        //characterGfx.draw();
        player.addEventListener();


    }

    public void start() throws InterruptedException {
        int i = 0;
        while (true) {
            Thread.sleep(300);
            moveEnemies();
            drawCharacter();
            if(i < enemy.length ) {
                enemy[i] = createEnemy();
                bullet[i] = createBullet();
                i++;
            }
            moveEnemies();
            moveBullets();
        }
    }

    private Bullet createBullet() {

        return BulletGfx.getNewEnemy();
    }

    private Enemy createEnemy(){
        return EnemyFactory.getNewEnemy();
    }

    private Character createCharacter(){
        return CharacterFactory.getNewCharacter();
    }

    private void drawCharacter(){
        for (int i = 0; i < character.length; i++){
            character[i] = CharacterFactory.getNewCharacter();
            character[i].draw();
        }
    }

    private void moveEnemies() throws InterruptedException {

        for (int i = 0; i < enemy.length; i++){
            if(enemy[i] == null){
                continue;
            }
            if ( !enemy[i].isDead() && enemy[i].getXSpeed() < grid.getHeight() &&
                    enemy[i].getYSpeed() < grid.getWidth()) {
                enemy[i].move();
            }

        }
    }

    private void deleteCharacter(){


    }

    private void moveBullets(){

        for (int i = 0; i < bullet.length; i++){
            if(bullet[i] == null){
                continue;
            }
            if ( !bullet[i].isCrashed() && bullet[i].getXSpeed() < grid.getHeight() &&
                    bullet[i].getYSpeed() < grid.getWidth()) {
                bullet[i].move();
            }

        }
    }

}
