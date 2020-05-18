package c18480456;

import processing.core.PApplet;

public class Sky {
    private float x;
    private float y;
    private int colorCount;

    public Sky() {
        this(0, 0);
    }

    public Sky(float x, float y) {
        this.x = x;
        this.y = y;

        colorCount = 0;
    }

    public void render(PApplet pa) {

        
        //map color range from light to dark blue
        pa.fill( pa.map(colorCount, 0, 100, 162, 10)   , pa.map(colorCount, 0, 100, 180, 37),   pa.map(colorCount, 0, 100, 250, 93));
    
        //fill(10, 37, 93);

        pa.noStroke();
        pa.pushMatrix();
        pa.translate((float)303.76016, (float)153.79404);
        pa.rotate((float)0.0043873787);
        pa.rectMode(pa.CORNERS);
        pa.rect((float)-302.24396, (float)-155.8398, (float)500.7435, (float)166.03896);
        pa.popMatrix();


    }

    public void nightMode(boolean nightFlag){
        
        //change to night
       if(colorCount < 100 && nightFlag == true){
            colorCount++;
       }
       //change to day

       if(colorCount > 0 && nightFlag == false){
           colorCount--;
       }
    }

  
}