OOAD4 Project README
bg1987 306224403
naamabd 123456789

----------------------------

It may be required to display the board through various graphical representations, possibly simultaneously
It should be possible to add more computer heuristics and the game might be configured to choose a particular heuristic
It might be required to allow the user to configure parameters of the visual appearance of the board (e.g. border, background).
Instead of running the game from the terminal, it could be ran by a server handling a huge number of games in parallel (multiple instances of the game). The system should optimize memory usage.


------
Solution overview
the project is devided into two major packages, the ooad4.core and ooad4.connectfour
The Main classes are 

1. To create a new graphical instance of the game, you should instanciate