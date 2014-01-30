OOAD4 Project README
bg1987 306224403
naamabd 123456789

----------------------------

It may be required to display the board through various graphical representations, possibly simultaneously
It should be possible to add more computer heuristics and the game might be configured to choose a particular heuristic
It might be required to allow the user to configure parameters of the visual appearance of the board (e.g. border, background).
Instead of running the game from the terminal, it could be ran by a server handling a huge number of games in parallel (multiple instances of the game). 
The system should optimise memory usage.


------
Solution overview
the project is divided into two major packages, the ooad4.core and ooad4.connectfour
In core the main classes are:
Game, Rules, Strategy, Player.

To create a Game, you need to supply him two Players, and a Rules.
To create a Player you need a Strategy, (which is a Strategy pattern)
The Strategy determines the type of player, i.e. human player from console, a random player or any other implementation.
The rules are the actual rules of the game, determining which game will effectively be played.
The Game is an observable class that iterates between players, calling their "getMove" method, and pass it down to the
its Rules member, which will change the board or notify error.
after each Move the Game will call the CheckWin, to see if the game has ended.
the Game is observable (push method) and should be observed by the GUI and respond to its events accordingly.

It is also possible to extend the core package to create a new game entirely with different rules.
By extending Rules class and creating new rules for checkers, for instance and new strategies that pass new Move types you can create a game
of checkers simply by implementing the core logic of the game (the actual rules of the game) and our framework would support it. 


In the connectFour package there are concrete implementations of the classes in core that are needed for the game.
such as ConnectFourRules, and a ConnectFourStrategy

1. To create a new graphical instance of the game, you should create classes implement the Strategy interface which
will take input as you see fit (say through console input, or clicking on a gui).
then you should Create a Game object, register as an observer and start the Game.Play() method.
then game will notify about changes in the game board, and it is up to the GUI to handle it.
if you have 2 different GUI implementations they can both register as observers of the same Game objects and both will updated.
this implementation is provided as an example with one ConsoleGui and one SwingGUI which run simultaneously.


2.as explained, when creating a game you pass on two players, to create a player you need to create a class that implements
the strategy interface and implement whatever heuristic you wish. then pass it to the game and it will work 
(we have two strategies, one random and one that takes input from the console).

3.The change of representation is the GUIs responsibility, in our examples, if you change the Files **** the Swing gui will display
new images for each player and if you change the ****** (can be easily changed to read from file) the Console GUI will display different Chars for each player.

4.To create a networked version, you would need to implement a new strategy that gets input from the network, and also when you get notifications from Game
It should be passed to the respective clients.
Memory usage is optimised by .....?!!?!?



