# Project #: Project Name

* Author: Isaac Denny
* Class: CS121 Section 003
* Semester: Spring 2023

## Overview

TextBook is a console-based social media service. This application allows 
the current user to add, remove, and comment on posts, as well as display 
the list of all posts, and select a post to read with all its comments. 
Posts and comments are recorded in files, so the state of the 
TextBook can be recovered each time the program is run.


## Reflection

This assignment was a fun excercise in I/O operations, error handling,
and using interfaces to build an application. I worked on the project
from the bottom up: I started with the Post class, then moved to the
TextBook class, and finally the TextBookDriver class, testing each 
class' functionality before moving to the next task.

Writing the classes was pretty simple, and overall went well. Each of 
the tasks were straight-forward and lended themselves to clear error
handling and debugging. There were a few things that slowed development:
some of the unit tests manually deleted the posts.txt file for the textbook,
and some did not, leaving it difficult to decide what sort of functionality 
you wanted for this project. I ended up just adding a check to delete the files
manually if they existed before creating the new post (basically overwriting the file). 

I went step by step through the methods to make sure they were easy to debug,
and this was very helpful, so I do not think I would change anything about
my design process. I would probably tell myself next time to do this project
sooner...

## Compiling and Using

1. Navigate to the project directory.
2. Open a terminal and run `javac TextBookDriver.java`
3. Then run `java TextBookDriver` and follow the prompts.

## Sources used

I did not use any other sources!

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).