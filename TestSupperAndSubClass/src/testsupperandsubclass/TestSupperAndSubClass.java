package testsupperandsubclass;

import testsupperandsubclass.geomatry.Circle;
import testsupperandsubclass.geomatry.Rectngle;

public class TestSupperAndSubClass {

    public static void main(String[] args) {

        Circle circle = new Circle(5);

        Circle circle1 = new Circle();
        circle1.radius = 7;

        Rectngle rectngle = new Rectngle();

        rectngle.height = 5;
        rectngle.width = 6;

        Rectngle rectngle1 = new Rectngle(6, 7);

        System.out.println("Circle ");
        System.out.println(circle.getArea() + " " + circle.getPerimiter());

        System.out.println("Circle 1 ");
        System.out.println(circle1.getArea() + " " + circle1.getPerimiter());

        System.out.println("Rectngle  ");
        System.out.println(rectngle.getArea() + " " + rectngle.getPerimiter());

        System.out.println("Rectngle  1");
        System.out.println(rectngle1.getArea() + " " + rectngle1.getPerimiter());

    }

}
