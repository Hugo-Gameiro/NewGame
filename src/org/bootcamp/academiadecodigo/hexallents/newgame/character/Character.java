package org.bootcamp.academiadecodigo.hexallents.newgame.character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.BulletType;
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

    private Bullet[] bullets;

    public Character(CharacterType characterType) {
        this.characterType = characterType;
        this.characterPicture = new CharacterGfx(characterType, this);
        this.staged = false;
        this.health = characterType.getHealth();
        this.deleted = false;
        this.y = 0;
        switch (characterType) {
            case CHARACTER_1:
                this.x = 100;
                break;
            case CHARACTER_2:
                this.x = 200;
                break;
            case CHARACTER_3:
                this.x = 300;
        }

        bullets = new Bullet[100];
    }

    public Character(CharacterType characterType, int x, int y) {
        this.characterType = characterType;
        this.x = x;
        this.y = y;
        this.characterPicture = new CharacterGfx(characterType, this);
        this.health = characterType.getHealth();
        this.deleted = false;

    }

    public Bullet shoot() {

        if (!isDead()) {

            bullet = createBullet();
            bullet.move();
        }
        return bullet;
    }

    public void moveBullet(){
        bullet.move();
    }

    private Bullet createBullet() {

        switch (characterType) {
            case CHARACTER_1:
                return new Bullet(this, BulletType.BULLET_1);
            case CHARACTER_2:
                return new Bullet(this, BulletType.BULLET_2);
            case CHARACTER_3:
                return new Bullet(this, BulletType.BULLET_3);

        }
        return null;
    }


    public void hit(Enemy enemy) {

        //       health -= enemy.shoot();
        if (health <= 0) {
            dead = true;
        }

    }

    public void move() {

        characterPicture.move(1, 1);

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
        return x;
    }

    public int getY() {
        return y;
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

    public CharacterType getCharacterType() {
        return characterType;
    }

    public Bullet[] getBullets() {
        return bullets;
    }

    public void setBullets(Bullet bullet) {
        for(int i = 0; i < bullets.length; i++){
            if(bullets[i] == null){
                bullets[i] = bullet;
                return;
        }
        }
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
