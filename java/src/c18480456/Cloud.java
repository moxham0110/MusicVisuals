package c18480456;

import processing.core.PApplet;

public class Cloud {

    private float x;
    private float y;

    public Cloud(float x) {
        this.x = x;
        this.y = 10;
    }

    public Cloud() {
        this(-100);
    }

    public void render(PApplet pa) {

       
            pa.fill(-1);
            pa.noStroke();
            pa.pushMatrix();
            pa.translate((float) 189.93904, (float) 109.0786);
            pa.rotate((float) 0.0);
            pa.arc(x, y, (float) 92.94444, (float) 75.80816, (float) 3.125969, (float) 6.2831855, pa.PIE);
            pa.popMatrix();

            pa.fill(-1);
            pa.noStroke();
            pa.pushMatrix();
            pa.translate((float) 252.94717, (float) 108.401085);
            pa.rotate((float) 0.0);
            pa.arc(x, y, (float) 92.94444, (float) 76.471275, (float) 3.125969, (float) 6.2831855, pa.PIE);
            pa.popMatrix();

            pa.fill(-1);
            pa.noStroke();
            pa.pushMatrix();
            pa.translate((float) 244.13957, (float) 72.493225);
            pa.rotate((float) 0.0);
            pa.ellipse(x, y, (float) 77.28331, (float) 48.780487);
            pa.popMatrix();

            pa.fill(-1);
            pa.noStroke();
            pa.pushMatrix();
            pa.translate((float) 202.13416, (float) 77.913284);
            pa.rotate((float) 0.0);
            pa.ellipse(x, y, (float) 77.28331, (float) 48.780487);
            pa.popMatrix();

        

    }

    public void glide(PApplet pa) {
        if (x > 700) {
            //reset
            x = -300;
            //clouds be at slight different heights
            y = pa.random(5, 50);
        }
        x += 0.5;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }


}