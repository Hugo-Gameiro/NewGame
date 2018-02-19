package org.bootcamp.academiadecodigo.hexallents.newgame;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
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

import java.util.IllegalFormatCodePointException;

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
    private boolean exit;
    private int numberOfEnemies;
    private int level;
    private int enemiesKilled;
    private Menu menu;
    private Sound sound;

   

    public Game() throws InterruptedException {
        this.factory = new EnemyFactory();
        /*for (int i = 0; i < enemy.length; i++){
            enemy[i] = EnemyFactory.getNewEnemy();
        }*/
        this.character = new Character[10];
        this.characterFactory = new CharacterFactory();
        this.player = new Player();
        this.bullet = new Bullet[10000];
        this.characterStaged = false;
        this.exit = false;
        this.numberOfEnemies = 0;
        this.enemy = new Enemy[10];
        this.sound = new Sound("res/aladdin_problem.wav");
    }


    public void init() throws InterruptedException {
        grid = new GridGfx();
        this.menu = new Menu();
        //characterGfx.draw();
        //start();
        player.addEventListener();
        menu.setEvents();
        Thread.sleep(3500);
        start();
        sound.play(true);


    }

    public void start() throws InterruptedException {
        int i = 0;
    //    drawCharacter();
        while (!exit) {
            Thread.sleep(300);
            moveEnemies();
            detectCollision();

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
                dectectEnemyCollision();
     //           shoot();
            }


        gameOver();
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

    private void detectCollision(){

        for (int i = 0; i < bullet.length; i++) {
            for (int j = 0; j < enemy.length; j++) {
                if (bullet[i] == null || enemy[j] == null) {
                    return;
                }

                if (!bullet[i].isCrashed() && !enemy[j].isDead() &&
                        (((int) (enemy[j].getX() / 100)) * 100) == (((int) (bullet[i].getX() / 100) * 100))
                        && ((int) (enemy[j].getY() / 100) * 100) == (((int) (bullet[i].getY() / 100) * 100))) {
                    bullet[i].crash();
                    enemy[j].setDead();
                    enemiesKilled++;

                }
            }
        }
    }

    private void dectectEnemyCollision(){
        for (int i = 0; i < enemy.length; i++) {
            System.out.println("   " + enemy[i]);
            for (int j = 0; j < character.length; j++) {
                if (enemy[i] == null || character[j] == null) {
                    return;
                }

                if (!enemy[i].isDead() )
                    if(!character[j].isDead() &&
                            (((int) (enemy[i].getX() / 100)) * 100) == (((int) (character[j].getX() / 100) * 100))
                            && ((int) (enemy[i].getY() / 100) * 100) == (((int) (character[j].getY() / 100) * 100))) {
                        System.out.println("entrou    " + character[j]);
                        character[j].setDead();
                    }
            }
        }
    }

    private void shoot(){

        for (int j = 0; j < character.length; j++) {

            for (int i = 0; i < character[j].getBullets().length; i++) {
                if(bullet[i] == null) {
                    System.out.println(bullet.length);
                    bullet[i] = character[j].shoot();
                    break;
                }
            }
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

    private void gameOver() throws InterruptedException {
        for (int i = 0; i < enemy.length; i++){
            if (enemy[i]== null){
                break;
            }
            if (enemy[i].getX() <= 100 && enemy[i] != null){
                exit = true;
            Picture gameOver = new Picture(0, 0, "res/gameOver.png");
            gameOver.draw();
            Thread.sleep(2000);
            }

            if (enemy[0].isDead()){
                for (int j = 1; j < enemy.length; j++){
                    if (!enemy[j].isDead()){
                        break;
                    }

                    if (enemy[j].isDead()){
                    Picture wonGame = new Picture(0,0, "res/weWin.png");
                    wonGame.draw();
                    Thread.sleep(2000);

                    }
                }
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

        public void mouseClicked(MouseEvent mouseEvent) {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();


            for (int i = 0; i < character.length; i++) {

                if ((x >= 100 && x < 900) && (y >= 100 && y < 600)) {
                    x = ((int) (x / 100)) * 100;
                    y = ((int) (y / 100)) * 100;
                    character[i] = CharacterFactory.getNewCharacter(x, y);
                    character[i].move();
                    characterStaged = true;

                }


            }
            for (int i = 0; i < character.length; i++) {
                for (int j = 0; j < character[i].getBullets().length; j++) {
                    if (bullet[j] == null) {

                        bullet[j] = character[i].shoot();

                        return;
                    }


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

    private class Menu implements KeyboardHandler{


        private Keyboard keyboard;
        private KeyboardEvent spaceKey;
        private KeyboardEvent qKey;
        private Game game;
        private Picture menu;

        public Menu() throws InterruptedException {
            this.menu = new Picture(0,0, "res/Begin.png");
            menu.draw();

        }

        public void setEvents(){
            keyboard = new Keyboard(this);
            spaceKey = new KeyboardEvent();
            qKey = new KeyboardEvent();
            spaceKey.setKey(KeyboardEvent.KEY_SPACE);
            qKey.setKey(KeyboardEvent.KEY_Q);

            spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            qKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


            keyboard.addEventListener(qKey);
            keyboard.addEventListener(spaceKey);

        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
                menu.delete();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
                    menu.draw();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
}


