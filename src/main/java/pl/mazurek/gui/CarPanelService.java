package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;
import pl.mazurek.entity.Car;
import pl.mazurek.entity.Direction;
import pl.mazurek.entity.Light;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarPanelService extends JPanel {
    private TrafficLightSimulationApplication simulationApplication;
    private List<Car> cars;
    private int carWidth = 30;
    private int carHeight = 40;

    public CarPanelService(TrafficLightSimulationApplication simulationApplication) {
        cars = new CopyOnWriteArrayList<>();
        ;
        this.simulationApplication = simulationApplication;
    }


    public void addCar(int startX, int startY, Direction startPosition, Direction direction) {
        cars.add(new Car(startX, startY, startPosition, direction));
        repaint();
    }

    public void createCars() {
        while (true) {
            if (simulationApplication.isActive()) {
                synchronized (getCars()) {
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsSouthToNorthForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.SOUTH, Direction.NORTH);
                        int x = 780;
                        int y = 750;
                        // jesli samochod jest poza ekranem
                        if (previousCar != null && previousCar.y > 700) {
                            y = previousCar.y + 50;
                        }
                        addCar(x, y, Direction.SOUTH, Direction.NORTH);
                        simulationApplication.getIntersectionService().getIntersection().setCarsSouthToNorthForRender(simulationApplication.getIntersectionService().getIntersection().getCarsSouthToNorthForRender() - 1);

                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsNorthToSouthForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.NORTH, Direction.SOUTH);
                        int x = 200;
                        int y = -50;
                        if (previousCar != null && previousCar.y < 0) {
                            y = previousCar.y - 50;
                        }
                        addCar(x, y, Direction.NORTH, Direction.SOUTH);
                        simulationApplication.getIntersectionService().getIntersection().setCarsNorthToSouthForRender(simulationApplication.getIntersectionService().getIntersection().getCarsNorthToSouthForRender() - 1);
                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsWestToEastForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.WEST, Direction.EAST);
                        int x = -50;
                        int y = 520;
                        if (previousCar != null && previousCar.x < 0) {
                            x = previousCar.x - 50;
                        }
                        addCar(x, y, Direction.WEST, Direction.EAST);
                        simulationApplication.getIntersectionService().getIntersection().setCarsWestToEastForRender(simulationApplication.getIntersectionService().getIntersection().getCarsWestToEastForRender() - 1);
                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsEastToWestForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.EAST, Direction.WEST);
                        int x = 920;
                        int y = 170;
                        if (previousCar != null && previousCar.x > 900) {
                            x = previousCar.x + 50;
                        }
                        addCar(x, y, Direction.EAST, Direction.WEST);
                        simulationApplication.getIntersectionService().getIntersection().setCarsEastToWestForRender(simulationApplication.getIntersectionService().getIntersection().getCarsEastToWestForRender() - 1);
                    }

                    if (simulationApplication.getIntersectionService().getIntersection().getCarsSouthToWestForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.SOUTH, Direction.WEST);
                        int x = 600;
                        int y = 750;
                        if (previousCar != null && previousCar.y > 700) {
                            y = previousCar.y + 50;
                        }
                        addCar(x, y, Direction.SOUTH, Direction.WEST);
                        simulationApplication.getIntersectionService().getIntersection().setCarsSouthToWestForRender(simulationApplication.getIntersectionService().getIntersection().getCarsSouthToWestForRender() - 1);
                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsWestToNorthForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.WEST, Direction.NORTH);
                        int x = -50;
                        int y = 420;
                        if (previousCar != null && previousCar.x < 0) {
                            x = previousCar.x - 50;
                        }
                        addCar(x, y, Direction.WEST, Direction.NORTH);
                        simulationApplication.getIntersectionService().getIntersection().setCarsWestToNorthForRender(simulationApplication.getIntersectionService().getIntersection().getCarsWestToNorthForRender() - 1);
                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsNorthToEastForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.NORTH, Direction.EAST);
                        int x = 300;
                        int y = -50;
                        if (previousCar != null && previousCar.y < 0) {
                            y = previousCar.y - 50;
                        }
                        addCar(x, y, Direction.NORTH, Direction.EAST);
                        simulationApplication.getIntersectionService().getIntersection().setCarsNorthToEastForRender(simulationApplication.getIntersectionService().getIntersection().getCarsNorthToEastForRender() - 1);
                    }
                    if (simulationApplication.getIntersectionService().getIntersection().getCarsEastToSouthForRender() > 0) {
                        Car previousCar = getLastCarFromDirection(Direction.EAST, Direction.SOUTH);
                        int x = 920;
                        int y = 270;
                        if (previousCar != null && previousCar.x > 900) {
                            x = previousCar.x + 50;
                        }
                        addCar(x, y, Direction.EAST, Direction.SOUTH);
                        simulationApplication.getIntersectionService().getIntersection().setCarsEastToSouthForRender(simulationApplication.getIntersectionService().getIntersection().getCarsEastToSouthForRender() - 1);
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void moveCars() {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if ((car.getDirection() == Direction.NORTH && car.getStartPosition() == Direction.SOUTH) &&
                    (simulationApplication.getIntersectionService().intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN || car.y < 450)) {

                Car previousCar = getLastCarFromDirectionInFront(Direction.SOUTH, Direction.WEST, car);

                if((previousCar == null || (previousCar.y + 50 > car.x) || car.y < 450)){
                    car.y -= 2 * 3;
                }
            } else if ((car.getDirection() == Direction.SOUTH && car.getStartPosition() == Direction.NORTH) &&
                    (simulationApplication.getIntersectionService().intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN || car.y > 200)) {
                car.y += 2 * 3;
                if (car.y > 200) {
                    car.setMoving(true);
                }
            } else if ((car.getDirection() == Direction.WEST && car.getStartPosition() == Direction.EAST) &&
                    (simulationApplication.getIntersectionService().intersection.getLightWestToEastAndEastToWest() == Light.GREEN || car.x < 780)) {
                car.x -= 2 * 3;
                if (car.x < 780) {
                    car.setMoving(true);
                }
            } else if ((car.getDirection() == Direction.EAST && car.getStartPosition() == Direction.WEST)
                    && (simulationApplication.getIntersectionService().intersection.getLightWestToEastAndEastToWest() == Light.GREEN || car.x > 250)) {
                car.x += 2 * 3;
                if (car.x > 250) {
                    car.setMoving(true);
                }
            } else if ((car.getDirection() == Direction.WEST && car.getStartPosition() == Direction.SOUTH)
                    && (simulationApplication.getIntersectionService().intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN || car.y < 450)) {

                Car previousCar = getLastCarFromDirectionInFront(Direction.SOUTH, Direction.WEST, car);

                if (car.y > 250  && (previousCar == null || (previousCar.y - 50 < car.y) || car.y < 450)) {
                    car.y -= 2 * 3;
                } else {
                    car.x -= 2 * 3;
                }
            } else if ((car.getDirection() == Direction.NORTH && car.getStartPosition() == Direction.WEST)
                    && (simulationApplication.getIntersectionService().intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN || car.x > 250)) {

                Car previousCar = getLastCarFromDirectionInFront(Direction.WEST, Direction.NORTH, car);

                if (car.x < 450 && (previousCar == null || (previousCar.x + 50 > car.x) || car.x > 250)) {
                    car.x += 2 * 3;
                } else {
                    car.y -= 2 * 3;
                }
            } else if ((car.getDirection() == Direction.EAST && car.getStartPosition() == Direction.NORTH)
                    && (simulationApplication.getIntersectionService().intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN || car.y > 200)) {

                Car previousCar = getLastCarFromDirectionInFront(Direction.NORTH, Direction.EAST, car);

                if (car.y < 400 && (previousCar == null || (previousCar.y + 50 > car.y) || car.y > 200)) {
                    car.y += 2 * 3;
                } else {
                    car.x += 2 * 3;
                }
            } else if ((car.getDirection() == Direction.SOUTH && car.getStartPosition() == Direction.EAST)
                    && (simulationApplication.getIntersectionService().intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN || car.x < 780)) {

                Car previousCar = getLastCarFromDirectionInFront(Direction.EAST, Direction.SOUTH, car);

                if (car.x > 580 && (previousCar == null || (previousCar.x - 50 < car.x) || car.x < 780) ) {
                    car.x -= 2 * 3;
                } else if (car.x <= 580) {
                    car.y += 2 * 3;
                }
            }

            if (car.getStartPosition() == Direction.SOUTH && car.getDirection() == Direction.NORTH && car.y < 0) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.NORTH && car.getDirection() == Direction.SOUTH && car.y > 700) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.WEST && car.getDirection() == Direction.EAST && car.x > 1000) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.EAST && car.getDirection() == Direction.WEST && car.x < 0) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.SOUTH && car.getDirection() == Direction.WEST && car.x < 0) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.NORTH && car.getDirection() == Direction.EAST && car.x > 1000) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.WEST && car.getDirection() == Direction.NORTH && car.y < 0) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
            if (car.getStartPosition() == Direction.EAST && car.getDirection() == Direction.SOUTH && car.y > 700) {
                simulationApplication.getIntersectionService().deleteCar(car);
                cars.remove(car);
            }
        }
        repaint();
    }


    public void resetCars() {
        for (Car car : cars) {
            cars.remove(car);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img = ImageIO.read(new File("F:\\IntellijProjects\\notes-manager\\traffic-light-manager\\src\\main\\resources\\images\\Useless.png"));
            Image imgBackground = ImageIO.read(new File("F:\\IntellijProjects\\notes-manager\\traffic-light-manager\\src\\main\\resources\\images\\intersection.png"));
            g.drawImage(imgBackground, 0, 0, 1000, 700, this);
            for (Car car : cars) {
                g.drawImage(img, car.x, car.y, carWidth, carHeight, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private Car getLastCarFromDirection(Direction startPosition, Direction direction) {
        synchronized (getCars()) {
            for (int i = getCars().size() - 1; i >= 0; i--) {
                if (getCars().get(i).getStartPosition() == startPosition && getCars().get(i).getDirection() == direction) {
                    return getCars().get(i);
                }
            }
        }
        return null;
    }

    private Car getLastCarFromDirectionInFront(Direction startPosition, Direction direction, Car car) {
        int index = getCars().indexOf(car) - 1;
        synchronized (getCars()) {
            for (int i = index; i >= 0; i--) {
                if (getCars().get(i).getStartPosition() == startPosition && getCars().get(i).getDirection() == direction) {
                    return getCars().get(i);
                }
            }
        }
        return null;
    }
}
