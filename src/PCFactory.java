public class PCFactory implements ComputerAbstractFactory {
    //This class is the same as PC class, but it implements abstract class
    //Create strings that will cover computer parts
    private String ram;
    private String hdd;
    private String cpu;
    // Constructor that will make those strings accessible
    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    // Methods to return those values
    @Override
    public Computer createComputer() {
        return new PC(ram,hdd,cpu);
    }
}