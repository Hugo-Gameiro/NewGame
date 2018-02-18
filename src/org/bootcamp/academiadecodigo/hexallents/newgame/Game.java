package org.bootcamp.academiadecodigo.hexallents.newgame;


import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
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

   

    public Game() {
        this.factory = new EnemyFactory();
        this.enemy = new Enemy[23];
        /*for (int i = 0; i < enemy.length; i++){
            enemy[i] = EnemyFactory.getNewEnemy();
        }*/
        this.character = new Character[1];
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
        drawCharacter();
        while (true) {
            Thread.sleep(300);
            moveEnemies();


            if (i < enemy.length) {
                enemy[i] = createEnemy();
                /*bullet[i] = createBullet();*/
                i++;
            }
            moveEnemies();
            moveBullets();
        }
    }

/*    private Bullet createBullet() {

        return BulletGfx.getNewBullet();
    }*/

    private Enemy createEnemy() {

        return EnemyFactory.getNewEnemy();
    }

    private Character createCharacter() {
        return CharacterFactory.getNewCharacter();
    }

    private Character drawCharacter() {
        for (int i = 0; i < character.length; i++) {

                character[i] = CharacterFactory.getNewCharacter();
                if(!character[i].isDeleted() ) {
                    character[i].move();
                }
                return character[i];

        }
        return null;
    }

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

    private class Player implements MouseHandler {

        private Mouse m;
        private MouseEvent mouseReleased;
        private MouseEvent mouseClicked;
        private boolean selected;
        private int x;
        private int y;



        public Player(){
            this.m = new Mouse(this);
            addEventListener();

        }

        void addEventListener(){
            m.addEventListener(MouseEventType.MOUSE_CLICKED);
        }


        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            x = (int) mouseEvent.getX();
            y = (int) mouseEvent.getY();

            for (int i = 0; i < character.length; i++) {

                System.out.println(character[i]);
                if (x >= character[i].getX() && x <= character[i].getX()+100 &&
                        y >= character[i].getY() && y < character[i].getY() + 100){ //&&!character[i].isStaged()) {
                    character[i].delete();
                    character[i].setDeleted();
                    System.out.println("clicked");
                    System.out.println(mouseEvent);
                    return;
                }
                System.out.println(mouseEvent);
                System.out.println("out");
                return;
            }
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    }
}