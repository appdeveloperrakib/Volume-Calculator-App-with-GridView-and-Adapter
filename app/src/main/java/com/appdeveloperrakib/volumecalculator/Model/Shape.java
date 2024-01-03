package com.appdeveloperrakib.volumecalculator.Model;


//This class is acting as : "Model Class "
//it represents the data structure of individual data items
// that your adapter is going to display
public class Shape {

    int shapeImage;
    String shapeName;

    public Shape(int shapeImage, String shapeName) {
        this.shapeImage = shapeImage;
        this.shapeName = shapeName;
    }

    public int getShapeImage() {
        return shapeImage;
    }

    public void setShapeImage(int shapeImage) {
        this.shapeImage = shapeImage;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}
