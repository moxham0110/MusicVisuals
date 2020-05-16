package c18480456;

import ie.tudublin.Visual;
import processing.core.PApplet;

public class BeachVisual extends Visual {

    Sea mySea = new Sea();
    SeaFoam mySeaFoam = new SeaFoam();


    public void settings() {
        size(800, 600);

    }

    public void setup() {
        background(-4987162);

    }

    public void draw() {
        renderShore();
        mySea.render(this);
        mySeaFoam.render(this);
        mySeaFoam.animate();
       
    }
    
    
    public void keyPressed(){
        println("lol");
        println(keyCode);
        
        if(keyCode == UP){
            mySea.tideOut();
            mySeaFoam.tideOut();
            println(mySea.getH());
        }

        if(keyCode == DOWN){
            mySea.tideIn();
            mySeaFoam.tideIn();
            println(mySeaFoam.getY());
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
