/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  This is the controller, which runs the whole program.
 */

import java.util.*;     // import lists
import java.awt.Desktop;
import java.net.*;
import java.io.*;
//import j
public class Controller
{
    // Instance Variables
    Window ui;
    List<Team> groups;
    Team selectedGroup;
    ListViewType selectedViewType;

    // Constructor
    public Controller(Window ui)
    {
        this.ui = ui;
        groups = new ArrayList<Team>();
        selectedGroup = null;
        selectedViewType = ListViewType.SINGLE_NEXT;
    }

    public void addGroup(String groupName)
    {
        groups.add(new Team(groupName));
    }

    public List<Team> getGroups()
    {
        return groups;
    }

    public void setSelectedGroup(Team group)
    {
        selectedGroup = group;
    }

    public void setSelectedViewType(ListViewType viewType)
    {
        selectedViewType = viewType;
        // TODO: update list display
    }


    public void openWebsite(String website)
    {
        try {
            if(Desktop.isDesktopSupported())
            {
                Desktop.getDesktop().browse(new URI(website));
            }
        } catch (URISyntaxException e){

        } catch (IOException e){}
    }
}
