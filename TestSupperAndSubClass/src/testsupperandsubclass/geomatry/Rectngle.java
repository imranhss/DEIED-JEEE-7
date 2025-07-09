/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testsupperandsubclass.geomatry;

/**
 *
 * @author WADA
 */
public class Rectngle extends GeoMatry{
    
    public  double  width;
    public  double  height;

    public Rectngle() {
    }

    public Rectngle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimiter() {
        return 2 *(height+width);
    }

    @Override
    public double getArea() {
        return height * width;
    }
    
    
    
    
    
}
