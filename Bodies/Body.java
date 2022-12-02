import java.awt.*;

public class Body {
    private String modelName;
    private Color color;
    private int nrDoors;
    private double damage;


    public Body(String modelName, Color color, int nrDoors){
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.damage = 0.0; // Bodies undamaged by default, percentage
    }

    //------------------------------------- Getters ----------------------------------------//
    public int getNrDoors() {
        return nrDoors;
    }
    
    public Color getColor() {
        return color;
    }
    
    public double getDamage() {
        return damage;
    }
    
    public String getModelName() {
        return modelName;
    }

    //------------------------------------- Setters ----------------------------------------//
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    @Override
    public String toString() {
        return "Body [modelName=" + modelName + ", color=" + color + "]";
    }


}
