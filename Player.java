
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private Team team;
    private Player target;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, Team team)
    {
        this.name = name;
        this.team = team;
    }

    // post: returns team
    public Team getTeam(){
        return team;
    }

    // post: returns true if different teams, false if same team
    public boolean diffTeams(Player player){
        return team.equals(player.getTeam());
    }

    // returns true if different teams, false if same team
    public boolean diffTeams(Team teamName){
        return team.equals(teamName);
    }

    // post: set target
    public void setTarget(Player player){
        target = player;
    }

    // post: returns target
    public Player getTarget(){
        return target;
    }

    // post: return name
    public String getName(){
        return name;
    }

    // post: return true if same object, false if different
    public boolean equals(Player player){
        return this.name == player.getName();
    }
}
