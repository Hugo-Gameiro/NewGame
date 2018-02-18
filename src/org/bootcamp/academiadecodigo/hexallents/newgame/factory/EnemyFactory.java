package org.bootcamp.academiadecodigo.hexallents.newgame.factory;

import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.Enemy;
import org.bootcamp.academiadecodigo.hexallents.newgame.enemy.EnemyType;

public class EnemyFactory {

    public static Enemy getNewEnemy() {

        int random = (int) (Math.random() * EnemyType.values().length);
        EnemyType enemyType = EnemyType.values()[random];

        switch (enemyType) {
            case ENEMY_1:
                return new Enemy(enemyType);

            case ENEMY_2:
                return new Enemy(enemyType);

            case ENEMY_3:
                return new Enemy(enemyType);
        }

        return null;
    }
}
