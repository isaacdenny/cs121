# Project #: Project Name

* Author: Isaac Denny
* Class: CS121 Section 003
* Semester: Spring 2022

## Overview

This program implements a jukebox-like menu UI to allow the user to perform
various operations on a catalog of music titles. The program starts by displaying
the menu UI to show a list of possible commands (Load, Searh, Analyze, Print, and
Quit).

## Reflection

This project was fun and required most of what we learned to be applied. I enjoyed it.
- What worked well and what was a struggle?
    Wrapping the whole program in a while loop that only continued if the user input was
    not a "q" worked well, allowing me to use the switch statement just for more complex
    operations on the catalog. This way the "quit" operation is scoped (in a way) to
    the program rather than the catalog actions. Writing the code all inside main was
    a struggle mentally.
- What concepts still aren't quite clear?
    I think I've got it!
- What techniques did you use to make your code easy to debug and modify?
    I made sure my formatting was consistent and readable.
- What would you change about your design process?
    I would just change how I caught exceptions so that the exception message is specific
    to the type of exception.
- If you could go back in time, what would you tell yourself about doing this project?
    I would say get Panda Express before starting.

## Compiling and Using

To compile, execute the following command in the main project directory:
```
$ javac JukeboxHero.java
```
Run the compiled class with the command:
```
$ java JukeboxHero
```

You should then see the program menu in the console.

## Sources used

I did not use any outside sources for this project.

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).