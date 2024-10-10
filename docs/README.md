## LDTS_0301 - MAZE RUNNER

## Game Description
This game is inspired by the movie "Maze Runner". Try to escape this maze, scout it during daytime and survive the monsters during the darkness of the night.

This project was developed by *David Ranito* (*up202206312*@fe.up.pt), *Pedro João* (*up202204962*@fe.up.pt) and *Tiago Torres* (*up202208938*@fe.up.pt) for LDTS 2023⁄24.


### IMPLEMENTED FEATURES

The following features were implemented:

- **Walk** - The game character moves using the keys 'w', 'a', 's', 'd', turning in the direction in which is moving.
- **Fields of view** - The field of view of the player is limited. During nighttime decreases and gets darker.
- **Monsters** - At night, monsters are spawned inside the maze.
- **Small monster** - Monster that is usually closer to the center of the maze, walks normally.
- **Big monster** - Monster that is usually on the outskirts of the maze, can climb walls.
- **Close walls** - During nighttime the entries to the maze are closed.
- **Map** - Map with the already scouted areas containing the current position of the game character. Can be opened and closed pressing 'm'.
- **Main menu** - A screen before starting the actual game where the instructions can be consulted.
- **Instructions** - A short description of how the game is played.
- **Pause** - The game is paused by pressing 'escape' and a menu is displayed.
- **Won screen** - A screen to be displayed when the player escapes.
- **Lost screen** - A screen to be displayed when the player loses, giving the possibility to try again.


### PLANNED FEATURES

All planned features were implemented.


### SCREENSHOTS
![mainMenu.png](images%2Fscreenshots%2FmainMenu.png)

***Fig.1 - Main Menu***

---

![instructionsMenu.png](images%2Fscreenshots%2FinstructionsMenu.png)

***Fig.2 - Instructions Menu***

---

![gameDayTime.png](images%2Fscreenshots%2FgameDayTime.png)

***Fig.3 - Gameplay during daytime***

---

![gameNightTime.png](images%2Fscreenshots%2FgameNightTime.png)

***Fig.4 - Gameplay during nighttime***

---

![wonMenu.png](images%2Fscreenshots%2FwonMenu.png)

***Fig.5 - Screen displayed after escaping the maze***

---

![lostMenu.png](images%2Fscreenshots%2FlostMenu.png)

***Fig.6 - Screen displayed after dying***

---

![pauseMenu.png](images%2Fscreenshots%2FpauseMenu.png)

***Fig.7 - Pause Menu***


## DESIGN 

### General Structure
**Problem in Context**

How to structure our code.

**The Pattern**

We used the **Model-View-Controller** architectural pattern. 

**Implementation**

Model: contains the data of the menu and game elements.

View: is used to represent and display the data from the model, communicating with the gui.

Controller: it exists between the model and the view, modifies model data and interprets user actions (e.g. key pressed).

**Consequences**

- Different aspects of the game are separated
- Modifications don't affect the entire model
- Easier to expand due to the separation of the components (Open-Closed Principle)


---
### Different States of the Game
**Problem in Context**

Need to change the behavior of the Game having many possible states.

**The Pattern**

We used the **State** behavioral pattern.

**Implementation**

The following states were created:
- MainMenuState: waits for selection of a menu option
- GameState: processes gameplay, until the player pauses the game, escapes or dies
- PauseState: waits for selection of an option from the player, either resumes gameplay or quits the game. The current state of the game is saved, so it resumes from paused point.
- InstructionsState: waits for the selection of the option exit
- LostState: the player died so waits for the selection of an option from the player, either try again or quit the game
- WonState: the player escaped so waits for the selection to quit the game
- MapState: scouted map is open, waits for the M or ESC key to be pressed, to return to the game

![statePattern.png](images%2Fuml%2FstatePattern.png)

***Fig.8 - UML diagram of the implementation***

**Consequences**

- Introducing new states doesn't change other states
- Different behaviours are separated and state-specific behaviours are aggregated into each concrete state class (e.g. MainMenuState)

---
### Game Looping
**Problem in Context**

How to decouple the progression of the game from user input

**The Pattern**

We used the **Game Loop** pattern.

**Implementation**

A game loop runs continuously during gameplay. Each turn of the loop, it processes user input without blocking, updates the game state, and renders the game.
Every turn of the loop takes the same time. The time before and after computations is registered, and it waits the rest of the time until the chosen frame time has passed.

The variable is the FPS (frame per second) and the frame time is calculated following it.

The implementation is visible in this class:
[Game.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2FGame.java)

**Consequences**

- The game doesn't block waiting for an input
- Every frame of the game takes the same time
---
### Observing the player
**Problem in Context**

The game character needed to be centered in the screen and its vision needed to be short, otherwise it would see a lot of the maze that the game character is not seeing

**The Pattern**

We used the **Observer** behavioral pattern.

**Implementation**

The MazeCamera observes the player and every time it moves the camera is updated (updates center position)

![observerPattern.png](images%2Fuml%2FobserverPattern.png)

***Fig.9 - UML diagram of the implementation***

The implementation is visible in the following classes:
[Observer.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2FObserver.java)
[Observable.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2FObservable.java)
[MazeCamera.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Fcamera%2FMazeCamera.java)
[Player.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Felements%2FPlayer.java)

**Consequences**

- If there is another dependency on the player movement it can easily be added by adding another observer to the player (Open-Closed Principle)
- The game character will always be in the center of the screen

---
### Terminal and Camera differences
**Problem in Context**

Each element has a position on the maze and is drawn by painting multiple pixels in the screen. 
Thus, the maze position is not the same as position as the terminal position (e.g. each image having 16x16 pixels, the element in maze position (1,1) have its top left at the terminal position (16,16))

**The Pattern**

We used the **Adapter** structural pattern.

**Implementation**

The TerminalCamera adapts the MazeCamera to the correct positioning of the maze elements in the terminal.
It has a field mazeCamera and when a method is called it is used to convert from maze positioning to terminal positioning

The class TerminalPositionAdapter also adapts the TerminalPosition class from the gui.

![adapterPattern.png](images%2Fuml%2FadapterPattern.png)

***Fig.10 - UML diagram of the implementation***

The implementation is visible in the following classes:
[Camera.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Fcamera%2FCamera.java)
[MazeCamera.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Fcamera%2FMazeCamera.java)
[TerminalCamera.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Fcamera%2FTerminalCamera.java)
[Position.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2FPosition.java)
[MazePosition.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2FMazePosition.java)
[TerminalPositionAdapter.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2FTerminalPositionAdapter.java)

**Consequences**

- If the methods implementation of the MazeCamera class changes the terminal will continue to run as planned and will not need modifications
- The complexity of the code increased

---
### Time of Day
**Problem in Context**

The game is quite different during the daytime and nighttime. In the day the game is pacific and the player has a bigger field of view,
however in the night monsters appear and the field of view is reduced with the walls and the ground becoming darker.

**The Pattern**

We used the **Strategy** behavioral pattern.

**Implementation**

The MazeController is responsible for making the strategy switch from DayStrategy to NightStrategy and vice-versa, which makes the 
strategy for each object within this pattern change. 


![strategyPattern.png](images%2Fuml%2FstrategyPattern.png)

***Fig.11 - UML diagram of the implementation***

The implementation is visible in the following classes:
[MazeCamera.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Fcamera%2FMazeCamera.java)
[Ground.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Felements%2FGround.java)
[Wall.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fmodel%2Fgame%2Felements%2FWall.java)
[MonsterController.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fcontroller%2Fgame%2FMonsterController.java)
[MazeController.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fg0301%2Fmazerunner%2Fcontroller%2Fgame%2FMazeController.java)

**Consequences**

- Providing the ability to switch between strategies at runtime
- New "times of day" can easily be added or replaced
- Introduces additional complexity to the code

---
## UML diagram of the project

For easier understanding of the UML diagram, only the more important methods and attributes were shown.
For the same reason some classes were grouped:Element-Controllers, Menu-Controllers, Game-Viewers and Menu-Viewers.

![UML.png](images%2Fuml%2FUML.png)

***Fig.12 - UML diagram of the project***

## Known-code smells

All errors reported by error-prone were fixed. No other major code smells were identified.

### TESTING

**Code Coverage**

![testCoverage.png](images%2Fscreenshots%2FtestCoverage.png)

***Fig.13 - Code Coverage screenshot***


**Mutation Testing**

![mutationTesting.png](images%2Fscreenshots%2FmutationTesting.png)

***Fig.14 - Pitest screenshot***

[Mutation testing report](..%2Fbuild%2Freports%2Fpitest%2F202312201726%2Findex.html)
## Self-evaluation

The work was divided in a mutual way and we all contributed with our best. It helped us to enrich our java and principle/pattern knowledge, as well as our team work.

- David Ranito: 33.3%
- Pedro João:   33.3%
- Tiago Torres: 33.3%


