# Music Visualiser Project

Name: Patrick Moxham

Student Number: C18480456

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
This project is a scene to enjoy music to. The scene is of a shoreline. It has a beach, sea, skyline, palm tree and some weather effects. The different objects animate and interact with each other to give users a calm and relaxing sight to listen to their favourite tunes to!

# Instructions
Fairly simple to use.

Start music - Press key space.
Rainfall - Press key R.
Night Mode - Press key N.
Color Mode - Press key C.


# How it works
The scene is essentially split up into two parts. One is the sea. The other is the skyline. The shoreline is part of the scene but has no interaction with any of the objects. For simple shapes such as the stars and raindrops I coded myself. For the more complex shapes 	e.g. the sea foam, palm tree and the clouds I used Art Station tool. This is an available tool in Processing client and allowed me to create a much more detailed scene and saved alot of time.  

## Sea
The sea is split into two objects.
- Sea (Water)
- Foam

The water is a rectangle which can come in and out, creating a tide effect. This was done using if and if else statements. The height of the rectangle is incrementing and decrementing between two values. I used this throughout this assignmnet for animation. This was obviously very simple for a rectangle that just needs to move up and down in height.

The foam is made up of four arcs. Like the sea it could come in and out working in the same way but using the y axis of the arcs rather than their heights. Their heights were changed to create a ripple effect that can been seen when the sea comes onto the beach.

## Skyline

The skyline was harder to create. It is split up several different objects; sky, clouds, 






# What I am most proud of in the assignment



# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

