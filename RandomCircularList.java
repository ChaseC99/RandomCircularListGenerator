/**
 * Creates a circular list of players for the TAG volleyball game
 *
 * @author Chase Carnaroli
 * @version 4/20/2017
 */

import java.util.*;     // Import List
import chn.util.*;      // Allows for FileInput
public class RandomCircularList
{
    // instance variables
    public List<Player> novice, jv, varsity, statGirls, circleList;     // teams
    private Player coach = new Player("Coach Jackson", Team.VARSITY);   // coach

    /**
     * Constructor for objects of class RandomCircularList
     */
    public RandomCircularList()
    {
        // Load different teams
        novice = fileToArray("novice.txt", Team.NOVICE);
        jv = fileToArray("jv.txt", Team.JV);
        varsity = fileToArray("varsity.txt", Team.VARSITY);
        statGirls = fileToArray("statGirls.txt", Team.STATGIRLS);
    }

    /**
     *  pre: file contains team name, followed by each player on a seperate line
     *  post: returns a List<Player>
     */
    private List<Player> fileToArray(String file, Team team){
        List<Player> array = new ArrayList<Player>();    // Makes a list

        FileInput inFile = new FileInput(file); // Creates input file

        inFile.readLine();   // Disregards the team name at the beginning of the file

        int i = 0;  // Index to run through array

        // Runs through each number and adds it to an item
        while(inFile.hasMoreTokens()){
            String name = inFile.readLine();        // name from file

            Player temp = new Player(name, team);   // Creates new Player with parameters from the file
            array.add(temp);                        // Adds Player to array
            i++;                                    // Moves to next position in array
        }

        inFile.close();     // Closes in file

        return array;       // Returns array with items in it
    }

    /**
     *  post: returns ArrayList of strings of the players on a team
     */
    public ArrayList<Player> rosterToArray(String fileName){
        return new ArrayList<Player>();
    }

    /**
     *
     *
     *  pre: the teams have players loaded onto them
     *  post: each player is assigned a target
     */
    public void assignTargets(){
        ArrayList<Player> list = new ArrayList<Player>();   // Creates new list

        // temporary team rosters (USELESS... references the same object.. meep)
        List<Player> n = novice;
        List<Player> j = jv;
        List<Player> v = varsity;
        List<Player> g = statGirls;

        // List of the teams in the game
        List<List<Player>> teams = new ArrayList<List<Player>>();   // creates List
        teams.add(n); teams.add(j); teams.add(v); teams.add(g);     // add teams to the teams List

        // Set up for while loop
        Player player = coach;      // establishes coach as first player
        List<Player> targetTeam;    // declares targetTeam

        // random number so that the first nested while loop will run
        int teamIndex = 5;
        int lastTeamIndex = 5;

        while(teams.size() > 1){
            // Randomly gives the Player a team that is different from his own
            while(teamIndex == lastTeamIndex){
                // generates a random num representing a team in teams List
                Random rand = new Random();
                teamIndex = rand.nextInt(teams.size());
            }

            targetTeam = teams.get(teamIndex);  // set targetTeam based off the random number

            // Give player a random target from his/her targetTeam
            Random r = new Random();
            int i = r.nextInt(targetTeam.size());       // random index in the targetTeam List
            Player target = targetTeam.remove(i);       // set target as player at random index of targetTeam and takes them out of the list
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
        List<Player> teamLeft = teams.get(0);               // get team List
        Team teamLeftName = teamLeft.get(0).getTeam();      // get team name

        // Assign targets to remaining players on teamLeft
        for(Player thisPlayer: teamLeft)
        {
            // Starts search at the beginning of the list
            Player player1 = coach;                     // sets coach as first player
            Player player2 = player1.getTarget();       // sets coach's target as second player
            boolean inserted = false;                   // false until the player is added into the list

            // runs until player inserted
            while(!inserted)
            {
                if(player1.getTeam().equals(teamLeftName) || player2.getTeam().equals(teamLeftName))    // if player is on same team as target
                {
                    // move to next player
                    player1 = player2;
                    player2 = player2.getTarget();
                } else  // if player is on different team as target
                {
                    // insert player
                    player1.setTarget(thisPlayer);  // set previous player target as thisPlayer
                    thisPlayer.setTarget(player2);  // set thisPlayer's target to previous player's target
                    inserted = true;
                }
            }
        }

        /*
         *  Assign last player in the list to target coach
         */

        // parse the list to get the lastPlayer
        Player lastPlayer = coach;              // start at coach
        // post: laterPlayer is now the last player in the linked list
        while(lastPlayer.getTarget() != null){
            lastPlayer = lastPlayer.getTarget();
        }

        // check to makesure coach and player aren't on the same team
        if(!lastPlayer.getTeam().equals(coach.getTeam())){
            player.setTarget(coach);
        } else {
            assignTargets();    // rerun the assign targets method so new player is at the end
        }
    }

    /**
     * ***didn't actually end up using this method in the final program***
     * post: circularList has every player with their target after and Player before
     */
    public void createList(){
        circleList.add(coach);
        Player temp = coach.getTarget();
        while(!temp.equals(coach)){
            circleList.add(temp);
            temp = temp.getTarget();
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

        Player hunter = coach;
        Player target = hunter.getTarget();

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
        Player temp = coach;
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
    public void printTeam(List<Player> team){
        System.out.println(team.get(0).getTeam());
        for(Player player: team){
            System.out.println(" - " + player.getName());
        }
        System.out.println();   // gap for readability
    }

    /**
     *  prints all team rosters using printTeam method
     */
    public void printAllTeams(){
        printTeam(novice);
        printTeam(jv);
        printTeam(varsity);
        printTeam(statGirls);
    }

    /**
     *  post: returns number of players in the game
     */
    public int getNumPlayers(){
        int sum = 1; // 1 accounts for coach

        for(Player i: novice){
            sum++;
        }
        for(Player i: jv){
            sum++;
        }
        for(Player i: varsity){
            sum++;
        }
        for(Player i: statGirls){
            sum++;
        }

        return sum;
    }
}
