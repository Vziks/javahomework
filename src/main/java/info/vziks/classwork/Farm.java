package info.vziks.classwork;

import java.util.ArrayList;
import java.util.List;

class Farm {

    private Farmer farmer;
    private int resource;
    private int dayToLive;

    private List<WildAnimal> wildAnimals = new ArrayList<WildAnimal>();
    private List<HomeAnimal> homeAnimals = new ArrayList<HomeAnimal>();

    public Farm(Farmer farmer, int resource, int dayToLive) {
        this.farmer = farmer;
        this.resource = resource;
        this.dayToLive = dayToLive;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getDayToLive() {
        return dayToLive;
    }

    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }

    public List<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public void setWildAnimals(List<WildAnimal> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public List<HomeAnimal> getHomeAnimals() {
        return homeAnimals;
    }

    public void setHomeAnimals(List<HomeAnimal> homeAnimals) {
        this.homeAnimals = homeAnimals;
    }
}
