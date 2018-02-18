package org.bootcamp.academiadecodigo.hexallents.newgame.gfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.bootcamp.academiadecodigo.hexallents.newgame.Movable;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.Bullet;
import org.bootcamp.academiadecodigo.hexallents.newgame.bullet.BulletType;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;

public class BulletGfx implements Movable{


    private Picture[] pictures;
    private int pictureNumber;

    public BulletGfx(BulletType bulletType, Character character){
        pictureNumber = 0;
        pictures = new Picture[3];
        pictures[0] = new Picture(character.getX()+1, character.getY()+1, bulletType.getBulletPictureOne());
        pictures[1] = new Picture(character.getX()+1, character.getY()+1, bulletType.getBulletPictureTwo());
        pictures[2] = new Picture(character.getX()+1, character.getY()+1, bulletType.getBulletPictureTwo());

    }

/*    public Bullet getNewBullet() {
        return newBullet;
    }*/

    @Override
    public void move(int distanceX, int distanceY) {

        pictures[pictureNumber].delete();
        pictureNumber = pictureNumber == pictures.length - 1 ? 0 : ++pictureNumber;
        pictures[pictureNumber].translate(distanceX*pictures.length, distanceY);
        pictures[pictureNumber].draw();

    }

    @Override
    public int getOffsetX() {
        return pictures[0].getWidth();
    }

    @Override
    public int getOffsetY() {
        return pictures[0].getHeight();
    }

    @Override
    public void delete() {
        for(Picture p: pictures){
            p.delete();
        }
    }
}
