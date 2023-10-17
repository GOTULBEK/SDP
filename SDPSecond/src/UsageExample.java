public class UsageExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();

        vehicle.ride();

        vehicle = new CarModelDecorator(vehicle);

        vehicle.ride();

        vehicle = new CarColorDecorator(vehicle);

        vehicle.ride();
    }
}
