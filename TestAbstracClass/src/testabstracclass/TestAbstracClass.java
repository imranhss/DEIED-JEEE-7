package testabstracclass;

import testabstracclass.abs.Circle;
import testabstracclass.abs.GeoMatry;

public class TestAbstracClass {

    public static void main(String[] args) {

        GeoMatry c = new Circle(5);

        System.out.println(c.getPerimeter());
        System.out.println(c.getArea());

    }

}
