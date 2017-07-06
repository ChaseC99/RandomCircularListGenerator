
/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  The Team class tracks a List<Person>
 *  This is so that people of the same team won't get placed together
 *
 *  INSTANCE VARIABLES
 *      String teamName             // name of the team
 *      List<Person> people         // list of Persons on the team
 *
 *  METHODS
 *      size() -> int                   // returns number of people on the team
 *      add(Person)                     // a Person is added to the List<Person> people
 *      remove(Person) -> boolean       // returns true if person is removed, false if person wasn't in list
 *      setPeople(List<Person>)         // people is set to the List<Person> passed through
 *      getPeople() -> List<Person>     // returns List<Person> people
 *      getTeamName() -> String         // returns teamName
 *      get(int) -> Person              // returns person at index in List<Person> people
 *      toString() -> String            // overrides toString method and returns teamName
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

    // post: a Person is added to the List<Person> people
    public void add(Person person){
        people.add(person);
    }

    // scans List<Person> people and removes the person
    // post: returns true if person is removed, false if person wasn't in list
    public boolean remove(Person person){
        int index = people.indexOf(person);
        if(index != -1){
            people.remove(index);
            return true;
        } else {
            return false;
        }
    }

    // post: people is set to the List<Person> passed through
    public void setPeople(List<Person> people){
        this.people = people;
    }

    // post: returns List<Person> people
    public List<Person> getPeople(){
        return people;
    }

    // post: return teamName
    public String getTeamName(){
        return teamName;
    }

    // post: returns person at index in List<Person> people
    public Person get(int index){
        return people.get(index);
    }

    // post: overrides toString method and returns teamName
    public String toString(){
        return getTeamName();
    }
}
