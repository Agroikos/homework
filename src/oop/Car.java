package oop;

public class Car {
    private float fuelLevel;
    private byte gear;
    private float speed;
    private Color color;



    public Car() {
    }

    public Car(float fuelLevel, byte gear, float speed, Color color) {
        this.fuelLevel = fuelLevel;
        this.gear = gear;
        this.speed = speed;
        this.color = color;
    }

    public float getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(float fuelLevel) throws IllegalArgumentException {
        //this.fuelLevel se refera la field-ul fuelLevel din obiectul curent
        //in timp ce fuelLevel fara this se refera la parametrul metodei (sau variabila locala
        // cea mai apropiata cu numele respectiv)
        if (fuelLevel <=0 || fuelLevel > 100) throw new IllegalArgumentException("FuelLevel must be between 0 and 100");

        this.fuelLevel = fuelLevel;
    }

    public byte getGear() {
        return gear;
    }

    public void setGear(byte gear) {
        this.gear = gear;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        if (gear < 1 || gear > 10) {
            throw new IllegalArgumentException("Gear must be between 0-10!!");
        }
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
