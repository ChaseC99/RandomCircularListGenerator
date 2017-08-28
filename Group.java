
/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  The Group class tracks a List<Person>
 *  This is so that people of the same group won't get placed together
 *
 *  INSTANCE VARIABLES
 *      String groupName             // name of the group
 *      List<Person> people         // list of Persons on the group
 *
 *  METHODS
 *      size() -> int                   // returns number of people on the group
 *      add(Person)                     // a Person is added to the List<Person> people
 *      remove(Person) -> boolean       // returns true if person is removed, false if person wasn't in list
 *      setList(List<Person>)           // people is set to the List<Person> passed through
 *      getList() -> List<Person>       // returns List<Person> people
 *      getListAsArray() -> Person[]    // returns List<Person> people as an array
 *      setGroupName(String)            // sets groupName as the inputted name
 *      getGroupName() -> String        // returns groupName
 *      get(int) -> Person              // returns person at index in List<Person> people
 *      toString() -> String            // overrides toString method and returns groupName
 */

 import java.util.*;    // import arraylists
public class Group
{
    // Instance Variables
    private String groupName;
    private List<Person> people;

    // Constructors
    public Group(String groupName){
        this.groupName = groupName;
        people = new ArrayList<Person>();
    }

    public Group(String groupName, List<Person> people){
        this.groupName = groupName;
        this.people = people;
    }

    // post: returns number of people on the group
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
    public void setList(List<Person> people){
        this.people = people;
    }

    // post: returns List<Person> people
    public List<Person> getList(){
        return people;
    }

    // post: returns the list<Person> people as an array
    public Person[] getListAsArray(){
        Person[] rosterArray = new Person[people.size()];
        for(int i = 0; i < rosterArray.length; i++){
            rosterArray[i] = people.get(i);
        }
        return rosterArray;
    }

    // post: groupName is changed
    public void setGroupName(String name){
        groupName = name;
    }

    // post: return groupName
    public String getGroupName(){
        return groupName;
    }

    // post: returns person at index in List<Person> people
    public Person get(int index){
        return people.get(index);
    }

    // post: overrides toString method and returns groupName
    public String toString(){
        return getGroupName();
    }
}
