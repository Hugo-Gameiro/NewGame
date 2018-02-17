package org.bootcamp.academiadecodigo.hexallents.newgame.character;

import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;

public class Character {

    private CharacterType characterType;
    private CharacterGfx characterGfx;
    private int health;
    private boolean dead;
    private Bullet bullet;
    private int x;
    private int y;
    protected boolean staged;

    public Character(CharacterType characterType){
        this.characterType = characterType;
        this.characterGfx = new CharacterGfx(characterType);
        staged = false;
        this.health = characterType.getHealth();
    }

    public int shoot(){

        createBullet();
        if(staged) {
//            bullet.move();
        }
        return characterType.getDamage();
    }

    private Bullet createBullet(){

        /* criamos um novo projétil e,
        ao clicar do mouse, passo sua posição:
        (grid.makeGridPosition(getCol, getRow))*/

        bullet = new Bullet();
        return bullet;
    }

    public void hit(Enemy enemy){

 //       health -= enemy.shoot();
        if(health <= 0){
            dead=true;
        }

    }

    // GETTERS AND SETTERS


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }
}
