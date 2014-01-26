This is a super-souped up and unfaithful rendition of the game Advance Wars, meant to be played by two players.

In the beginning, the program asks for the default money you wish to set up. Default value is 1000, but any integer goes. Try not to enter negative values.

To RUN THE PROGRAM:

All files necessary to run the program are in this repo.
In addition, you can probably make your own map if you really wanted to spend the time and effort manually changing Terrain in an instantiated Grid.
Run GameDriver to start.

To WIN THE GAME:
You win by either capturing your opponent's HQ, or by wiping off all of your opponent's units in a turn. There is some leeway in the beginning if a side doesn't have units.

Coordinates:
This game runs on a coordinate system. The point 0,0 is the box at the top left corner, with the positive values running right and down.
Each boxes consists of a Terrain and a Unit, if there is any. A Unit shown under a Terrain means that the Unit is standing on that Terrain.
You will be prompted for a pair of coordinates in the beginning, this is so you can check that box for more information on it.

Info:
Once you choose a box, the box will display relevant info about the Terrain and the Unit, if any.
You will also be prompted if you wish to engage in additional action.

Attack:
Units can attack other units. However, the target unit must be in range. If a unit attempts to attack another unit out of range, the attack will fail.
Moreover, the enemy will be alerted so long as it has not been destroyed and will attempt a counterattack. Of course, that attack may also be out of range.
Some units fare better against certain units than others. Consider looking at the weaknesses assigned in the Info section of a Unit by examining it.

Capture:

Cities, Factories, Airports, and Headquarters can be captured if it is neutral or of the opposite side by an Infantry, Mech, or Bike.
Capturing buildings will always increase the income you get every turn by 1000. Factories and Airports, when captured, will allow you to spend your income
to send out troops.

Deploy:

Factories and Airports can deploy units if:
1: There are no units on the Factory/Airport.
2: There is enough money to deploy the unit.

All units cannot move the turn they are deployed.
