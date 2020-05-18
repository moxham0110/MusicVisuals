package c18480456;

import processing.core.PApplet;

public class Star {
    private float x1;
    private float y1;
    private float x2 = x1 - 5;
    private float y2 = y1 + 10;
    private float x3 = x1 + 5;
    private float y3 = y1 + 10;
    private float t = 0;

    int flag = 0;
    

    public Star(){
        this(0 , 0);
    }


    public void render(PApplet pa){ 

       
        pa.stroke(255);
        pa.strokeWeight(t);
        
        pa.fill(-1);
        pa.triangle(x1, y1, x2, y2, x3, y3);
        pa.triangle(x1, y1+12, x2, y2 - 6, x3, y3 - 6);  


    }

    public void twinkleStar() {

        if (flag == 0) {
            t += 0.25;
            
            if (t == 2) {
                flag = 1;
            }

        } else {

            t -= 0.25;
            

            if (t == 0) {
                flag = 0;
            }

        }
    }

    


    public Star(float x1, float y1) {
        this.x1 = x1;
        this.y1 = y1;

        x2 = x1 - 5;
        y2 = y1 + 10;
        x3 = x1 + 5;
        y3 = y1 + 10;

    }
 
}