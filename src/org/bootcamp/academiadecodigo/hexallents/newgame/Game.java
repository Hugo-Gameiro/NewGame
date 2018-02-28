package org.bootcamp.academiadecodigo.hexallents.newgame;


import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.collision.CollisionDetector;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.BulletFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.EnemyFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game {

    private Grid grid;
    private List<Enemy> enemies;
    private List<Character> characters;
    private List<Bullet> bullets;
    private int numberOfEnemies;
    private CollisionDetector collisionDetector;

    public Game() throws InterruptedException {
        characters = new LinkedList<>();
        Player player = new Player(this);
        bullets = new LinkedList<>();
        numberOfEnemies = 20;
        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector();
    }

    public void init() {
        grid = new Grid();
        Sound bgSound = new Sound("/res/tetrisSong.wav");
        bgSound.play(true);
    }

    public void start() throws InterruptedException {

        int bulletCounter = 0;
        do {

            enemies.add(createEnemy());

            Thread.sleep(300);

            // shoots one bullet per character
            if (bulletCounter == 0 || bulletCounter % 15 == 0) {
                for (Character character : characters) {
                    bullets.add(BulletFactory.getNewBullet(character.getX(), character.getY(), grid));
                }
            }

            moveEnemies();
            numberOfEnemies -= collisionDetector.checkCollision(enemies, bullets);

            moveBullets();
            collisionDetector.checkCollision(enemies, characters);

            bulletCounter++;


        } while (!isGameOver());

        disposeAll();
        showEndScreen();
    }


    private void disposeAll() {
        enemies = null;
        bullets = null;
        characters = null;
    }

    private void showEndScreen() {
        Picture picture = new Picture(0, 0, "res/gameOver.png");
        picture.draw();
    }

    private Enemy createEnemy() {

        return EnemyFactory.getNewEnemy(grid);
    }

    private void moveEnemies() throws InterruptedException {
        for (Enemy e : enemies) {
            e.move();
        }
    }

    private void moveBullets() {

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet b = iterator.next();

            if (b.isOutOfBounds()) {
                b.die();
                iterator.remove();
                continue;
            }

            b.move();
        }

    }

    private boolean isGameOver() {
        return numberOfEnemies <= 0 || enemyHasReachedGoal();
    }

    private boolean enemyHasReachedGoal() {
        for (Enemy e : enemies) {
            if (e.getX() == 100) {
                return true;
            }
        }
        return false;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }
}


