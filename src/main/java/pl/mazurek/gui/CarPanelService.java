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
        cars = new CopyOnWriteArrayList<>();;
        this.simulationApplication = simulationApplication;
    }


    public void addCar(int startX, int startY, Direction startPosition, Direction direction) {
        cars.add(new Car(startX, startY, startPosition, direction));
        repaint();
    }

    public void moveCars() {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if(car.getDirection() == Direction.NORTH && (simulationApplication.getIntersectionService().intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN || car.y < 450)){
                car.y -= 2 * 3;
                if(car.y < 450){
                    car.setMoving(true);
                }
            } else if (car.getDirection() == Direction.SOUTH && (simulationApplication.getIntersectionService().intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN || car.y > 200)) {
                car.y += 2 * 3;
                if(car.y > 200){
                    car.setMoving(true);
                }
            } else if (car.getDirection() == Direction.WEST && (simulationApplication.getIntersectionService().intersection.getLightWestToEastAndEastToWest() == Light.GREEN || car.x < 780)) {
                car.x -= 2 * 3;
                if(car.x < 780){
                    car.setMoving(true);
                }
            } else if (car.getDirection() == Direction.EAST && (simulationApplication.getIntersectionService().intersection.getLightWestToEastAndEastToWest() == Light.GREEN || car.x > 250)) {
                car.x += 2 * 3;
                if(car.x > 250){
                    car.setMoving(true);
                }
            }

            if(car.getStartPosition() == Direction.SOUTH && car.getDirection() == Direction.NORTH && car.y < 0){
                cars.remove(car);
            }
            if(car.getStartPosition() == Direction.NORTH && car.getDirection() == Direction.SOUTH && car.y > 700){
                cars.remove(car);
            }
            if(car.getStartPosition() == Direction.WEST && car.getDirection() == Direction.EAST && car.x > 1000){
                cars.remove(car);
            }
            if(car.getStartPosition() == Direction.EAST && car.getDirection() == Direction.WEST && car.x < 0){
                cars.remove(car);
            }
        }
        repaint();
    }



    public int howManyCarsAreWaitingFromDirection(Direction startDirection){
        int counter = 0;
        for (Car car : cars) {
            if (car.getStartPosition().equals(startDirection) && !car.isMoving()){
                counter++;
            }
        }
        return counter;
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
}
