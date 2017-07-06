/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Tester class to make sure RandomCircularList works
 */

 import java.util.*;     // Import List
 import java.io.*;
 //import chn.util.*;      // Allows for FileInput
public class Tester {
    // test RandomCircularList
    public static void main(String[] args){
        List<Team> teams = new ArrayList<Team>();

        Team varsity = new Team("Varsity");
        varsity.setList(fileToArray("TestFiles/varsity.txt", varsity));
        teams.add(varsity);

        Team jv = new Team("JV");
        jv.setList(fileToArray("TestFiles/jv.txt", jv));
        teams.add(jv);

        Team n = new Team("Novice");
        n.setList(fileToArray("TestFiles/novice.txt", n));
        teams.add(n);

        Team sg = new Team("Stat Girls");
        sg.setList(fileToArray("TestFiles/statGirls.txt", sg));
        teams.add(sg);

        RandomCircularList circularList = new RandomCircularList(teams);

        circularList.printAllTeams();
        circularList.assignTargets();
        circularList.printFirstTargets();
        circularList.printList();
    }

    private static List<Person> fileToArray(String file, Team team){
        List<Person> array = new ArrayList<Person>();    // Makes a list

        try {
            FileReader inputFile = new FileReader(file); // Creates input file

            BufferedReader inFile = new BufferedReader(inputFile); // wraps in bufferedReader

            inFile.readLine();   // Disregards the team name at the beginning of the file

            int i = 0;  // Index to run through array

            String name;        // name from file

            // Runs through each number and adds it to an item
            while((name = inFile.readLine()) != null){

                Person temp = new Person(name, team);   // Creates new Person with parameters from the file
                array.add(temp);                        // Adds Person to array
                i++;                                    // Moves to next position in array
            }

            inFile.close();     // Closes in file
        } catch(IOException e){

        }

        return array;       // Returns array with items in it
    }

}
