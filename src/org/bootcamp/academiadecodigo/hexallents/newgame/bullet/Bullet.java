package org.bootcamp.academiadecodigo.hexallents.newgame.bullet;

import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.BulletGfx;

public class Bullet {


    private int x;
    private int y;
    private boolean crashed;
//    private Character character;
    private BulletType bulletType;
    private BulletGfx bulletGfx;


    public Bullet(Character character, BulletType bulletType){
//        this.character = character;
        this.bulletType = bulletType;
        x = character.getX();
        y = character.getY();
        crashed = false;
    }


}





/**

y = (int) ((Math.random() * (600 - 100)) + 100) / 100;

        switch (y){
        case 1:
        return 100;

        case 2:
        return 200;

        case 3:
        return 300;

        case 4:
        return 400;

        case 5:
        return 500;
        }
        return -1;





 y = (int) ((Math.random() * (600 - 100)) + 100) / 100;

 switch (y){
 case 1:
 return 100;

 case 2:
 return 200;

 case 3:
 return 300;

 case 4:
 return 400;

 case 5:
 return 500;
 }
 return -1;





**/



