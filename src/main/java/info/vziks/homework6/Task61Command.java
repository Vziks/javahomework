package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.Command;

public class Task61Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        Knight knight = new Knight();
        Warrior warrior = new Warrior();
        Doctor doctor = new Doctor();

        knight.attack(warrior);
        knight.attack(warrior);
        warrior.attack(doctor);
        warrior.attack(doctor);
        warrior.attack(doctor);
        doctor.attack(knight);
        doctor.attack(knight);


        System.out.println(knight);
        System.out.println(warrior);
        System.out.println(doctor);

    }
}
