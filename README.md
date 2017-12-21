# Saturn Explorer

### Prerequisites

You need to install the following software to run this project:

```
- The latest version of IntelliJIDEA.
- Scala plugin for the IntelliJIDEA IDE (can be downloaded from Preferences | PlugIns).
- JDK version 1.8
- Scala 2.12.4
   Scala can be downloaded from https://www.scala-lang.org or with the home brew command:
 $ brew install scala

```

### Opening the project

```
1.- Open IntelliJIDEA and do one of the following:
    -On the welcome screen, click Open.
    -On the main menu, choose File | Open.
2.- In the Open Project dialog box, navigate to the SaturnExplorer project file and select it.
```



### Running the program

```
1.- To run the program click the green icon located in the left gutter.
2.- Use the IntelliJIDEA Terminal to enter the size of the map, the starting location of the robot and the instructions.

The first line of input is the upper-right coordinates of the landing area, the lower-left coordinates are assumed to be 0,0.
The second line is the starting position of the robot.
The third line is a series of characters representing the instructions given to the robot:
 R - ROTATES THE ROBOT TO THE RIGHT.
 L - ROTATES THE ROBOT TO THE LEFT.
 M - MOVES THE ROBOT TO ITS CURRENT FACING DIRECTION.

For example:

Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E

```

