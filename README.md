# CS611-Assignment 1-September 30th, 2022
## <Tic Tac Toe and other variants>
---------------------------------------------------------------------------
Showndarya Madhavan
shmadhav@bu.edu

## Files
---------------------------------------------------------------------------

The code base is divided into 5 packages:

1. Common: Classes are functional classes which can be used across games to ease out mundane tasks

- GameType: Enum to hold type of games (For now there are 2 entries)
- IOWrapper: Wrapper functions on top of java I/O operations for avoiding repetitions
- Tuple: Class to store key-value pair (one/ many) with ease
- Utilities: Class with common utility functions for operating on base game objects which can be reused in other games

2. GameObjects:

- Board: Abstract class to host the elements of the board with functions to perform manipulation on properties like board layout matrix, board size, next move, filled pieces count, etc.
- Cell: Class to hold information on the each position in the board layout matrix like Piece type.
- Engine: Abstract class to tie up the game together by holding the Engine, Score and Teams together to maintain state of the game at any point.
- Move: Interface to hold functions related to deciding winning condition and validating move.
- Piece: Abstract class to hold functions related to getting internal and display value for each piece (game piece)
- Player: Class to hold player information and perform player specific manipulation
- Score: Class to hold score information like wins, ties and total games which can be used for player specific, team specific and game specific score stats.
- Team: Class to hold team information, list of associated players and perform player specific manipulation
- Turn: Interface to hold functions for handling turn based games.

3. GameCommon: Common classes, properties and methods shared between both the games (Tic-Tac-Toe or Order and Chaos)

- Constants: Resource file for strings and constant numbers in one place which can make chaging configuration easy
- GameBoard: Extends the board class to handle manipulations for both the games
- GameEngine: Extends the engine clas to tie up the game initilization together (initialize board, teams, players, pieces)
- GameUtilities: Class with game based utility functions for operating on base and game objects shared between both games in this project.
- Menu: The driver class to handle start and termination of the program
- OPiece: Extends Piece to define the "X" piece needed for both the games in this project
- XPiece: Extends Piece to define the "O" piece needed for both the games in this project

4. OrderAndChaos: Logic specific to Order and Chaos game

- OrderAndChaosMove: Logic to validate a move and handle winning codition and chaos condition for the game
- OrderAndChaosTurn: Logic to handle the turns of the teams in the game

5. TicTacToe: Logic specific to Tic Tac Toe game

- TicTacToeMove: Logic to validate a move and handle winning codition and draw condition for the game
- TicTacToeTurn: Logic to handle the turns of the teams in the game

## Notes
---------------------------------------------------------------------------
1. Bonus: Implementation for an nxn board for tic-tac-toe is achieved.
2. Bonus: Implementation for handling teams and adding players to teams is achieved. The player in each team is selected at random by the program in each turn.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "BoardGame" after unzipping the files
2. Run the following instructions:
javac GameCommon/Menu.java
java GameCommon.Menu
