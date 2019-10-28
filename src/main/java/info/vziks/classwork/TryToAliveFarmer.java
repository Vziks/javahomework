package info.vziks.classwork;

import java.util.Random;

public class TryToAliveFarmer {


    public static void main(String[] args) {
        Farm farm = new Farm(new Farmer(1), 15, 7);
        Random rand = new Random();

        farm.getHomeAnimals().add(new Cow(1, "Корова", 15, 30, 2));
        farm.getHomeAnimals().add(new Cat(5, "Кошка", 2, 7));
        farm.getHomeAnimals().add(new Rabbit(7, "Кролик", 4, 13));
        farm.getHomeAnimals().add(new Chicken(3, "Курица", 3, 5, 1));

        farm.getWildAnimals().add(new Wolf(3, 3, 3));
        farm.getWildAnimals().add(new Bear(1, 5, 3));
        farm.getWildAnimals().add(new Foks(5, 1, 3));


        for (int i = farm.getDayToLive(); i > 0; i--) {
            System.out.printf("Осталось дей до победы %d\n", i);

            farm.setResource(farm.getResource() - farm.getFarmer().getCostPerDay());

            System.out.println(farm.getResource());

            if (farm.getResource() < 0) {

                for (HomeAnimal an : farm.getHomeAnimals()) {

                    if (an instanceof IEdible) {
                        farm.setResource(farm.getResource() + an.getWeight());
                        farm.getHomeAnimals().remove(an);
                        break;
                    }
                }

                System.out.println("GAME OVER");
                break;
            }

            if (farm.getWildAnimals().size() <= 0) {
                System.out.println("FARMER WIN");
                break;
            }

            int randWildIndex = rand.nextInt(farm.getWildAnimals().size());

            WildAnimal randAnimal = farm.getWildAnimals().get(randWildIndex);

            if (farm.getFarmer().tryToKickAway()) {
                randAnimal.setTrays(randAnimal.getTrays() - 1);
                if (randAnimal.getTrays() <= 0) {
                    farm.getWildAnimals().remove(randAnimal);
                }
            }

            int randHomeIndex = rand.nextInt(farm.getHomeAnimals().size());

            HomeAnimal randHomeAnimal = farm.getHomeAnimals().get(randHomeIndex);

            if (randAnimal.checkSpeed(randHomeAnimal)) {

                if (!randAnimal.checkEaten()) {
                    farm.getHomeAnimals().remove(randHomeAnimal);
                } else {
                    randAnimal.hurt(randHomeAnimal);
                    if (randHomeAnimal.getHp() <= 0) {
                        farm.getHomeAnimals().remove(randHomeAnimal);

                    }
                }
            }
            for (HomeAnimal an : farm.getHomeAnimals()) {
                an.setHp(an.getHp() + 1);

                if (an instanceof IResourceSource) {
                    farm.setResource(farm.getResource() + an.getRecourse());
                }
            }

//            System.out.println(farm.getResource());

        }


    }

}
