package pl.mazurek.entity;

public class Intersection {

    private int carsSouthToNorthForRender;
    private int carsNorthToSouthForRender;
    private int carsWestToEastForRender;
    private int carsEastToWestForRender;
    private int carsSouthToWestForRender;
    private int carsEastToSouthForRender;
    private int carsWestToNorthForRender;
    private int carsNorthToEastForRender;
    private int carsSouthToNorthOnIntersection;
    private int carsNorthToSouthOnIntersection;
    private int carsWestToEastOnIntersection;
    private int carsEastToWestOnIntersection;
    private int carsSouthToWestOnIntersection;
    private int carsEastToSouthOnIntersection;
    private int carsWestToNorthOnIntersection;
    private int carsNorthToEastOnIntersection;


    private int carsPassedSouthToNorth;
    private int carsPassedNorthToSouth;
    private int carsPassedWestToEast;
    private int carsPassedEastToWest;
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

    public int getCarsSouthToNorthForRender() {
        return carsSouthToNorthForRender;
    }

    public void setCarsSouthToNorthForRender(int carsSouthToNorthForRender) {
        this.carsSouthToNorthForRender = carsSouthToNorthForRender;
    }

    public int getCarsNorthToSouthForRender() {
        return carsNorthToSouthForRender;
    }

    public void setCarsNorthToSouthForRender(int carsNorthToSouthForRender) {
        this.carsNorthToSouthForRender = carsNorthToSouthForRender;
    }

    public int getCarsWestToEastForRender() {
        return carsWestToEastForRender;
    }

    public void setCarsWestToEastForRender(int carsWestToEastForRender) {
        this.carsWestToEastForRender = carsWestToEastForRender;
    }

    public int getCarsEastToWestForRender() {
        return carsEastToWestForRender;
    }

    public void setCarsEastToWestForRender(int carsEastToWestForRender) {
        this.carsEastToWestForRender = carsEastToWestForRender;
    }

    public int getCarsSouthToWestForRender() {
        return carsSouthToWestForRender;
    }

    public void setCarsSouthToWestForRender(int carsSouthToWestForRender) {
        this.carsSouthToWestForRender = carsSouthToWestForRender;
    }

    public int getCarsEastToSouthForRender() {
        return carsEastToSouthForRender;
    }

    public void setCarsEastToSouthForRender(int carsEastToSouthForRender) {
        this.carsEastToSouthForRender = carsEastToSouthForRender;
    }

    public int getCarsWestToNorthForRender() {
        return carsWestToNorthForRender;
    }

    public void setCarsWestToNorthForRender(int carsWestToNorthForRender) {
        this.carsWestToNorthForRender = carsWestToNorthForRender;
    }

    public int getCarsNorthToEastForRender() {
        return carsNorthToEastForRender;
    }

    public void setCarsNorthToEastForRender(int carsNorthToEastForRender) {
        this.carsNorthToEastForRender = carsNorthToEastForRender;
    }

    public int getCarsPassedSouthToNorth() {
        return carsPassedSouthToNorth;
    }

    public void setCarsPassedSouthToNorth(int carsPassedSouthToNorth) {
        this.carsPassedSouthToNorth = carsPassedSouthToNorth;
    }

    public int getCarsPassedNorthToSouth() {
        return carsPassedNorthToSouth;
    }

    public void setCarsPassedNorthToSouth(int carsPassedNorthToSouth) {
        this.carsPassedNorthToSouth = carsPassedNorthToSouth;
    }

    public int getCarsPassedWestToEast() {
        return carsPassedWestToEast;
    }

    public void setCarsPassedWestToEast(int carsPassedWestToEast) {
        this.carsPassedWestToEast = carsPassedWestToEast;
    }

    public int getCarsPassedEastToWest() {
        return carsPassedEastToWest;
    }

    public void setCarsPassedEastToWest(int carsPassedEastToWest) {
        this.carsPassedEastToWest = carsPassedEastToWest;
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

    public int getCarsSouthToNorthOnIntersection() {
        return carsSouthToNorthOnIntersection;
    }

    public void setCarsSouthToNorthOnIntersection(int carsSouthToNorthOnIntersection) {
        this.carsSouthToNorthOnIntersection = carsSouthToNorthOnIntersection;
    }

    public int getCarsNorthToSouthOnIntersection() {
        return carsNorthToSouthOnIntersection;
    }

    public void setCarsNorthToSouthOnIntersection(int carsNorthToSouthOnIntersection) {
        this.carsNorthToSouthOnIntersection = carsNorthToSouthOnIntersection;
    }

    public int getCarsWestToEastOnIntersection() {
        return carsWestToEastOnIntersection;
    }

    public void setCarsWestToEastOnIntersection(int carsWestToEastOnIntersection) {
        this.carsWestToEastOnIntersection = carsWestToEastOnIntersection;
    }

    public int getCarsEastToWestOnIntersection() {
        return carsEastToWestOnIntersection;
    }

    public void setCarsEastToWestOnIntersection(int carsEastToWestOnIntersection) {
        this.carsEastToWestOnIntersection = carsEastToWestOnIntersection;
    }

    public int getCarsSouthToWestOnIntersection() {
        return carsSouthToWestOnIntersection;
    }

    public void setCarsSouthToWestOnIntersection(int carsSouthToWestOnIntersection) {
        this.carsSouthToWestOnIntersection = carsSouthToWestOnIntersection;
    }

    public int getCarsEastToSouthOnIntersection() {
        return carsEastToSouthOnIntersection;
    }

    public void setCarsEastToSouthOnIntersection(int carsEastToSouthOnIntersection) {
        this.carsEastToSouthOnIntersection = carsEastToSouthOnIntersection;
    }

    public int getCarsWestToNorthOnIntersection() {
        return carsWestToNorthOnIntersection;
    }

    public void setCarsWestToNorthOnIntersection(int carsWestToNorthOnIntersection) {
        this.carsWestToNorthOnIntersection = carsWestToNorthOnIntersection;
    }

    public int getCarsNorthToEastOnIntersection() {
        return carsNorthToEastOnIntersection;
    }

    public void setCarsNorthToEastOnIntersection(int carsNorthToEastOnIntersection) {
        this.carsNorthToEastOnIntersection = carsNorthToEastOnIntersection;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "carsSouthToNorthForRender=" + carsSouthToNorthForRender +
                ", carsNorthToSouthForRender=" + carsNorthToSouthForRender +
                ", carsWestToEastForRender=" + carsWestToEastForRender +
                ", carsEastToWestForRender=" + carsEastToWestForRender +
                ", carsSouthToWestForRender=" + carsSouthToWestForRender +
                ", carsEastToSouthForRender=" + carsEastToSouthForRender +
                ", carsWestToNorthForRender=" + carsWestToNorthForRender +
                ", carsNorthToEastForRender=" + carsNorthToEastForRender +
                ", carsSouthToNorthOnIntersection=" + carsSouthToNorthOnIntersection +
                ", carsNorthToSouthOnIntersection=" + carsNorthToSouthOnIntersection +
                ", carsWestToEastOnIntersection=" + carsWestToEastOnIntersection +
                ", carsEastToWestOnIntersection=" + carsEastToWestOnIntersection +
                ", carsSouthToWestOnIntersection=" + carsSouthToWestOnIntersection +
                ", carsEastToSouthOnIntersection=" + carsEastToSouthOnIntersection +
                ", carsWestToNorthOnIntersection=" + carsWestToNorthOnIntersection +
                ", carsNorthToEastOnIntersection=" + carsNorthToEastOnIntersection +
                ", carsPassedSouthToNorth=" + carsPassedSouthToNorth +
                ", carsPassedNorthToSouth=" + carsPassedNorthToSouth +
                ", carsPassedWestToEast=" + carsPassedWestToEast +
                ", carsPassedEastToWest=" + carsPassedEastToWest +
                ", carsPassedSouthToWest=" + carsPassedSouthToWest +
                ", carsPassedEastToSouth=" + carsPassedEastToSouth +
                ", carsPassedWestToNorth=" + carsPassedWestToNorth +
                ", carsPassedNorthToEast=" + carsPassedNorthToEast +
                ", lightSouthToNorthAndNorthToSouth=" + lightSouthToNorthAndNorthToSouth +
                ", lightWestToEastAndEastToWest=" + lightWestToEastAndEastToWest +
                ", lightSouthToWestAndNorthToEast=" + lightSouthToWestAndNorthToEast +
                ", lightWestToNorthAndEastToSouth=" + lightWestToNorthAndEastToSouth +
                ", valueOfPassedCars=" + valueOfPassedCars +
                '}';
    }

    public void reset() {
        carsSouthToNorthForRender = 0;
        carsEastToWestForRender = 0;
        carsNorthToSouthForRender = 0;
        carsWestToEastForRender = 0;
        carsNorthToEastForRender = 0;
        carsWestToNorthForRender = 0;
        carsEastToSouthForRender = 0;
        carsSouthToWestForRender = 0;

        carsSouthToNorthOnIntersection = 0;
        carsEastToWestOnIntersection = 0;
        carsNorthToSouthOnIntersection = 0;
        carsWestToEastOnIntersection = 0;
        carsNorthToEastOnIntersection = 0;
        carsWestToNorthOnIntersection = 0;
        carsEastToSouthOnIntersection = 0;
        carsSouthToWestOnIntersection = 0;

        carsPassedSouthToNorth = 0;
        carsPassedEastToWest = 0;
        carsPassedNorthToSouth = 0;
        carsPassedWestToEast = 0;
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
