public class CarColorDecorator extends VehicleDecorator {
    public CarColorDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.println("...in red!");
    }
}
