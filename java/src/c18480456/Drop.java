package c18480456;

import processing.core.PApplet;


public class Drop {

   
    private float x;
    private float y;
    private float length;
    

    public Drop(float x, float y, float length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public Drop() {
        this(0, 0, 0);
    }

    public void fall(PApplet pa) {
    
        y+=10;
        //reset
        if(y > 800){
            //fall from different heights
            y = -(pa.random(50, 600));
        }
    }

    public void render(PApplet pa, boolean colorMode, float color) {

         //a drop is a single line
        if(colorMode == false){
            pa.strokeWeight(pa.random(1, 3));
            pa.stroke(20, 83, 216);
            pa.line(x, y, x, y + length);
        }else{
            pa.colorMode(pa.HSB);
            pa.strokeWeight(pa.random(1, 3));
            pa.stroke(color, 255, 255);
            pa.line(x, y, x, y + length);
            pa.colorMode(pa.RGB);
        }

    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}