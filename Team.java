
/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *  Enumeration class Team - write a description of the enum class here
 *
 *
 */

 import java.util.*;    // import arraylists
public class Team
{
    // Instance Variables
    private String teamName;
    private List<Person> people;

    // Constructors
    public Team(String teamName){
        this.teamName = teamName;
        people = new ArrayList<People>();
    }

    public Team(String teamName, List<Person> people){
        this.teamName = teamName;
        this.people = people;
    }

    // post: returns number of people on the team
    public int size(){
      return people.size();
    }

    public void add(Person person){
        people.add(person);
    }

    public boolean remove(Person person){
        int index = people.indexOf(person);
        if(index != -1){
            people.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void setPeople(List<People> people){
        this.people = people;
    }

    public List<Person> getPeople(){
        return people;
    }
}
