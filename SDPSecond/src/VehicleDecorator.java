public abstract class VehicleDecorator implements Vehicle {
    protected Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void ride() {
        vehicle.ride();
    }
}
