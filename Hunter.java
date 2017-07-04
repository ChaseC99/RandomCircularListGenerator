
/**
 * Write a description of class Hunter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hunter
{
    private String name;
    private Team team;
    private Hunter target;

    /**
     * Constructor for objects of class Hunter
     */
    public Hunter(String name, Team team)
    {
        this.name = name;
        this.team = team;
    }

    // post: returns team
    public Team getTeam(){
        return team;
    }
    
    // post: returns true if different teams, false if same team
    public boolean diffTeams(Hunter player){
        return team.equals(player.getTeam());
    }
    
    // returns true if different teams, false if same team
    public boolean diffTeams(Team teamName){
        return team.equals(teamName);
    }
    
    // post: set target
    public void setTarget(Hunter player){
        target = player;
    }
    
    // post: returns target
    public Hunter getTarget(){
        return target;
    }
    
    // post: return name
    public String getName(){
        return name;
    }
    
    // post: return true if same object, false if different
    public boolean equals(Hunter player){
        return this.name == player.getName();
    }
}

