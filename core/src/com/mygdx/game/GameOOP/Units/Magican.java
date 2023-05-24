package com.mygdx.game.GameOOP.Units;

import java.util.ArrayList;

public abstract class Magican extends Shooter {
    protected float maxMana, currentMana;

    Magican(String name, float maxHp, float luck, int speed, int attack,
            int distance, int maxCountBullet, float accuracy, float armor, float maxMana, ArrayList<Unit> team, int x, int y) {
        super(name, maxHp, luck, speed, attack, distance, maxCountBullet, accuracy, armor, team, x, y);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    void heal() {

    }

    void fire() {

    }

    void freeze() {

    }

    void addMana() {

    }

    @Override
    public String getInfo() {
        return super.getInfo() + " \u26a1:" + currentMana + "/" + maxMana;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (!die() && currentMana > 0) {
            for (Unit unit : team) {
                if (!unit.die() && unit.currentHp < unit.maxHp) {
                    unit.getDmage(-attack);
                    this.currentMana--;
                    //System.out.println(this.introduce() + " лечит " + unit.introduce());
                    return;
                }
            }
        }
    }
}
