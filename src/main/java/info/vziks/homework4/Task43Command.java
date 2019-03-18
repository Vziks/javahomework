package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework4.animals.Dog;
import info.vziks.utils.Command;

import java.util.Random;

public class Task43Command implements Command {
    private Dog[] dogs = new Dog[20];
    private Random rnd = new Random(47);

    public Task43Command() throws TaskCommandException {
        init();
    }

    private void init() throws TaskCommandException {
        generateDogs();
    }

    @Override
    public void execute() {
        showDogs();
    }

    private void showDogs() {
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i]);
        }
    }

    public void generateDogs() throws TaskCommandException {
        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = new Dog(
                    generateString(),
                    rnd.nextInt(30),
                    rnd.nextInt(30),
                    (rnd.nextBoolean() ? generateString() : null),
                    (rnd.nextBoolean() ? generateString() : null)
            );
        }
    }

    public String generateString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (rnd.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

}
