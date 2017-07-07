/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Creates a circular list of players.
 *  The list is essentially a linked list. Each person is a node.
 *  Each person class is assigned a target, so it knows who the next node is
 *
 *  No two players on the same team will be directly next to eachother on the list (unless only one team is inputed)
 *
 *  INSTANCE VARIABLES
 *      List<Team> teams        // list teams that will included in the circular list
 *      Person firstPeron       // considered the "starting" point for the circular list
 *
 *  METHODS
 *      assignTargets()         // creates the circlular linked list, telling each person who its next target is
 *      printFirstTargets()     // prints to console a list of everyone's first target.
 *                                      Ex: One "Person -> Target" per line
 *      printList()             // prints to console a list of everyone and who they are targeting
 *                                      Ex: "x --> y --> z --> a --> b --> c --> x"
 *      printTeam(Team)         // prints to console a list of the team's players
 *                                      Ex: "TeamName/n - name1 /n -name2 /n" etc
 *      printAllTeams()         // runs printTeam(Team) method for all teams in the list
 *      getNumPeople() -> int   // returns number of people in the list
 */

import java.util.*;     // Import List
//import chn.util.*;      // Allows for FileInput
public class RandomCircularList
{
    // instance variables
    public List<Team> teams;        // list teams that will included in the circular list
    public Person firstPerson;      // considered the "starting" point for the circular list

    /**
     * Constructor for objects of class RandomCircularList
     */
    public RandomCircularList(List<Team> teams)
    {
        this.teams = teams;
        firstPerson = teams.get(0).get(0);       // establishes first player on the first team as first player
    }

    /**
     *  pre: file contains team name, followed by each player on a seperate line
     *  post: returns a List<Person>
     *
    private List<Person> fileToArray(String file, Team team){
        List<Person> array = new ArrayList<Person>();    // Makes a list

        FileInput inFile = new FileInput(file); // Creates input file

        inFile.readLine();   // Disregards the team name at the beginning of the file

        int i = 0;  // Index to run through array

        // Runs through each number and adds it to an item
        while(inFile.hasMoreTokens()){
            String name = inFile.readLine();        // name from file

            Person temp = new Person(name, team);   // Creates new Person with parameters from the file
            array.add(temp);                        // Adds Person to array
            i++;                                    // Moves to next position in array
        }

        inFile.close();     // Closes in file

        return array;       // Returns array with items in it
    }*/

    /**
     *  This method creates the circlular linked list, telling each person who its next target is
     *
     *  pre: the teams have players loaded onto them
     *  post: each player is assigned a target
     */
    public void assignTargets(){
        ArrayList<Person> list = new ArrayList<Person>();   // Creates new list

        // Make a copy of teams
        List<Team> teamsCopy = new ArrayList<Team>();
        for(Team team: teams){
            Team teamCopy = new Team(team.getTeamName(), team.getList());
            teamsCopy.add(teamCopy);
        }

        // Set up for while loop
        Person player = firstPerson;                    // variable for the while loop representing the player getting assigned a target
        Team targetTeam;                                // declares targetTeam

        // random number so that the first nested while loop will run
        int teamIndex = teams.size() + 1;
        int lastTeamIndex = teams.size() + 1;

        while(teams.size() > 1){
            // Randomly gives the Person a team that is different from his own
            while(teamIndex == lastTeamIndex){
                // generates a random num representing a team in teams List
                Random rand = new Random();
                teamIndex = rand.nextInt(teams.size());
            }

            targetTeam = teams.get(teamIndex);  // set targetTeam based off the random number

            // Give player a random target from his/her targetTeam
            Random r = new Random();
            int i = r.nextInt(targetTeam.size());               // random index in the targetTeam List to pick random person in the team
            Person target = targetTeam.getList().remove(i);     // set target as player at random index of targetTeam and takes them out of the list
            player.setTarget(target);                           // set player's target

            // If the targetTeam is now empty, take the team out of the teams List
            if(targetTeam.size() == 0){
                teams.remove(teamIndex);
            }


            lastTeamIndex = teamIndex;  // updates last team
            player = target;            // target now gets assigned their target
        }

        /*
         *  After the while loop there is usually one team left
         *  The remaining players must be inserted into the list
         *  It runs through the linked list until it finds a pair of people who are different teams
         *  The player is inserted inbetween the two people
         */

        // Establishes which team is left
        Team teamLeft = teams.get(0);                   // get team List
        List<Person> peopleLeft = teamLeft.getList();   // get list of remaining people from teamLeft
        // Assign targets to remaining players on teamLeft
        for(Person thisPerson: peopleLeft)
        {
            // Starts search at the beginning of the list
            Person player1 = firstPerson;               // sets firstPerson as starting point for the loop
            Person player2 = player1.getTarget();       // sets player2 based off of firstPerson's target
            boolean inserted = false;                   // false until the player is added into the list

            // runs until player inserted
            while(!inserted)
            {
                if(player1.getTeam().equals(teamLeft) || player2.getTeam().equals(teamLeft))    // if player is on same team as target
                {
                    // move to next player
                    player1 = player2;
                    player2 = player2.getTarget();
                } else  // if player is on different team as target
                {
                    // insert player
                    player1.setTarget(thisPerson);  // set previous player target as thisPerson
                    thisPerson.setTarget(player2);  // set thisPerson's target to previous player's target
                    inserted = true;
                }
            }
        }

        /*
         *  Assign last player in the list to target coach
         */
        // parse the list to get the lastPerson
        Person lastPerson = firstPerson;              // starts loop at firstPerson

        // post: lastPerson is now the last player in the linked list
        while(lastPerson.getTarget() != null){
            lastPerson = lastPerson.getTarget();
        }

        // check to makesure coach and player aren't on the same team
        if(!lastPerson.getTeam().equals(firstPerson.getTeam())){
            player.setTarget(firstPerson);
        } else {
            assignTargets();    // rerun the assign targets method so new player is at the end
        }
    }

    /**
     *  prints a list of everyone's first target
     *  example:
     *      x --> y
     *      y --> z
     *      z --> a
     */
    public void printFirstTargets(){
        System.out.println("FIRST TARGETS");
        System.out.println();

        Person hunter = firstPerson;
        Person target = hunter.getTarget();

        do{
            System.out.println(hunter.getName() + " ( " + hunter.getTeam().getTeamName().substring(0,1) + " )" + " --> " + target.getName() + " ( " + target.getTeamName().substring(0,1) + " )");
            hunter = target;
            target = hunter.getTarget();
        }while(!hunter.equals(firstPerson));

        System.out.println();
    }

    /**
     *  prints a list of everyone and who they are targeting
     *  example:
     *      x --> y --> z --> a --> b --> c --> x
     */
    public void printList(){
        System.out.println("ORIGINAL TARGETS");
        System.out.println();
        Person temp = firstPerson;
        do{
            System.out.print(temp.getName() + " --> ");
            temp = temp.getTarget();
        } while (!temp.equals(firstPerson));
        System.out.print(firstPerson.getName());
        System.out.println();
    }

    /**
     *  prints a list of the team's players
     *  example:
     *      team
     *       - a
     *       - b
     *       - c
     */
    public void printTeam(Team team){
        System.out.println(team.getTeamName());
        List<Person> people = team.getList();
        for(Person person: people){
            System.out.println(" - " + person.getName());
        }
        System.out.println();   // gap for readability
    }

    /**
     *  prints all team rosters using printTeam method
     */
    public void printAllTeams(){
        for(Team team: teams){
            printTeam(team);
        }
    }

    /**
     *  post: returns number of players in the game
     */
    public int getNumPeople(){
        int sum = 0;

        for(Team team: teams){
            sum += team.size();
        }

        return sum;
    }
}
