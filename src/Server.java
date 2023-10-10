public class Server extends Computer {
    private String ram; // creating a new 3 strings for storing computers characteristcs
    private String hdd;
    private String cpu;

    // just a constructor that taking 3 properties and returning value
    public Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }
    // overriding methods to returning values
    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
