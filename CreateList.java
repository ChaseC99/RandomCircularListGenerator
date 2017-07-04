
/**
 * Write a description of class CreateList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreateList
{
   public static void main(String[] args){
       RandomCircularList game = new RandomCircularList();
       System.out.println("Number of players = " + game.getNumPlayers());
       game.printAllTeams();
       game.assignTargets();
       System.out.println(" ------------------------ ");
       System.out.println();
       game.printFirstTargets();
       System.out.println(" ------------------------ ");
       System.out.println();
       game.printList();
       
    }
}
