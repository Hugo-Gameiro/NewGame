package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.Character;
import org.bootcamp.academiadecodigo.hexallents.newgame.character.CharacterType;
import org.bootcamp.academiadecodigo.hexallents.newgame.gfx.CharacterGfx;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

public class Player implements MouseHandler{

    private String name;
    private Character character;
    private CharacterGfx characterGfx;
    private CharacterType type;
    private Mouse m;
    private MouseEvent mouseReleased;
    private MouseEvent mouseClicked;
    private boolean selected;
    private Grid grid;
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

        if (x >= character.getX()+100 && x < character.getX() + 200 &&
                y >= character.getY() && y < character.getY() + 200 && !character.isStaged()){

            System.out.println(character);
            System.out.println("clicked");
            return;
        }
        System.out.println("out");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
