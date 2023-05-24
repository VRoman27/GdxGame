package com.mygdx.game.GameOOP.Units;

import java.util.ArrayList;

public abstract class Shooter extends Unit {
    protected int distance, maxCountBullet, currentCountBullet;
    protected float accuracy;

    Shooter(String name, float maxHp, float luck, int speed, int attack,
            int distance, int maxCountBullet, float accuracy, float armor,
            ArrayList<Unit> team, int x, int y) {
        super(name, maxHp, luck, speed, attack, armor, team, x, y);
        this.distance = distance;
        this.maxCountBullet = maxCountBullet;
        this.currentCountBullet = maxCountBullet;
        this.accuracy = accuracy;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " d:" + distance +
                " \u27b9:" + currentCountBullet + "/" + maxCountBullet;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die() || currentCountBullet <= 0) {
            return;
        }
        attack(findNearUnit(enemy));
        for (Unit unit : team) {
            if (unit instanceof Peasant) {
                if (!unit.die() && ((Peasant)unit).readiness) {
                    ((Peasant)unit).readiness = false;
                    return;
                }
            }
        }
        this.currentCountBullet--;
    }
}
