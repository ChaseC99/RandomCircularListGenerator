
/**
 * Write a description of class CreateList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 import java.util.*;
public class CreateList
{
   public static void main(String[] args){
       List<Team> temp = new ArrayList<Team>();
       RandomCircularList game = new RandomCircularList(temp);
       System.out.println("Number of people = " + game.getNumPeople());
       game.printAllTeams();
       System.out.println(" ------------------------ ");
       System.out.println();
       game.printFirstTargets();
       System.out.println(" ------------------------ ");
       System.out.println();
       game.printList();

   }
}
