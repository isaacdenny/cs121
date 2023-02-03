# Project 0: Traffic Animation

* Author: Isaac Denny
* Class: CS121 Section 3
* Semester: Spring 2023

## Overview

This Java application displays a scene in space with a spaceship animating left to right.
It features some planets, randomly generated stars, an alien, and a famous space cliche.

## Reflection

There were two parts of this project that were more difficult than the rest: scaling objects
and randomly generating stars on the first frame. Getting the scaling of each object correct 
just took some time, but the effort paid off and I am now confident in my use of these techniques.

The randomly generated stars were extremely satisfying to figure out: the only difficult part was
finding a way to store their positions and then draw them at that same position every frame after
the first. I did this with a two dimensional array, storing either a 0 or a 1 at each coordinate of
the screen. Thanks to the Random class, each coordinate has a 25% chance to be a star, determined
on the first frame. A boolean simply keeps track of whether that code has run once or not.

- What worked well and what was a struggle?
  - The rings around the planets worked well and were easy to 
    implement, while the star generation took some time.

- What concepts still aren't quite clear?
  - I'm pretty clear on everything!

- What techniques did you use to make your code easy to debug and modify?
  - I created a Planet class to abstract away some of the planet's 
    properties that I had to use and reuse

- What would you change about your design process?
  - I would change my order of operations. I focused too much on getting 
    the project done quick that it eventually led me to have to refactor some
    of the code later.

- If you could go back in time, what would you tell yourself about doing this project?
  - Learn more about the Jframes.

## Compiling and Using

To compile, execute the following command in the main project directory:
```
$ javac TrafficAnimation.java
```
Run the compiled class with the command:
```
$ java TrafficAnimation
```

You should then see a window pop up with the playing animation.

## Sources used

I did not use any external sources for this project.

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
