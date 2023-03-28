package code;

public class Downcast {

    public static void main(String[] args) {

        Transportation bike, car;
        car = new Car();
        bike = new Bike();

        // car.startEngine(); // error: cannot find method startEngine()
        ((Car) car).startEngine(); // ok
        // ((Car) bike).startEngine(); // runtime error: cannot cast Bike to Car

    }

}

class Transportation {

}

class Car extends Transportation {

    public void startEngine() {
        System.out.println("Car engine started");
    }
}

class Bike extends Transportation {

}