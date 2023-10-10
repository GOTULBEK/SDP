public class PC extends Computer {
    private String ram; //Create strings that will cover computer parts
    private String hdd;
    private String cpu;

    // Constructor that will make those strings accessible
    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }
    // Methods to return those values
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
