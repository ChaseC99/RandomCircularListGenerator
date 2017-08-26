/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Each person is represented by a Person class
 *  The Person class tracks each person's name, group, and target
 *
 *  INSTANCE VARIABLES
 *      String name         // person's name
 *      Group group           // the group that the person belongs to
 *      Person target       // the person that comes after this person on the list
 *
 *  METHODS
 *      getName() -> String               // returns person's name
 *      getGroup() -> Group                 // returns person's group
 *      getGroupName() -> String           // returns group name
 *      setTarget()                       // sets person's target
 *      getTarget() -> Person             // returns person's target
 *      diffGroups(Person) -> boolean      // returns true if different groups, false if same group
 *      diffGroups(Group) -> boolean        // returns true if different groups, false if same group
 *      equals(Person) -> boolean         // return true if same person, false if different
 */
public class Person
{
    // Instance Variables
    private String name;
    private Group group;
    private Person target;

    /**
     * Constructor Person class
     */
    public Person(String name, Group group)
    {
        this.name = name;
        this.group = group;
    }

    // post: return name
    public String getName(){
        return name;
    }

    // post: returns group
    public Group getGroup(){
        return group;
    }

    // post: returns group name
    public String getGroupName(){
        return group.getGroupName();
    }

    // post: set target
    public void setTarget(Person person){
        target = person;
    }

    // post: returns target
    public Person getTarget(){
        return target;
    }

    // post: returns true if different groups, false if same group
    public boolean diffGroups(Person person){
        return group.equals(person.getGroup());
    }

    // post: returns true if different groups, false if same group
    public boolean diffGroups(Group groupName){
        return group.equals(groupName);
    }

    // post: return true if same object, false if different
    public boolean equals(Person person){
        return this.name == person.getName();
    }

    // post: return String of the person's name
    public String toString(){
        return name;
    }
}
