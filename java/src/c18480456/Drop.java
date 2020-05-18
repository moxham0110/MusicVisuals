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

        if(y > 800){
            y = -(pa.random(50, 600));
            System.out.println(y);
        }
    }

    public void render(PApplet pa) {

        pa.strokeWeight(2);
        pa.stroke(20, 83, 216);
        pa.line(x, y, x, y + length);

    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}