# Random List Generator
### Created by Chase Carnaroli
The program takes a list of names from multiple groups of people and generates a circular linked list where no two people from the same group are next to each other (three or more groups required for this, otherwise it will be a normal randomized list).

Video: [Random List Generator Demo](https://youtu.be/64j0xa_kzUQ)

![Random List Generator Screenshot](https://i.imgur.com/R9uxRFm.png)
*Screenshot of Random List Generator running on Mac OS; it will look different on Windows and Linux*

#### How to Download
Go to this [link](https://github.com/ChaseC99/RandomCircularListGenerator/blob/master/RandomListGenerator.jar)   
Then click "Download"
![Download Button](https://i.imgur.com/dAnA9i2.png)

---
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
There is a List called ```groups``` which consists of all the groups in the game.
Each group has a list ```people``` which consists of all the people in the group.

The ```RandomCircularListGenerator``` takes in ```groups``` and makes a copy (separate object in memory) of it.

##### Creating the Random Circular List
If there are fewer than 3 groups in ```groups```, then a random list will be generated, but two people from the same group may end up next to each other.

If there are 3 or more groups in ```groups```, then this is how the program generates a list where no two people from the same group end up next to each other:  
1. Random person is chosen (and removed) from a group randomly selected from ```groups```. This person is the first person in the list.
2. A group is randomly selected from ```groups``` until the selected group is different from the previous person's. From that group, a person is randomly chosen (and removed from their group) and added as the next person in the list.
3. Once a group runs out of players, they are removed from ```groups```.
4. Repeat step 2 and 3 until only 1 group remains.
5. Take the people from the remaining group and insert them into the list between two people who aren't in the same group as them.
6. Check to make sure no two people from the same group are next to each other and that the first and last people are not from the same group. If they there are any ```sameGroupConflicts```, go back to step 1 and try again. (I know this is inefficient, but it works for now)


\* If the amount of players in ```groups``` is uneven and won't allow for a list where no two people from the same group end up next to each other, it will create a normal randomized list instead.

**See [Issues](https://github.com/ChaseC99/RandomCircularListGenerator/issues) for known bugs**

---
### License
This program is licensed under [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html "License Information").  
Feel free to use my source code to improve it or make your own version!
