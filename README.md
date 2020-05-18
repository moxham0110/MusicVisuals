# Music Visualiser Project

Name: Patrick Moxham

Student Number: C18480456

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

![An image](images/p2.png)

![An image](images/p1.png)

## Sea
The sea is split into two objects.
- Sea (Water)
- Foam

The water is a rectangle which can come in and out, creating a tide effect. This was done using if and if else statements. The height of the rectangle is incrementing and decrementing between two values. I used this throughout this assignmnet for animation. This was obviously very simple for a rectangle that just needs to move up and down in height.

The foam is made up of four arcs. Like the sea it could come in and out working in the same way but using the y axis of the arcs rather than their heights. Their heights were changed to create a ripple effect that can been seen when the sea comes onto the beach.

## Skyline

The skyline was harder to create. It is split up several different objects; sky, clouds, and sun/moon which I used one object for LightSource. 

The clouds are made up of two arcs and 2 elipses drawn in Art Station. They float across the screen by incrementing their x axis and then reset once off screen. When they reset I give them slightly varied random heights. When rain mode is toggled, the clouds will darken grey/ whiten. There are three clouds in the program.

The sky somewhat like the sea is a rectangle, it doesnt need to move like the sea just change color when in night mode. Fairly easy to implement with RGB colors and mapping the range between a dark blue and light blue.

A star is made up of two triangles with one upside down. Stars are created and stored in an ArrayList object and have a twinkle function which incremenets and decrements their stroke weight between two values.

The LightSource object was the hardest object to work around. I think if I did it again I'd just have a sun and moon in seperate objects. They both are the same size and stay in the same position. When a user changes to night/day the light source glides off to the right and then when off-screen changes to its counterpart. From there it glides back into position. 

Rain drops are the last object. A drop is a small thick line that has a fall method, much like the clouds it resets when off-screen back to the top. An ArrayList object is used to store these drop call raindrops.

## Modes

There are three modes available:
- Rain
- Color
- Night

Rain - Drops use their fall method and clouds change to grey.

Night - The sun switches with the moon, the sky darkens and the stars come out.

Color -  This makes the stars and raindrops change color to the beat of the music. This is a bonus mode and doesn't really fit the theme but I wanted to implement some sort of sound interaction in the scene.


# What I am most proud of in the assignment
Nothing stands out massively to me but my favourite part of this assignment is the night mode when it transition fading colors, gliding moon/sun and stars appearing and twinkling. I also think the color mode is fun!


# Links

## Youtube
[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://youtu.be/Yd1gaDV8hJM)

## Github
(https://github.com/moxham0110/MusicVisuals)






