package org.bootcamp.academiadecodigo.hexallents.newgame.util;

public final class CoordinatesConverter {

    private CoordinatesConverter() {}

    public static int normalizeAxis(double axisValue) {
        return ((int) (axisValue / 100)) * 100;
    }
}
