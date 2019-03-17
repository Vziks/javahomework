package info.vziks.homework4;

import info.vziks.homework4.animals.Cat;
import info.vziks.utils.Command;

import java.util.Random;

public class Task44Command implements Command {

    Random rnd = new Random(47);
    Cat[] cats = new Cat[5];

    public Task44Command() {
        init();
    }

    private void init() {

        for (int i = 0; i < cats.length; i++) {

            cats[i] = new Cat("Cat" + i,
                    rnd.nextInt(20),
                    rnd.nextInt(20),
                    rnd.nextInt(20));
        }
    }

    @Override
    public void execute() {
        showFight();
    }

    public void showFight() {
        for (int i = 0; i < cats.length - 1; i++) {
            System.out.println(cats[i].fight(cats[i + 1]));
            System.out.println(cats[i + 1].fight(cats[i]));
        }
    }
}
