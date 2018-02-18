package org.bootcamp.academiadecodigo.hexallents.newgame.character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;

public class Character {

    private CharacterType characterType;
    private int health;
    private boolean dead;
    private Bullet bullet;
    private int x;
    private int y;
    private boolean staged;
    private boolean deleted;
    private Movable characterPicture;

    public Character(CharacterType characterType) {
        this.characterType = characterType;
        this.characterPicture = new CharacterGfx(characterType);
        this.staged = false;
        this.health = characterType.getHealth();
        this.deleted = false;

    }

/*    public int shoot(){

        createBullet();
        if(staged) {
//            bullet.move();
        }
        return characterType.getDamage();
    }*/

/*
    private Bullet createBullet(){

        */
/* criamos um novo projétil e,
        ao clicar do mouse, passo sua posição:
        (grid.makeGridPosition(getCol, getRow))*//*


        bullet = new Bullet();
        return bullet;
    }
*/

    public void hit(Enemy enemy) {

        //       health -= enemy.shoot();
        if (health <= 0) {
            dead = true;
        }

    }

    public void move(){

        characterPicture.move(1,1);

    }
/*    public void draw() {
        if (!deleted) {
            characterGfx.draw();
        }
    }*/

    public void delete() {
        characterPicture.delete();
    }
    // GETTERS AND SETTERS


    public int getX() {
        return characterType.getX();
    }

    public int getY() {
        return characterType.getY();
    }

    public int getWidth() {
        return characterPicture.getOffsetX();
    }

    public int getHeight() {
        return characterPicture.getOffsetY();
    }

/*    public CharacterGfx getCharacterGfx() {
        return characterGfx;
    }*/

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isStaged() {
        return staged;
    }

    public void setStaged() {
        this.staged = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted() {
        this.deleted = true;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterType=" + characterType +
                ", health=" + health +
                ", dead=" + dead +
                ", bullet=" + bullet +
                ", x=" + x +
                ", y=" + y +
                ", staged=" + staged +
                ", characterPicture=" + characterPicture +
                '}';
    }
}
