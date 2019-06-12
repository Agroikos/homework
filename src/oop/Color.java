package oop;

public class Color {
    private String name;
    private boolean metallic;

    public Color() {
    }

    public Color(String name, boolean metallic) {
        this.name = name;
        this.metallic = metallic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMetallic() {
        return metallic;
    }

    public void setMetallic(boolean metallic) {
        this.metallic = metallic;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", metallic=" + metallic +
                '}';
    }
}
