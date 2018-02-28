package org.bootcamp.academiadecodigo.hexallents.newgame.factory;

import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;
import org.bootcamp.academiadecodigo.hexallents.newgame.grid.Grid;

public class EnemyFactory {

    public static Enemy getNewEnemy(Grid grid) {
        int random = (int) (Math.random() * EnemyType.values().length);
        EnemyType enemyType = EnemyType.values()[random];

        return new Enemy(enemyType, grid);
    }
}
