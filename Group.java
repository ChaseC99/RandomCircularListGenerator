
/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  The Group class tracks a List<Person>
 *  This is so that roster of the same group won't get placed together
 *
 *  INSTANCE VARIABLES
 *      String groupName             // name of the group
 *      List<Person> roster         // list of Persons on the group
 *
 *  METHODS
 *      size() -> int                   // returns number of roster on the group
 *      add(Person)                     // a Person is added to the List<Person> roster
 *      remove(Person) -> boolean       // returns true if person is removed, false if person wasn't in list
 *      setList(List<Person>)           // roster is set to the List<Person> passed through
 *      getList() -> List<Person>       // returns List<Person> roster
 *      getListAsArray() -> Person[]    // returns List<Person> roster as an array
 *      setGroupName(String)            // sets groupName as the inputted name
 *      getGroupName() -> String        // returns groupName
 *      get(int) -> Person              // returns person at index in List<Person> roster
 *      toString() -> String            // overrides toString method and returns groupName
 */

 import java.util.*;    // import arraylists
public class Group
{
    // INSTANCE VARIABLES
    private String groupName;
    private List<Person> roster;

    // CONSTRUCTORS
    public Group(String groupName){
        this.groupName = groupName;
        roster = new ArrayList<Person>();
    }

    public Group(String groupName, List<Person> roster){
        this.groupName = groupName;
        this.roster = roster;
    }

    // METHODS

    // Get the size of roster
    // post: returns number of roster on the group
    public int size(){
      return roster.size();
    }

    // Add a person to the group
    // post: a Person is added to the List<Person> roster
    public void add(Person person){
        roster.add(person);
    }

    // Remove a person from the group
    // Scans List<Person> roster and removes the person
    // post: returns true if person is removed, false if person wasn't in list
    public boolean remove(Person person){
        int index = roster.indexOf(person);
        if(index != -1){
            roster.remove(index);
            return true;
        } else {
            return false;
        }
    }

    // Set roster from a list
    // post: roster is set to the List<Person> passed through
    public void setRoster(List<Person> roster){
        this.roster = roster;
    }

    // Set roster from an array of strings
    // post: creates a list based off of the string inputed
    public void setRoster(String[] names){
        List<Person> roster = new ArrayList<Person>();
        for(String name: names){
            roster.add(new Person(name, this));
        }
        this.roster = roster;
    }

    // Get roster
    // post: returns List<Person> roster
    public List<Person> getRoster(){
        return roster;
    }

    // Get the roster as a Person[]
    // post: returns the list<Person> roster as an array
    public Person[] getRosterAsArray(){
        Person[] rosterArray = new Person[roster.size()];
        for(int i = 0; i < rosterArray.length; i++){
            rosterArray[i] = roster.get(i);
        }
        return rosterArray;
    }

    // Get roster for a string for a text area
    // Each person is on a seperate line
    // post: returns a string of names in roster, with each name on a seperate line
    public String getRosterAsTextArea(){
        String rosterText = "";
        for(Person person: roster){
            rosterText += person.getName() + "\n";
        }
        return rosterText;
    }

    // Set the group name
    // post: groupName is changed
    public void setGroupName(String name){
        groupName = name;
    }

    // Get the group name
    // post: return groupName
    public String getGroupName(){
        return groupName;
    }

    // Get person at index
    // post: returns person at index in List<Person> roster
    public Person get(int index){
        return roster.get(index);
    }

    // Override toString method
    // post: overrides toString method and returns groupName
    @Override
    public String toString(){
        return getGroupName();
    }
}
