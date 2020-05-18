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
    ArrayList<Drop> raindrops = new ArrayList<Drop>();
    Star s;
    Drop d;

    int changeTime = 0;
    int startFlag = 0;
    boolean nightFlag = false;
    int weatherType = -1;

    public void settings() {
        size(800, 600);

    }

    public void setup() {
        background(-4987162);

        // stars
        for (int i = 0; i < 50; i++) {

            // star x, y
            s = new Star(random(50, 800), random(20, 280));
            stars.add(s);

        }

        // raindrops
        for (int i = 0; i < 300; i++) {

            // drop x, y, length
            d = new Drop(random(0, 800), -(random(50, 700)), random(2, 6));
            raindrops.add(d);

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

        } else {
            mySky.nightMode(nightFlag);
        }

        myLightSource.render(this);

        // raining
        if (weatherType == 1) {
            for (Drop d : raindrops) {
                d.render(this);
                d.fall(this);
            }

            c1.render(this, true);
       
            c2.render(this, true);
        
            c3.render(this, true);

        }else{
            c1.render(this, false);
       
            c2.render(this, false);
        
            c3.render(this, false);
        }

       
        
        

        c1.glide(this);
        c2.glide(this);
        c3.glide(this);


        

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

        if (key == 'r' || key == 'R') {
            weatherType = weatherType * -1;
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
