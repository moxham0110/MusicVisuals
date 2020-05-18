package c18480456;

import ie.tudublin.Visual;
import processing.core.PApplet;
import java.util.ArrayList;

public class BeachVisual extends Visual {

    // lists for stars and rain
    ArrayList<Star> stars = new ArrayList<Star>();
    ArrayList<Drop> raindrops = new ArrayList<Drop>();

    // instance variables
    Sea mySea;
    SeaFoam mySeaFoam;
    Sky mySky;
    Cloud c1;
    Cloud c2;
    Cloud c3;
    LightSource myLightSource;
    Star s;
    Drop d;

    // flag variables
    int changeTime = 0;
    int startFlag = 0;
    boolean nightFlag = false;
    int weatherType = -1;
    int tideFlag = 0;
    int colorMode = -1;
    float color;

    public void settings() {
        size(800, 600);

    }

    public void setup() {

        startMinim();
        loadAudio("01 You Don't Know Me.mp3");

        // create objects
        mySea = new Sea();
        mySeaFoam = new SeaFoam();
        mySky = new Sky();
        c1 = new Cloud();
        c2 = new Cloud(300);
        c3 = new Cloud(600);
        myLightSource = new LightSource();

        // loops for stars and raindrops
        for (int i = 0; i < 50; i++) {

            // star x, y
            s = new Star(random(50, 800), random(20, 280));
            stars.add(s);

        }

        for (int i = 0; i < 200; i++) {

            // drop x, y, length
            d = new Drop(random(0, 800), -(random(100, 400)), random(2, 6));
            raindrops.add(d);

        }

    }

    public void draw() {

        render();

        animation();

    }

    public void render() {
        // render all objects
        renderShore();
        mySea.render(this);
        mySeaFoam.render(this);
        mySeaFoam.animate();
        mySky.render(this);

        //if at night
        if (nightFlag == true) {

            // stars rendered with normal or with color mode on
            if (colorMode == -1) {
                for (Star s : stars) {
                    s.render(this, false, 0);
                    s.twinkleStar();
                }
            } else { // if on
                for (Star s : stars) {
                    calculateAverageAmplitude();
                    lights();
                    color = map(getSmoothedAmplitude(), 0, 1, 0, 255);

                    s.render(this, true, color);
                    s.twinkleStar();
                }
            }

            mySky.nightMode(nightFlag);

        } else {
            mySky.nightMode(nightFlag);
        }

        myLightSource.render(this);

        // raining
        if (weatherType == 1) {

            // if color mode off
            if (colorMode == -1) {
                for (Drop d : raindrops) {
                    d.render(this, false, 0);
                }
            } else { // if on
                for (Drop d : raindrops) {
                    calculateAverageAmplitude();
                    color = map(getSmoothedAmplitude(), 0, 1, 0, 255);

                    d.render(this, true, color);
                }
            }

            c1.render(this, true);

            c2.render(this, true);

            c3.render(this, true);

        } else {
            c1.render(this, false);

            c2.render(this, false);

            c3.render(this, false);
        }

        renderPalmTree();
    }

    public void animation() {
        // clouds
        c1.glide(this);
        c2.glide(this);
        c3.glide(this);

        // raindrops
        for (Drop d : raindrops) {

            d.fall(this);
        }

        // sea tide
        if (tideFlag == 1) {
            mySeaFoam.tideOut();
            if (mySea.tideOut() == 1) {
                tideFlag = 0;
            }
        } else {
            mySeaFoam.tideIn();
            if (mySea.tideIn() == 1) {
                tideFlag = 1;
            }
        }

        // changing from night to day
        // if time changed
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

        if (key == 'n' || key == 'N') {

            // wait till back in place
            if (changeTime == 0) {

                // change time begins for floating
                changeTime = 1;

                nightFlag = !nightFlag;
            }
        }

        // toggle on/off
        if (key == 'r' || key == 'R') {
            weatherType = weatherType * -1;
        }

        if (key == 'c' || key == 'C') {
            colorMode = colorMode * -1;
        }

        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

        }
    }

    // non-interactive drawings, shore and palm tree
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

    public void renderPalmTree() {
        fill(-6730496);
        strokeWeight(2);
        stroke(-16777216);
        pushMatrix();
        translate((float) 721.1044, (float) 392.27643);
        rotate((float) 1.6794362);
        arc(0, 0, (float) 357.44632, (float) 59.265434, (float) 3.1286957, (float) 6.2831855, PIE);
        popMatrix();

        fill(-6730496);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        pushMatrix();
        translate((float) 723.13684, (float) 346.20596);
        rotate((float) 1.6256438);
        arc(0, 0, (float) 282.16833, (float) 69.75362, (float) 3.1286957, (float) 6.2831855, PIE);
        popMatrix();

        fill(-6730496);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        pushMatrix();
        translate((float) 717.7168, (float) 547.4255);
        rotate((float) 1.7041376);
        rectMode(CORNERS);
        rect((float) -161.03152, (float) -14.656711, (float) 28.592052, (float) 14.625381);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 681.1315, (float) 273.03525);
        rotate((float) -0.4915259);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 685.87396, (float) 178.18428);
        rotate((float) -5.435454);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 662.83875, (float) 226.28728);
        rotate((float) -6.1913896);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 807.1477, (float) 206.63957);
        rotate((float) -0.41941214);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 773.9499, (float) 160.5691);
        rotate((float) -7.3827477);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 727.2019, (float) 294.03796, (float) 760.3997, (float) 294.03796);
        strokeWeight((float) 2.0);
        stroke((float) -16777216);
        line((float) 727.8794, (float) 263.55014, (float) 753.6247, (float) 261.5176);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 725.1694, (float) 323.17075, (float) 761.75476, (float) 323.84824);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 702.13416, (float) 542.6829, (float) 736.0095, (float) 547.4255);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 710.2642, (float) 510.16263, (float) 737.3645, (float) 513.5502);
        strokeWeight((float) 2.0);
        stroke((float) -16777216);
        line((float) 723.13684, (float) 353.65854, (float) 757.0122, (float) 357.7236);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 719.7493, (float) 428.1843, (float) 748.88214, (float) 428.86182);
        strokeWeight((float) 2.0);
        stroke(-16777216);
        line((float) 742.78455, (float) 469.5122, (float) 716.3618, (float) 466.12466);
        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 744.1396, (float) 142.27643);
        rotate((float) -7.72146);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 662.16125, (float) 198.50949);
        rotate((float) -12.170969);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 671.64636, (float) 252.03253);
        rotate((float) -12.717636);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();

        fill(-15053542);
        strokeWeight((float) 2.0);
        stroke(-16764160);
        pushMatrix();
        translate((float) 799.01764, (float) 184.95935);
        rotate((float) -13.264332);
        arc(0, 0, (float) 176.63586, (float) 78.88227, (float) 3.0540974, (float) 6.1660767, PIE);
        popMatrix();
    }

}
