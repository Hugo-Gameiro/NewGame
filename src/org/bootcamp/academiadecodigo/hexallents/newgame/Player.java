package org.bootcamp.academiadecodigo.hexallents.newgame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.bootcamp.academiadecodigo.hexallents.newgame.factory.CharacterFactory;
import org.bootcamp.academiadecodigo.hexallents.newgame.util.CoordinatesConverter;

public class Player implements MouseHandler {

    private final Game game;
    private Mouse m;


    public Player(Game game) {
        this.game = game;
        this.m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        int x = CoordinatesConverter.normalizeAxis(mouseEvent.getX());
        int y = CoordinatesConverter.normalizeAxis(mouseEvent.getY());

        if ((x >= 100 && x < 900) && (y >= 100 && y < 600)) {
            game.addCharacter(CharacterFactory.getNewCharacter(x, y));
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}

}
