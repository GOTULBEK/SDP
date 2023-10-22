// interface for electric car
interface ElectricCar {
    void charge();
    void drive();
}

// interface for gas car
interface GasolineCar {
    void refuel();
    void accelerate();
}

// basic car interface
interface Car {
    void start();
    void accelerate();
    void stop();
}

// electric car adapter
class ElectricCarAdapter implements Car {
    private ElectricCar electricCar;

    public ElectricCarAdapter(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    @Override
    public void start() {
        electricCar.charge();
        electricCar.drive();
    }

    @Override
    public void accelerate() {
        electricCar.drive();
    }

    @Override
    public void stop() {
        System.out.println("Electric car stopped.");
    }
}

// gas car adapter
class GasolineCarAdapter implements Car {
    private GasolineCar gasolineCar;

    public GasolineCarAdapter(GasolineCar gasolineCar) {
        this.gasolineCar = gasolineCar;
    }

    @Override
    public void start() {
        gasolineCar.refuel();
        System.out.println("Gasoline car started.");
    }

    @Override
    public void accelerate() {
        gasolineCar.accelerate();
    }

    @Override
    public void stop() {
        System.out.println("Gasoline car stopped.");
    }
}

// Concrete Electric Car
class Tesla implements ElectricCar {
    @Override
    public void charge() {
        System.out.println("Charging Tesla.");
    }

    @Override
    public void drive() {
        System.out.println("Driving Tesla.");
    }
}

// concrete gasoline car
class Ford implements GasolineCar {
    @Override
    public void refuel() {
        System.out.println("Refueling Ford.");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Ford.");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricCar tesla = new Tesla();
        GasolineCar ford = new Ford();

        Car electricCarAdapter = new ElectricCarAdapter(tesla);
        Car gasolineCarAdapter = new GasolineCarAdapter(ford);

        System.out.println("Using Electric Car Adapter:");
        electricCarAdapter.start();
        electricCarAdapter.accelerate();
        electricCarAdapter.stop();

        System.out.println("\nUsing Gasoline Car Adapter:");
        gasolineCarAdapter.start();
        gasolineCarAdapter.accelerate();
        gasolineCarAdapter.stop();
    }
}
