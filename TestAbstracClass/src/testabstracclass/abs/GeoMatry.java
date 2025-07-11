package testabstracclass.abs;

import java.util.Date;

public abstract class GeoMatry {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public GeoMatry() {
    }

    public GeoMatry(boolean filled, Date dateCreated) {
        this.filled = filled;
        this.dateCreated = dateCreated;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public abstract double getArea();

    public abstract double getPerimeter();

}
