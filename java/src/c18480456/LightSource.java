package c18480456;

import processing.core.PApplet;

public class LightSource {
    private float x;
    private boolean nightMode;

    public LightSource(float x) {
        this.x = x;
        nightMode = false;
    }

    public LightSource() {
        this(0);
    }

    public void render(PApplet pa) {

        if (nightMode == false) {
            pa.fill(-179);
            pa.strokeWeight(10);
            pa.stroke(-128);
            pa.pushMatrix();
            pa.translate((float) 207.55421, (float) 69.10569);
            pa.rotate(0);
            pa.ellipse(x, 0, (float) 93.535225, (float) 93.535225);
            pa.popMatrix();
        } else {
            pa.fill(-1644826);
            pa.strokeWeight(10);
            pa.stroke(-1);
            pa.pushMatrix();
            pa.translate((float)207.55421, (float)69.10569);
            pa.rotate(0);
            pa.ellipse(x, 0, (float)93.535225, (float)93.535225);
            pa.popMatrix();
        }

    }

    public int glide(int startFlag) {
        // if first run through
        if (startFlag == 0) {
            // begins gliding
            x = 1;
        }

        // resets if offscreen
        if (x > 700) {
            x = -200;
            nightMode = !nightMode;
        }

        // glides till back in place
        if (x != 0) {
            x += 5;
        } else {
            // now in place, resets changeTime
            return 0;
        }

        // changeTime still in progress
        return 1;

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}