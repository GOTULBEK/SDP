
public abstract class Computer {
    public abstract String getRam(); // method to get the computers RAM

    public abstract String getHDD(); // method to get the computers HDD
    public abstract String getCPU(); // method to get the computers CPU

    @Override
    public String toString() {
        return "Ram= " + this.getRam() + ", HDD = " + this.getHDD() + "CPU =" + this.getCPU();
    } // returning computers characteristics
}
