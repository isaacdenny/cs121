# Project #: Project Name

* Author: Isaac Denny
* Class: CS121 Section 003
* Semester: Spring 2023

## Overview

The Tic Tac Toe application creates a Tic Tac Toe game with all the functionality
needed to play, including taking turns, choosing spaces, win/lose logic, and a 
move history.

## Reflection

The project was a good exercise in working with oversized arrays and making
sure you did not get any index-out-of-bounds errors. The writing of this program
was tedious and making sure every edge case was handled was a headache, but I figured
it out in the end. I had some hiccups in my logic in some areas, and the weird tester
logging format made it difficult to discern where my issue was. The techniques I used
to make sure I was debugging well were using both the GUI and the provided 
TicTacToeTester class to test a scenario and see what goes wrong and where.

Were I to do this project again, I would have focused more on refactoring my code
to be more readable and consistent across the TicTacToeGame class. A couple times I
used 'this.classAttribute' to access a class attribute, and other times I did not, so 
the code isn't super consistent. 

## Compiling and Using

1. Navigate to the project directory
2. Compile .java files with `javac TicTacToeGame.java`
3. Run the Tester class with `java Tester` or the GUI with `java TicTacToeGUI`

## Sources used

I didn't use any outside sources.

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).