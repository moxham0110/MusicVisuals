package c18480456;

import processing.core.PApplet;

public class SeaFoam {

    private float h;
    private float y;


   //for animation between two values
    int flag = 0;
   
    public SeaFoam(float h, float y) {
        this.h = h;
        this.y = y;
    }

    public SeaFoam() {
        this(41, 0);
    }

    //similar to sea
    public void tideIn() {
        if (y > -30) {
            y -= .25;
        }
    }

    public void tideOut() {
        if (y < 35) {
            y += .25;
        }
    }

    public void render(PApplet pa) {
        // tide 
        //made up of 4 arcs
        pa.fill(-1);
        pa.strokeWeight((float) 10.0);
        pa.stroke(-1);
        pa.pushMatrix();
        pa.translate((float) 103.020996, (float) 450.58887);
        pa.rotate((float) 3.1304598);
        pa.arc(0, y, (float) 230.4287, h, (float) 2.971985, (float) 6.6241236, pa.PIE);
        pa.popMatrix();

        pa.fill(-1);
        pa.strokeWeight((float) 10.0);
        pa.stroke(-1);
        pa.pushMatrix();
        pa.translate((float) 317.39206, (float) 450.58887);
        pa.rotate((float) 6.2643857);
        pa.arc(0, -y, (float) 230.4287, h, (float) 2.971985, (float) 6.6241236, pa.PIE);
        pa.popMatrix();

        pa.fill(-1);
        pa.strokeWeight((float) 10.0);
        pa.stroke(-1);
        pa.pushMatrix();
        pa.translate((float) 529.0323, (float) 447.858);
        pa.rotate((float) 3.13046);
        pa.arc(0, y, (float) 230.4287, h, (float) 2.971985, (float) 6.6241236, pa.PIE);
        pa.popMatrix();

        pa.fill(-1);
        pa.strokeWeight((float) 10.0);
        pa.stroke(-1);
        pa.pushMatrix();
        pa.translate((float) 731.11456, (float) 451.95428);
        pa.rotate((float) 6.2643857);
        pa.arc(0, -y, (float) 230.4287, h, (float) 2.971985, (float) 6.6241236, pa.PIE);
        pa.popMatrix();


    }

    public void animate() {

        //provides a ripple effect by incrementing/decrementing the height of the arcs
        if (flag == 0) {
            h -= 0.25;

            if (h == 20) {
                flag = 1;
            }

        } else {

            h += 0.25;
            

            if (h == 41) {
                flag = 0;
            }

        }
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}