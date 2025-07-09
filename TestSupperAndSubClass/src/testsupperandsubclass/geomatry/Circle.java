
package testsupperandsubclass.geomatry;


public class Circle extends GeoMatry{
    
    public  double  radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimiter() {
        
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        
        return Math.PI * Math.pow(radius, 2);
    }
    
    
    
}
