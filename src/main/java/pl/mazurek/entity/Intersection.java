package pl.mazurek.entity;

public class Intersection {

    private int carsSouth;
    private int carsNorth;
    private int carsWest;
    private int carsEast;
    private int carsSouthToWest;
    private int carsEastToSouth;
    private int carsWestToNorth;
    private int carsNorthToEast;


    private int carsPassedSouth;
    private int carsPassedNorth;
    private int carsPassedWest;
    private int carsPassedEast;
    private int carsPassedSouthToWest;
    private int carsPassedEastToSouth;
    private int carsPassedWestToNorth;
    private int carsPassedNorthToEast;

    private Light lightSouthToNorthAndNorthToSouth;
    private Light lightWestToEastAndEastToWest;
    private Light lightSouthToWestAndNorthToEast;
    private Light lightWestToNorthAndEastToSouth;

    private int valueOfPassedCars;

    public Intersection() {
        reset();
    }

    public int getCarsSouth() {
        return carsSouth;
    }

    public void setCarsSouth(int carsSouth) {
        this.carsSouth = carsSouth;
    }

    public int getCarsNorth() {
        return carsNorth;
    }

    public void setCarsNorth(int carsNorth) {
        this.carsNorth = carsNorth;
    }

    public int getCarsWest() {
        return carsWest;
    }

    public void setCarsWest(int carsWest) {
        this.carsWest = carsWest;
    }

    public int getCarsEast() {
        return carsEast;
    }

    public void setCarsEast(int carsEast) {
        this.carsEast = carsEast;
    }

    public int getCarsSouthToWest() {
        return carsSouthToWest;
    }

    public void setCarsSouthToWest(int carsSouthToWest) {
        this.carsSouthToWest = carsSouthToWest;
    }

    public int getCarsEastToSouth() {
        return carsEastToSouth;
    }

    public void setCarsEastToSouth(int carsEastToSouth) {
        this.carsEastToSouth = carsEastToSouth;
    }

    public int getCarsWestToNorth() {
        return carsWestToNorth;
    }

    public void setCarsWestToNorth(int carsWestToNorth) {
        this.carsWestToNorth = carsWestToNorth;
    }

    public int getCarsNorthToEast() {
        return carsNorthToEast;
    }

    public void setCarsNorthToEast(int carsNorthToEast) {
        this.carsNorthToEast = carsNorthToEast;
    }

    public int getCarsPassedSouth() {
        return carsPassedSouth;
    }

    public void setCarsPassedSouth(int carsPassedSouth) {
        this.carsPassedSouth = carsPassedSouth;
    }

    public int getCarsPassedNorth() {
        return carsPassedNorth;
    }

    public void setCarsPassedNorth(int carsPassedNorth) {
        this.carsPassedNorth = carsPassedNorth;
    }

    public int getCarsPassedWest() {
        return carsPassedWest;
    }

    public void setCarsPassedWest(int carsPassedWest) {
        this.carsPassedWest = carsPassedWest;
    }

    public int getCarsPassedEast() {
        return carsPassedEast;
    }

    public void setCarsPassedEast(int carsPassedEast) {
        this.carsPassedEast = carsPassedEast;
    }

    public int getCarsPassedSouthToWest() {
        return carsPassedSouthToWest;
    }

    public void setCarsPassedSouthToWest(int carsPassedSouthToWest) {
        this.carsPassedSouthToWest = carsPassedSouthToWest;
    }

    public int getCarsPassedEastToSouth() {
        return carsPassedEastToSouth;
    }

    public void setCarsPassedEastToSouth(int carsPassedEastToSouth) {
        this.carsPassedEastToSouth = carsPassedEastToSouth;
    }

    public int getCarsPassedWestToNorth() {
        return carsPassedWestToNorth;
    }

    public void setCarsPassedWestToNorth(int carsPassedWestToNorth) {
        this.carsPassedWestToNorth = carsPassedWestToNorth;
    }

    public int getCarsPassedNorthToEast() {
        return carsPassedNorthToEast;
    }

    public void setCarsPassedNorthToEast(int carsPassedNorthToEast) {
        this.carsPassedNorthToEast = carsPassedNorthToEast;
    }

    public Light getLightSouthToNorthAndNorthToSouth() {
        return lightSouthToNorthAndNorthToSouth;
    }

    public void setLightSouthToNorthAndNorthToSouth(Light lightSouthToNorthAndNorthToSouth) {
        this.lightSouthToNorthAndNorthToSouth = lightSouthToNorthAndNorthToSouth;
    }

    public Light getLightWestToEastAndEastToWest() {
        return lightWestToEastAndEastToWest;
    }

    public void setLightWestToEastAndEastToWest(Light lightWestToEastAndEastToWest) {
        this.lightWestToEastAndEastToWest = lightWestToEastAndEastToWest;
    }

    public Light getLightSouthToWestAndNorthToEast() {
        return lightSouthToWestAndNorthToEast;
    }

    public void setLightSouthToWestAndNorthToEast(Light lightSouthToWestAndNorthToEast) {
        this.lightSouthToWestAndNorthToEast = lightSouthToWestAndNorthToEast;
    }

    public Light getLightWestToNorthAndEastToSouth() {
        return lightWestToNorthAndEastToSouth;
    }

    public void setLightWestToNorthAndEastToSouth(Light lightWestToNorthAndEastToSouth) {
        this.lightWestToNorthAndEastToSouth = lightWestToNorthAndEastToSouth;
    }

    public int getValueOfPassedCars() {
        return valueOfPassedCars;
    }

    public void setValueOfPassedCars(int valueOfPassedCars) {
        this.valueOfPassedCars = valueOfPassedCars;
    }

    public void reset() {
        carsSouth = 0;
        carsEast = 0;
        carsNorth = 0;
        carsWest = 0;
        carsNorthToEast = 0;
        carsWestToNorth = 0;
        carsEastToSouth = 0;
        carsSouthToWest = 0;

        carsPassedSouth = 0;
        carsPassedEast = 0;
        carsPassedNorth = 0;
        carsPassedWest = 0;
        carsPassedNorthToEast = 0;
        carsPassedWestToNorth = 0;
        carsPassedEastToSouth = 0;
        carsPassedSouthToWest = 0;

        lightSouthToNorthAndNorthToSouth = Light.GREEN;
        lightWestToEastAndEastToWest = Light.RED;
        lightSouthToWestAndNorthToEast = Light.RED;
        lightWestToNorthAndEastToSouth = Light.RED;

        valueOfPassedCars = 0;
    }
}
