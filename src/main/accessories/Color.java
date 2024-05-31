package main.accessories;

public enum Color {
    RED("red"),
    WHITE("white"),
    SILVER("silver"),
    GOLD("gold");
    private final String color;
    Color(String color) {
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public static Color getColorByName(String name) {
        for (Color color : values()) {
            if (color.getColor().equals(name)) {
                return color;
            }
        }
        throw new IllegalArgumentException("No enum found with colorname: [" + name + "]");
    }
}
