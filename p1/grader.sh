#!/bin/bash
echo "Checking for README"
echo "------------------"
if [ -f "README.md" ]
then
	echo "README.md found."
elif [ -f "README.txt" ]
then
	echo "README.txt found (should be named README.md)."
elif [ -f "README" ]
then
	echo "README found (should be named README.md)."
else
    echo "Missing README.md"
fi
echo "------------------"

echo "Checking for @author tag"
echo "------------------"
grep @author MusicList.java 
echo "------------------"

echo "Compiling source files"
echo "------------------"
javac *.java
echo "------------------"

echo "==============" Test Results "=============="
if (test -f MusicList.class)
then
	for n in 1 2 3 4 5 6
	do
		echo "----------  Program Input ($n)   ----------"
		cat data/test$n
		echo "----------  Expected Output ($n) ----------"
		cat data/test$n.out
		echo "----------  Your Output ($n)     ----------"
		timeout 10 java MusicList < data/test$n
	done
fi
