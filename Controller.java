/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  This is the controller, which runs the whole program.
 */

import java.util.*;     // import lists
import java.awt.Desktop;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
//import j
public class Controller
{
    // Instance Variables
    Window ui;
    List<Group> groups;
    Group selectedGroup;
    ListViewType selectedViewType;
    int i = 0;

    // Constructor
    public Controller(Window ui)
    {
        this.ui = ui;
        groups = new ArrayList<Group>();
        selectedGroup = null;
        selectedViewType = ListViewType.SINGLE_NEXT;
    }

    public void addGroup(String groupName)
    {
        Group group = new Group(groupName + i);
        i++;
        groups.add(group);
        selectedGroup = group;
        ui.addGroupToComboBox(group);
    }

    public void addPerson(String name)
    {
        Person person = new Person(name, selectedGroup);
        selectedGroup.add(person);
        ui.updateRosterDisplay(selectedGroup.getListAsArray());
    }

    public List<Group> getGroups()
    {
        return groups;
    }

    public void setSelectedGroup(Group group)
    {
        selectedGroup = group;
        // When there are no group
        if(selectedGroup != null){
            ui.updateRosterDisplay(group.getListAsArray());
        } else {
            ui.clearRosterDisplay();
        }
    }

    public void removeGroupClicked(){
        boolean response = ui.removeGroupPopUp(selectedGroup);
        if(response){
            int groupIndex = removeSelectedGroup();
            ui.removeGroupFromComboBox(groupIndex);

            if(groups.size() == 0){
                selectedGroup = null;
                ui.enableComponents(false);
            }
        }
    }

    public int removeSelectedGroup()
    {
        for(int i = 0; i < groups.size(); i++)
        {
            if(groups.get(i) == selectedGroup)
            {
                groups.remove(i);
                return i;
            }
        }

        return -1;
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
