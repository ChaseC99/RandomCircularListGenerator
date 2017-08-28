/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  This is the controller, which runs the whole program.
 */

import java.util.*;     // import lists
import java.awt.Desktop;
import java.net.*;
import java.io.*;

public class Controller
{
    // INSTANCE VARIABLES
    Window ui;
    List<Group> groups;
    Group selectedGroup;
    ListViewType selectedViewType;

    // CONSTRUCTOR
    public Controller(Window ui)
    {
        this.ui = ui;
        groups = new ArrayList<Group>();
        selectedGroup = null;
        selectedViewType = ListViewType.SINGLE_NEXT;
    }

    // METHODS

    // post: new group created, set as selectedGroup, and added to groups
    public void addGroup(String groupName)
    {
        Group group = new Group(groupName);
        groups.add(group);
        selectedGroup = group;
        ui.addGroupToComboBox(group);
    }

    // post: new person created and added to selectedGroup, rosterDisplay updated
    public void addPerson(String name)
    {
        Person person = new Person(name, selectedGroup);
        selectedGroup.add(person);
        ui.updateRosterDisplay(selectedGroup.getGroupName(), selectedGroup.getListAsArray());
    }

    // post: returns List<Group> groups
    public List<Group> getGroups()
    {
        return groups;
    }

    // post: sets selectedGroup as group, rosterDisplay updated
    public void setSelectedGroup(Group group)
    {
        // set selectedGroup as group
        selectedGroup = group;

        // update rosterDisplay
        if(selectedGroup == null)
        {
            // If there are no groups left, it will clear the rosterDisplay
            ui.clearRosterDisplay();
        } else {
            // Otherwise, rosterDisplay is updated
            ui.updateRosterDisplay(selectedGroup.getGroupName(), selectedGroup.getListAsArray());
        }
    }

    /**
     *  Starts the process to remove a group
     *      First the removeGroupPopUp is called
     *      If 'yes' is selected, then the group is removed from groups and the comboBox
     *      If there are no groups left, then the components are disabled
     */
    public void removeGroupClicked()
    {
        // Triggers removeGroupPopUp and records the response
        boolean response = ui.removeGroupPopUp(selectedGroup);

        // If the response is true remove the group, otherwise do nothing
        if(response)
        {
            // remove selectedGroup and record its index
            int groupIndex = removeSelectedGroup();
            // pass index on to remove it from the comboBox
            ui.removeGroupFromComboBox(groupIndex);

            // check to see if there are no groups left
            // if there are none, disable the components
            if(groups.size() == 0)
            {
                selectedGroup = null;
                ui.enableComponents(false);
            }
        }
    }

    // post: removes selectedGroup from groups and returns its index
    private int removeSelectedGroup()
    {
        for(int i = 0; i < groups.size(); i++)
        {
            if(groups.get(i) == selectedGroup)
            {
                groups.remove(i);
                return i;
            }
        }

        // returns -1 if selectedGroup is not in groups
        return -1;
    }

    /**
     *  Starts the process to add a group
     *      First the addGroupPopUp is called
     *      If a name is inputted, then a the new group is created and added
     *      Components will also become enabled
     *      If no name is inputted, then nothing happens
     */
    public void addGroupClicked()
    {
        String groupName = ui.addGroupPopUp();

        if(groupName != null)
        {
            addGroup(groupName);
            ui.enableComponents(true);
        }
    }

    /**
     *  Starts the process to rename a group
     *      First the renameGroupPopUp is called
     *      If a name is inputted, then the group will be renamed to that name
     */
    public void renameGroupClicked()
    {
        String updatedName = ui.renameGroupPopUp(selectedGroup.getGroupName());
        if(updatedName != null)
        {
            selectedGroup.setGroupName(updatedName);
            setSelectedGroup(selectedGroup);    // updates rosterDisplay to show correct title border
        }
    }

    // post: selectedViewType is set as viewType and listDisplay is updated
    public void setSelectedViewType(ListViewType viewType)
    {
        selectedViewType = viewType;
        // TODO: update list display
    }

    // post: website is opened in user's default browser
    public void openWebsite(String website)
    {
        try {
            if(Desktop.isDesktopSupported())
            {
                Desktop.getDesktop().browse(new URI(website));
            }
        } catch (URISyntaxException e){} catch (IOException e){}
    }
}
