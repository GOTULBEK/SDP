public class UsageExample {
    public static void main(String[] args) {
        Shape shape = new Circle();

        shape.draw(); // Drawing a circle...

        shape = new RedShapeDecorator(shape);

        shape.draw(); // Drawing a circle...in red!

        shape = new BorderShapeDecorator(shape);

        shape.draw(); // Drawing a circle...in red!..with a border!
    }
}
