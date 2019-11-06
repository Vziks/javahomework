package info.vziks.homework9;

import info.vziks.homework9.units.*;
import info.vziks.utils.Command;

public class Task91Command implements Command {
    @Override
    public void execute() {

        Warrior warrior = (Warrior) BattleUnit.getUnitByName("warrior");
        Knight knight = (Knight) BattleUnit.getUnitByName("knight");
        Knight knight1 = (Knight) BattleUnit.getUnitByName("Knight");


        King king = King.getInstance(15, 15);

        System.out.println("warrior = " + warrior);
        System.out.println("knight = " + knight);
        System.out.println("knight1 = " + knight1);
        System.out.println("king = " + king);

    }
}
