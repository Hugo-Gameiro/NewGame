package org.bootcamp.academiadecodigo.hexallents.newgame.collision;

import org.bootcamp.academiadecodigo.hexallents.newgame.Collidable;
import org.bootcamp.academiadecodigo.hexallents.newgame.util.CoordinatesConverter;

import java.util.Iterator;
import java.util.List;

public class CollisionDetector {

    public int checkCollision(List<? extends Collidable> unos, List<? extends Collidable> doses) {

        Iterator<? extends Collidable> enemyIterator = unos.iterator();
        int killed = 0;

        while (enemyIterator.hasNext()) {
            Collidable u = enemyIterator.next();
            Iterator<? extends Collidable> bulletIterator = doses.iterator();

            while (bulletIterator.hasNext()) {
                Collidable d = bulletIterator.next();
                if (sameCoordinates(u, d)) {
                    u.die();
                    d.die();
                    enemyIterator.remove();
                    bulletIterator.remove();
                    killed++;
                    break;
                }
            }
        }

        return killed;
    }

    private boolean sameCoordinates(Collidable uno, Collidable dos) { //tres, CATORZE-TORZE PANANANANA
        return CoordinatesConverter.normalizeAxis(uno.getX()) == CoordinatesConverter.normalizeAxis(dos.getX())
                && CoordinatesConverter.normalizeAxis(uno.getY()) == CoordinatesConverter.normalizeAxis(dos.getY());

    }
}

