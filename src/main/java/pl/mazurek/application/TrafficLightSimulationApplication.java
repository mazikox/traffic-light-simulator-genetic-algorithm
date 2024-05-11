package pl.mazurek.application;

import pl.mazurek.entity.Light;

public class TrafficLightSimulationApplication {

    private IntersectionService intersectionService;

    private int speed = 10;

    public static int CZAS_DOL_GORA = 30000;
    public static int CZAS_LEWO_PRAWO = 10000;
    public static int CZAS_DOL_LEWO = 15000;
    public static int CZAS_LEWO_GORA = 25000;
    public static int carArrivalTimeNorthToSouth = 2000;
    public static int carArrivalTimeEastToWest = 5500;
    public static int carArrivalTimeSouthToNorth = 20000;
    public static int carArrivalTimeWestToEast = 8500;
    public static int carArrivalTimeNorthToEast = 8500;
    public static int carArrivalTimeEastToSouth = 18500;
    public static int carArrivalTimeSouthToWest = 14500;
    public static int carArrivalTimeWestToNorth = 14500;
    private int lightTick;
    private boolean isActive = false;


    public void start() {
        if(!isActive){
            System.out.println("Start symulacji");
            simulation();
        }
    }

    public void stop(){
        if(isActive){
            System.out.println("stop symulacji");
            isActive = false;
            intersectionService.reset();
        }
    }

    private void simulation() {
        int wartosc;
        isActive = true;

        long lastTime = System.nanoTime();
        // 1000 ticks per second
        double amountOfTicks = 1000;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        int tick = 0;
        lightTick = 0;

        while (isActive) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                delta--;
                tick++;
                lightTick++;

                handleArrivalCarAtIntersection(tick);
//                handleDepartureCarFromIntersection(intersectionService, tick, czasDolGora, czasLewoPrawo, czasDolLewo, czasLewoGora);
                handleTrafficLightChange(intersectionService, CZAS_DOL_GORA, CZAS_LEWO_PRAWO, CZAS_DOL_LEWO, CZAS_LEWO_GORA);

                printNumbersOfCarsWaitingAndPassed(tick);
            }
        }
    }

    private void handleTrafficLightChange(IntersectionService intersectionService, int czasDolGora, int czasLewoPrawo, int czasDolLewo, int czasLewoGora) {
        if (intersectionService.intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasDolGora) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasLewoPrawo) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasDolLewo) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasLewoGora) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        }
    }



    private void handleArrivalCarAtIntersection(int tick) {
        // every 2 second
        if (tick % countTimeWithSpeed(carArrivalTimeSouthToNorth) == 0) {
            intersectionService.addCarSouth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeNorthToSouth) == 0) {
            intersectionService.addCarNorth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeEastToWest) == 0) {
            intersectionService.addCarEast();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeWestToEast) == 0) {
            intersectionService.addCarWest();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeNorthToEast) == 0) {
            intersectionService.addCarNorthToEast();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeSouthToWest) == 0) {
            intersectionService.addCarSouthToWest();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeWestToNorth) == 0) {
            intersectionService.addCarWestToNorth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeEastToSouth) == 0) {
            intersectionService.addCarEastToSouth();
        }
    }

    private void printNumbersOfCarsWaitingAndPassed(int tick){
        if (tick % countTimeWithSpeed(55000) == 0) {
            intersectionService.printNumbersOfCarsWaitingToPass();
            intersectionService.printNumbersOfCarsPassed();
        }
    }

    private int countTimeWithSpeed(int time) {
        if(speed < 1){
            speed = 1;
        }
        return time / speed;
    }

    public TrafficLightSimulationApplication(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
    }

    public IntersectionService getIntersectionService() {
        return intersectionService;
    }

    public boolean isActive() {
        return isActive;
    }
}
