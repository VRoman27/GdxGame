package com.mygdx.game.GameOOP.Units;

import java.util.ArrayList;

public class Wizard extends Magican {

    public Wizard(String name, ArrayList<Unit> team, int x, int y) {
        super(name, 20, 0.7f, 2, 2, 5, 10, 1, 5, 50, team, x, y);
    }

    @Override
    public String toString() {
        return "Маг";
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }

}
