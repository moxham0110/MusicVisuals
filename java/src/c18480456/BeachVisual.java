package c18480456;

import ie.tudublin.Visual;
import processing.core.PApplet;
import java.util.ArrayList;

public class BeachVisual extends Visual {

    Sea mySea = new Sea();
    SeaFoam mySeaFoam = new SeaFoam();
    Sky mySky = new Sky();
    Cloud c1 = new Cloud();
    Cloud c2 = new Cloud(300);
    Cloud c3 = new Cloud(600);
    LightSource myLightSource = new LightSource();
    ArrayList<Star> stars = new ArrayList<Star>();
    Star s;

    int changeTime = 0;
    int startFlag = 0;
    boolean nightFlag = false;

    public void settings() {
        size(800, 600);

    }

    public void setup() {
        background(-4987162);

        // stars
        for (int i = 0; i < 50; i++) {

            s = new Star(random(50, 800), random(20, 280));
            stars.add(s);

        }

    }

    public void draw() {
        // render all objects
        renderShore();
        mySea.render(this);
        mySeaFoam.render(this);
        mySeaFoam.animate();
        mySky.render(this);
        

        if (nightFlag == true) {
            for (Star s : stars) {
                s.render(this);
            }

            mySky.nightMode(nightFlag);


        }else{
            mySky.nightMode(nightFlag);
        }


        myLightSource.render(this);

        // if n pressed
        if (changeTime == 1) {
            // if first run through
            if (startFlag == 0) {
                myLightSource.glide(startFlag);
                // not first run now
                startFlag = 1;
            } else {
                // changeTime to 1 if still gliding, 0 if back in place
                changeTime = myLightSource.glide(startFlag);

                if (changeTime == 0) {
                    // back in place, reset startFlag
                    startFlag = 0;
                }

            }
        }

        // clouds
        c1.render(this);
        c1.glide(this);
        c2.render(this);
        c2.glide(this);
        c3.render(this);
        c3.glide(this);

    }

    public void keyPressed() {
        println("lol");
        println(keyCode);

        if (keyCode == UP) {
            mySea.tideOut();
            mySeaFoam.tideOut();
            println(mySea.getH());
        }

        if (keyCode == DOWN) {
            mySea.tideIn();
            mySeaFoam.tideIn();
            println(mySeaFoam.getY());
        }

        if (key == 'n' || key == 'N') {
            changeTime = 1;
            nightFlag = !nightFlag;
        }
    }

    public void renderShore() {

        fill(-128);
        noStroke();
        pushMatrix();
        translate(95, 505);
        rotate(0);
        rectMode(CORNERS);
        rect(-97, -147, 716, 97);
        popMatrix();
    }

}
