package com.mygdx.game.GameOOP;

import java.nio.charset.Charset;
import java.util.*;


import com.mygdx.game.GameOOP.Units.*;
public class Main {

    public Main(){
        for (int i = 1; i < 11; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team1.add(new Peasant(getName(), team1, 1, i));
                    break;
                case 1:
                    team1.add(new Spearman(getName(), team1, 1, i));
                    break;
                case 2:
                    team1.add(new Crossbowman(getName(), team1, 1, i));
                    break;
                case 3:
                    team1.add(new Wizard(getName(), team1, 1, i));
                    break;
            }
        }

        for (int i = 1; i < 11; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    team2.add(new Peasant(getName(), team2, 10, i));
                    break;
                case 1:
                    team2.add(new Thief(getName(), team2, 10, i));
                    break;
                case 2:
                    team2.add(new Sniper(getName(), team2, 10, i));
                    break;
                case 3:
                    team2.add(new Monk(getName(), team2, 10, i));
                    break;
            }
        }

        team3.addAll(team1);
        team3.addAll(team2);
        Collections.sort(team3, new Comparator<Unit>() {

            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.speed - o1.speed;
            }

        });


    }

    static public ArrayList<Unit> team1 = new ArrayList<>();
    static public ArrayList<Unit> team2 = new ArrayList<>();
    static public ArrayList<Unit> team3 = new ArrayList<>();

    public void step() {
            for (Unit unit : team3) {
                if (team1.contains(unit)) {
                    unit.step(team2);
                }else{
                    unit.step(team1);
                }
            }
        }

    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
}
