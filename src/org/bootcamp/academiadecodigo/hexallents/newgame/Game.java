package org.bootcamp.academiadecodigo.hexallents.newgame;


import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.CharacterFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.EnemyFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.BulletGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.EnemyGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.GridGfx;

public class Game {

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
    private CharacterType tempType;
    private Character temp;
    private boolean characterStaged;

   

    public Game() {
        this.factory = new EnemyFactory();
        this.enemy = new Enemy[5];
        /*for (int i = 0; i < enemy.length; i++){
            enemy[i] = EnemyFactory.getNewEnemy();
        }*/
        this.character = new Character[3];
        this.characterFactory = new CharacterFactory();
        this.player = new Player();
        this.bullet = new Bullet[10000];
        this.characterStaged = false;


    }


    public void init() throws InterruptedException {
        grid = new GridGfx();
        start();
        //characterGfx.draw();
        player.addEventListener();


    }

    public void start() throws InterruptedException {
        int i = 0;
    //    drawCharacter();
        while (true) {
            Thread.sleep(300);
            moveEnemies();

            if (i < enemy.length) {
                enemy[i] = createEnemy();
                /*bullet[i] = createBullet();*/
                i++;
            }
            /*if(temp.isStaged()){
                temp.shoot();
            }*/
            if(characterStaged){

                moveBullets();
            }




        }
    }

/*
    private Bullet[] createBullet() {

        for (int j = 0; j < character.length; j++){
            if (character[j] == null) {
                return null;
            }
            for(int i = 0; i < bullet.length; i++){

                bullet[i] = character[j].shoot();
            }
        }

        return bullet;
    }
*/

    private Enemy createEnemy() {

        return EnemyFactory.getNewEnemy();
    }

 /*   private Character createCharacter() {
        return CharacterFactory.getNewCharacter();
    }*/

/*    private Character drawCharacter() {
        for (int i = 0; i < character.length; i++) {

                character[i] = CharacterFactory.getNewCharacter();
                if(!character[i].isDeleted() ) {
                    character[i].move();
                }
                return character[i];

        }
        return null;
    }*/

    private void moveEnemies() throws InterruptedException {

        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] == null) {
                continue;
            }
            if (!enemy[i].isDead() && enemy[i].getXSpeed() < grid.getHeight() &&
                    enemy[i].getYSpeed() < grid.getWidth()) {
                enemy[i].move();
            }

        }
    }

    private void deleteCharacter() {
        for (int i = 0; i < character.length; i++){
            character[i].delete();
        }

    }

    private void moveBullets(){


            for(int i = 0; i < bullet.length; i++){
                if(bullet[i] == null){
                    return;
                }
                if ( !bullet[i].isCrashed() && bullet[i].getXSpeed() < grid.getHeight() &&
                        bullet[i].getYSpeed() < grid.getWidth()) {
                    bullet[i].move();


            }

        }
    }


    private class Player implements MouseHandler {

        private Mouse m;
        private MouseEvent mouseReleased;
        private MouseEvent mouseClicked;
        private boolean selected;


        private boolean characterDeleted;




        public Player(){
            this.m = new Mouse(this);
            addEventListener();
            characterDeleted = false;
        }

        void addEventListener(){
            m.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();


            for (int i = 0; i < character.length; i++) {

                if ((x >= 100 && x < 900) && (y >= 100 && y < 600)) {
                    x = ((int) (x / 100)) * 100;
                    y = ((int) (y / 100)) * 100;
                    temp = CharacterFactory.getNewCharacter(x, y);
                    temp.move();
                    characterStaged = true;

                }
                continue;

            }
            for (int i = 0; i < bullet.length; i++) {
                if (bullet[i] == null) {

                    bullet[i] = temp.shoot();

                    return;
                }


            }
        }

        public void translateCharacter(MouseEvent event){

            int x = (int) event.getX();
            int y = (int) event.getY();
            temp = new Character(tempType, x, y);
            temp.move();


            }




        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    }
}


