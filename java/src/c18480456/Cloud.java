package c18480456;

import processing.core.PApplet;

public class Cloud {

    private float x;
    private float y;
    private int colorCount;

    public Cloud(float x) {
        this.x = x;
        this.y = 10;
        colorCount = 255;
    }

    public Cloud() {
        this(-100);
    }

    public void render(PApplet pa, boolean rainMode) {


        //grey or white clouds depending on weather
        if (rainMode == true) {
            if (colorCount > 100) {
                colorCount--;
            }
            pa.fill(colorCount);
        } else {

            if (colorCount < 255) {
                colorCount++;
            }
            pa.fill(colorCount);
        }

        //2 arcs and 2 ellipse make up a cloud
        pa.noStroke();
        pa.pushMatrix();
        pa.translate((float) 189.93904, (float) 109.0786);
        pa.rotate((float) 0.0);
        pa.arc(x, y, (float) 92.94444, (float) 75.80816, (float) 3.125969, (float) 6.2831855, pa.PIE);
        pa.popMatrix();

        pa.noStroke();
        pa.pushMatrix();
        pa.translate((float) 252.94717, (float) 108.401085);
        pa.rotate((float) 0.0);
        pa.arc(x, y, (float) 92.94444, (float) 76.471275, (float) 3.125969, (float) 6.2831855, pa.PIE);
        pa.popMatrix();

        pa.noStroke();
        pa.pushMatrix();
        pa.translate((float) 244.13957, (float) 72.493225);
        pa.rotate((float) 0.0);
        pa.ellipse(x, y, (float) 77.28331, (float) 48.780487);
        pa.popMatrix();

        pa.noStroke();
        pa.pushMatrix();
        pa.translate((float) 202.13416, (float) 77.913284);
        pa.rotate((float) 0.0);
        pa.ellipse(x, y, (float) 77.28331, (float) 48.780487);
        pa.popMatrix();

    }

    public void glide(PApplet pa) {
        if (x > 700) {
            // reset
            x = -300;
            // clouds be at slight different heights
            y = pa.random(20, 60);
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