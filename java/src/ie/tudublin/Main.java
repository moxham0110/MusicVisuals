package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import c18480456.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BeachVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}