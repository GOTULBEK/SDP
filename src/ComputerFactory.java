
public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }

    //  Return specific values from PC or Server (ram, hhd, cpu and etc)
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }
        return null;
    }
}
