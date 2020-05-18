package c18480456;

import processing.core.PApplet;

public class Sea {
    private float x;
    private float y;
    private float w;
    private float h;

    public Sea(){
        this(-97, -57, 716, 97);
    }

    public Sea(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void render(PApplet pa){
        pa.fill(-10059546);
        pa.noStroke();
        pa.pushMatrix();
        pa.translate(93, 355);
        pa.rotate(0);
        pa.rectMode(pa.CORNERS);
        pa.rect(x, y, w, h);
        pa.popMatrix();
           
        
    }
    
    public void tideIn(){
        if(h < 120)
        {
            h = h + (float)5;
        }
    }

    public void tideOut(){
        if(h > 60)
        {
            h -= 5;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    

    
}