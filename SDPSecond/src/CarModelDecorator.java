public class CarModelDecorator extends VehicleDecorator {
    public CarModelDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.println("...a Nissan!");
    }
}
