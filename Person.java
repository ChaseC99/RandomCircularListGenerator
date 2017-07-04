/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Each person on the
 *
 *
 */
public class Player
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

    // post: returns team
    public Team getTeam(){
        return team;
    }

    // post: returns true if different teams, false if same team
    public boolean diffTeams(Person person){
        return team.equals(person.getTeam());
    }

    // post: returns true if different teams, false if same team
    public boolean diffTeams(Team teamName){
        return team.equals(teamName);
    }

    // post: set target
    public void setTarget(Person person){
        target = person;
    }

    // post: returns target
    public Person getTarget(){
        return target;
    }

    // post: return name
    public String getName(){
        return name;
    }

    // post: return true if same object, false if different
    public boolean equals(Person person){
        return this.name == person.getName();
    }
}
