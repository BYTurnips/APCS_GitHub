# The Hivolts Game

## Introduction:

This project was a joint effort from Brion Ye, Caleb Tan, and Julius Kim, and it creates a fully playable game known as Hivolts, which was historically made during 1970. It is a turn-based game where the player in a lattice attempts to avoid and lure the monsters (known as mhos) into fences to destroy them, all while avoiding death as well.

## Specifications

As per all the specifications in the assignment file, the game creates a user interface via a Java applet that allows the user to play the game specified. The elements are generated according to the specifications, the player dies when touching mhos or fences, the mhos move according to the logic specified (first try to move to an empty square, then to a fence, all while moving towards the player in some fashion), all keys are implemented properly, the graphics are made more advanced via image rendering, and there are animations and instructions in the game to give cues to the user, among other features of the program. Therefore, it is clear that the program does what it should do.

## Errors

According to the project specifications there are no errors in the code. However, one aspect that could have been implemented was smooth movement for the jump, because currently jumping involves abrupt teleportation around the grid. Creating an animation for this action will make the game even more aesthetic. To implement this I might consider creating a unit vector pointing from the start to the end point, then following that unit vector for 10 frames until the character reaches the destination.

## Overview of Code

The project has many classes. Each class is listed below:
- **Main.java** - This is the class that contains the driver function for initializing the JPanels, JFrames, and the Game class itself.
- **Game.java** - This is the meat of the program. In this class almost all of the game's logic is held, including those used to generate elements, respond to keyboard input, and create animations. It implements KeyListener to allow responses to user input and implements a Timer in ActionListener to create smooth movement. The class uses encapsulation and abstraction to simplify the code structure: there is one method each for creating the background, generating the elements, responding to player movement, timing and animating the movement, passing the board state to the Mho class to determine mho movement, collision checking, and displaying an endgame screen; all are key parts of the game's function.
- **Element.java** - This class is the framework for the 3 types of objects in the game: mhos, fences, and players. It contains the move(int x, int y) function to facilitate element movement when called, as well as a static setup function to be used in getGridCoords().
- **Fence.java** - This is a subclass of Element that contains a fence image and a way of rendering it.
- **Mho.java** - This is another subclass of Element. It contains its own image and method of rendering. However, it also contains a method of determining the next move to pursue the player. This method is called by an appropriate method in Game. See the comments. 
- **Player.java** - The final class is another subclass of Element. This class contains its respective image and method of rendering, but because it is required to respond to keyboard input it contains a method for translating a KeyEvent code into a move command (to be passed to Element.move(int x, int y) to actually move the player).

## Challenges

Many challenges were faced and overcome in the making of this project. The first major obstacle that happened was that the images were not showing up on some operating systems, although the path was correct. To resolve this, a class with static final strings was created that held the absolute paths to the images, which can be toggled easily to suit the computer.

Another very important challenge encountered was that the mhos would occasionally move too far or too little as a result of the smooth movement, causing the collision checking system to fail and generally wrecking the program (i.e two elements in the same square, off-center drawings, etc.) As of right now, no real explanation has been found, but I found a solution by simply rounding the coordinates to the nearest lattice point to keep them controlled. While a real solution was not found, this solution looks identical and solved the issue at hand.

## Acknowledgements

I had a lot of help from 2 other contributors to this project: Caleb Tan and Julius Kim. As a matter of fact, we all partitioned the work in this project to make the ambitious 2-week deadline much more approachable. Caleb implemented the smooth movement animations, found and rendered the images, and created the framework for generating elements. Julius created the KeyListener and bound it to the game controls. They were a huge help to me in finishing this project.
I'd also like to acknowledge Jason and Justin (from Period 4) for giving the idea of having a scoreboard in the game. It is very helpful to the user and greatly enhanced the authenticity of the game.

## Comparison with Projected Timeline

All in all, the team adhered to the projected timeline very tightly, except in the cases of the challenges discussed above. As a result, in the last two days 2 objectives were finished simultaneously: smooth movement and mho logic. However, everything else fell into place surprisingly nicely.
