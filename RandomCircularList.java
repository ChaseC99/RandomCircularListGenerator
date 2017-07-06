/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 * Creates a circular list of players for the TAG volleyball game
 *
 * @version 4/20/2017
 */

import java.util.*;     // Import List
//import chn.util.*;      // Allows for FileInput
public class RandomCircularList
{
    // instance variables
    public List<Team> teams;

    /**
     * Constructor for objects of class RandomCircularList
     */
    public RandomCircularList(List<Team> teams)
    {
        this.teams = teams;
    }

    /**
     *  pre: file contains team name, followed by each player on a seperate line
     *  post: returns a List<Person>
     */
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
    }

    /**
     *
     *
     *  pre: the teams have players loaded onto them
     *  post: each player is assigned a target
     */
    public void assignTargets(){
        ArrayList<Person> list = new ArrayList<Person>();   // Creates new list

        // Set up for while loop
        //Person player = coach;      // establishes coach as first player
        Team targetTeam;    // declares targetTeam

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
            int i = r.nextInt(targetTeam.size());       // random index in the targetTeam List to pick random person in the team
            Person target = targetTeam.remove(i);       // set target as player at random index of targetTeam and takes them out of the list
            player.setTarget(target);                   // set player's target

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
        Team teamLeft = teams.get(0);               // get team List
        String teamLeftName = teamLeft.get(0).getTeamName();      // get team name  // UNSURE IF NECESSAY/STILL WORKS

        // Assign targets to remaining players on teamLeft
        for(Person thisPerson: teamLeft)
        {
            // Starts search at the beginning of the list
            Person player1 = coach;                     // sets coach as first player
            Person player2 = player1.getTarget();       // sets coach's target as second player
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
        Person lastPerson = coach;              // start at coach
        // post: lastPerson is now the last player in the linked list
        while(lastPerson.getTarget() != null){
            lastPerson = lastPerson.getTarget();
        }

        // check to makesure coach and player aren't on the same team
        if(!lastPerson.getTeam().equals(coach.getTeam())){
            player.setTarget(coach);
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

        Person hunter = coach;
        Person target = hunter.getTarget();

        do{
            System.out.println(hunter.getName() + " ( " + hunter.getTeam().toString().substring(0,1) + " )" + " --> " + target.getName() + " ( " + target.getTeam().toString().substring(0,1) + " )");
            hunter = target;
            target = hunter.getTarget();
        }while(!hunter.getName().equals(coach.getName()));

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
        Person temp = coach;
        do{
            System.out.print(temp.getName() + " --> ");
            temp = temp.getTarget();
        } while (temp.getName() != coach.getName());
        System.out.print(coach.getName());
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
        List<Person> people = team.getPeople();
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
