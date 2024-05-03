package pl.mazurek.application;

import pl.mazurek.entity.Light;

public class TrafficLightSimulationApplication {

    private IntersectionService intersectionService;

    private int speed = 10;

    public static final int CZAS_DOL_GORA = 30000;
    public static final int CZAS_LEWO_PRAWO = 10000;
    public static final int CZAS_DOL_LEWO = 15000;
    public static final int CZAS_LEWO_GORA = 25000;
    private int lightTick;
    private boolean isActive = false;


    public void start() {
        if(!isActive){
            System.out.println("Start symulacji");
            simulation(CZAS_DOL_GORA, CZAS_LEWO_PRAWO, CZAS_DOL_LEWO, CZAS_LEWO_GORA);
        }
    }

    public void stop(){
        if(isActive){
            System.out.println("stop symulacji");
            isActive = false;
            intersectionService.reset();
        }
    }

    private void simulation(int czasDolGora, int czasLewoPrawo, int czasDolLewo, int czasLewoGora) {
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

                handleArrivalCarAtIntersection(intersectionService, tick);
//                handleDepartureCarFromIntersection(intersectionService, tick, czasDolGora, czasLewoPrawo, czasDolLewo, czasLewoGora);
                handleTrafficLightChange(intersectionService, czasDolGora, czasLewoPrawo, czasDolLewo, czasLewoGora);

//                printNumbersOfCarsWaitingToPass(intersectionService, tick);
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


    private void handleDepartureCarFromIntersection(IntersectionService intersectionService, int tick, int czasDolGora, int czasLewoPrawo, int czasDolLewo, int czasLewoGora) {
        // every 1 sec
        if (tick % countTimeWithSpeed(1000) == 0) {
            intersectionService.deleteCar();
        }
    }

    private void handleArrivalCarAtIntersection(IntersectionService intersectionService, int tick) {
        // every 2 second
        if (tick % countTimeWithSpeed(20000) == 0) {
            intersectionService.addCarSouth();
        }

        if (tick % countTimeWithSpeed(2000) == 0) {
            intersectionService.addCarNorth();
        }

        if (tick % countTimeWithSpeed(5500) == 0) {
            intersectionService.addCarEast();
        }

        if (tick % countTimeWithSpeed(8500) == 0) {
            intersectionService.addCarWest();
            intersectionService.addCarNorthToEast();
        }

        if (tick % countTimeWithSpeed(11500) == 0) {
            intersectionService.addCarNorthToEast();
        }

        if (tick % countTimeWithSpeed(14500) == 0) {
            intersectionService.addCarSouthToWest();
            intersectionService.addCarWestToNorth();
        }

        if (tick % countTimeWithSpeed(21500) == 0) {
            intersectionService.addCarEastToSouth();
        }
    }

    private void printNumbersOfCarsWaitingAndPassed(IntersectionService intersectionService, int tick){
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
