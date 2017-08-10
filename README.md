# RandomCircularListGenerator
### Created by Chase Carnaroli
The program takes a list of names from multiple groups of people and generates a circular linked list where no two people from the same group are next to each other.

#### Background
Every year, my high school volleyball team would play a game called "*The Assasination Game*" (TAG for short).
Everyone in the volleyball program would play together: Varsity, JV, Novice, and Stat Keepers.

To set up the game, our coach would take everyone's name and make a big randomized circular list, where no two kids from the same team were next to eachother.
It was a pain for my coach to set up though, because there were over 50 people in the game!

So, I created this program to automate that process. 
All coach has to do now is put in a list of names and it will generate the circular list for him!

---
### The Code
Before generating the random circular list, the people must be loaded in.
There is a List called ```teams``` which consists of all the teams in the game.
Each group has a list ```people``` which consists of all the people on team.

The ```RandomCircularListGenerator``` takes in ```teams``` and makes a copy (seperate object in memory) of it.

##### Creating the Random Circular List
1. Random person is chosen (and removed) from a team randomly selected from ```teams```. This person is the first person in the list.
2. A team is randomly selected from ```teams``` until the selected team is different from the previous person's. From that team, a person is randomly chosen (and removed from their team) and added as the next person in the list.
3. Once a team runs out of players, they are removed from ```teams```.
4. Repeat step 2 and 3 until only 1 team remains.
5. Take the people from the remaining team and insert them into the list between two people who aren't on their team.
6. Check to make sure no two people from the same team are next to eachother and that the first and last people are not of the same team. If they there are any ```sameTeamConflicts```, go back to step 1 and try again. (I know this is inefficient, but it works for now)

**See [Issues](https://github.com/ChaseC99/RandomCircularListGenerator/issues) for known bugs**

---
### License
This program is licensed under [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html "License Information").  
Feel free to use my source code to improve it or make your own version!
