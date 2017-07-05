/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Each person is represented by a Person class
 *  The Person class tracks each person's name, team, and target
 *
 *  INSTANCE VARIABLES
 *      String name         // person's name
 *      Team team           // the team that the person belongs to
 *      Person target       // the person that comes after this person on the list
 *
 *  METHODS
 *      getName() -> String               // returns person's name
 *      getTeam() -> Team                 // returns person's team
 *      setTarget()                       // sets person's target
 *      getTarget() -> Person             // returns person's target
 *      diffTeams(Person) -> boolean      // returns true if different teams, false if same team
 *      diffTeams(Team) -> boolean        // returns true if different teams, false if same team
 *      equals(Person) -> boolean         // return true if same person, false if different
 */
public class Person
{
    // Instance Variables
    private String name;
    private Team team;
    private Person target;

    /**
     * Constructor Person class
     */
    public Person(String name, Team team)
    {
        this.name = name;
        this.team = team;
    }

    // post: return name
    public String getName(){
        return name;
    }

    // post: returns team
    public Team getTeam(){
        return team;
    }

    // post: set target
    public void setTarget(Person person){
        target = person;
    }

    // post: returns target
    public Person getTarget(){
        return target;
    }

    // post: returns true if different teams, false if same team
    public boolean diffTeams(Person person){
        return team.equals(person.getTeam());
    }

    // post: returns true if different teams, false if same team
    public boolean diffTeams(Team teamName){
        return team.equals(teamName);
    }

    // post: return true if same object, false if different
    public boolean equals(Person person){
        return this.name == person.getName();
    }
}
