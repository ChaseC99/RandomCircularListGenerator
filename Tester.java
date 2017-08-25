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
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Window ui = new Window();

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

        for(int i = 0; i < 100; i++){
            RandomCircularList circularList = new RandomCircularList(teams);

            circularList.printAllTeams();
            circularList.printFirstTargets();
            circularList.printList();
            System.out.println();
            System.out.println(circularList.getNumPeople());
            System.out.println(circularList.getNumPeopleInList());
            System.out.println("Number of same team conflicts = " + circularList.sameTeamConflicts());
        }
    }

    /**
     *  pre: file contains team name, followed by each player on a seperate line
     *  post: returns a List<Person>
     */
    private static List<Person> fileToArray(String file, Team team){
        List<Person> array = new ArrayList<Person>();    // Makes a list

        try {
            FileReader inputFile = new FileReader(file); // Creates input file

            BufferedReader inFile = new BufferedReader(inputFile); // wraps in bufferedReader

            inFile.readLine();   // Disregards the team name at the beginning of the file

            String name;        // name from file

            // Runs through each number and adds it to an item
            while((name = inFile.readLine()) != null){

                Person temp = new Person(name, team);   // Creates new Person with parameters from the file
                array.add(temp);                        // Adds Person to array
            }

            inFile.close();     // Closes in file
        } catch(IOException e){

        }

        return array;       // Returns array with items in it
    }

}
