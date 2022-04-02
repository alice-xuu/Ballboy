package ballboy.model;

public class LevelData {

    private final double width;
    private final double height;
    private final double floorHeight;

    public LevelData(double width, double height, double floorHeight) {
        this.width = width;
        this.height = height;
        this.floorHeight = floorHeight;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getFloorHeight() {
        return floorHeight;
    }


}
