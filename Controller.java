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
    RandomCircularList list;
    Boolean showGroup;

    // CONSTRUCTOR
    public Controller(Window ui)
    {
        this.ui = ui;
        groups = new ArrayList<Group>();
        selectedGroup = null;
        selectedViewType = ListViewType.TARGET;
        list = null;
        showGroup = false;
    }

    // METHODS

    // Add person to selectedGroup
    // post: new person created and added to selectedGroup, rosterDisplay updated
    public void addPerson(String name)
    {
        Person person = new Person(name, selectedGroup);    // create new person
        selectedGroup.add(person);                          // add person to selectedGroup

        // Update UI
        ui.updateListDisplay("");   // clear listDisplay since roster changed
        ui.updateRosterDisplay();   // update rosterDisplay
    }

    // Add group to Groups
    // post: new group created, set as selectedGroup, and added to groups
    public void addGroup(String groupName)
    {
        Group group = new Group(groupName);     // create new group
        groups.add(group);                      // add group to groups
        selectedGroup = group;                  // set group as selectedGroup
        ui.addGroupToComboBox(group);           // update ComboBox
    }

    // Get groups
    // post: returns List<Group> groups
    public List<Group> getGroups()
    {
        return groups;
    }

    // Set the selectedGroup
    // post: sets selectedGroup as group, rosterDisplay updated
    public void setSelectedGroup(Group group)
    {
        selectedGroup = group;      // set selectedGroup as group

        // Update UI
        ui.updateRosterDisplay();   // update rosterDisplay
    }

    // Get selectedGroup
    // post: returns selectedGroup
    public Group getSelectedGroup()
    {
        return selectedGroup;
    }

    // Remove current selectedGroup
    // post: removes selectedGroup from groups and returns its index
    private int removeSelectedGroup()
    {
        // Scans through groups until it finds selectedGroup
        // Removes selectedGroup from groups
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

    // Set the roster for selectedGroup
    // pre: editedRoster is a string, with each person's name on a seperate line
    // post: selectedGroup's roster is set as the inputted string
    public void setSelectedGroupRoster(String editedRoster)
    {
        // Convert editedRoster into an array of names (strings)
        // Splits editedRoster at each new line and skips empty lines
        String[] lines = editedRoster.split("[\\r\\n]+");

        selectedGroup.setRoster(lines);   // sets selectedGroups roster as the new array

        // uUpdate UI
        ui.updateRosterDisplay();   // update rosterDisplay
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
        // Creates addGroupPopUp, which returns the groupName
        String groupName = ui.addGroupPopUp();

        // If group name is not null, create a new group
        if(groupName != null)
        {
            addGroup(groupName);
            ui.enableComponents(true);
        }

        // Update UI
        ui.updateListDisplay("");   // clear listDisplay
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

        // Update UI
        ui.updateListDisplay("");   // clear listDisplay
    }

    /**
     *  Starts the process to rename a group
     *      First the renameGroupPopUp is called
     *      If a name is inputted, then the group will be renamed to that name
     */
    public void renameGroupClicked()
    {
        // Creates renameGroupPopUP and returns the updatedName
        String updatedName = ui.renameGroupPopUp(selectedGroup.getGroupName());

        // If group name is not null, rename the selectedGroup
        if(updatedName != null)
        {
            selectedGroup.setGroupName(updatedName);    // set selectedGroup's name
            setSelectedGroup(selectedGroup);            // updates rosterDisplay to show correct title border
        }

        // Update UI
        ui.updateListDisplay(getSelectedViewText());    // update listDisplay
    }

    /**
     *  Starts the process to edit a group's roster
     *      editRosterPopUp is called and handles the rest
     *      then clears listDisplay since the roster changed
     */
    public void editRosterClicked()
    {
        // Creates editRosterPopUp
        ui.editRosterPopUp(selectedGroup);

        // Update UI
        ui.updateListDisplay("");   // clear listDisplay since roster changed
    }

    /**
     *  Starts the process to generate a random list
     *      generates a RandomCircularList from the groups
     *      updates listDisplay with the new random list
     */
    public void generateListClicked()
    {
        // Check to make sure all groups have at least one person in them
        Boolean groupsValid = true;
        for(Group group: groups)
        {
            if(group.size() == 0)
            {
                groupsValid = false;
            }
        }

        // If the groups are valid, generate a list and update the UI
        if(groupsValid)
        {
            // Create new random list
            list = new RandomCircularList(groups);

            // Update UI
            ui.updateListDisplay(getSelectedViewText());    // sets listDisplay to the random list
        } else {
            ui.generateListErrorPopUp();
        }
    }

    // Enable or disable the UI
    // post: if enable is true all components are enabled, else they are disabled
    public void enableUI(boolean enable)
    {
        ui.enableUI(enable);
    }

    // Set the selectedView type
    // post: selectedViewType is set as viewType and listDisplay is updated
    public void setSelectedViewType(ListViewType viewType)
    {
        selectedViewType = viewType;

        // checks to make sure there is a list
        if(list != null)
        {
            ui.updateListDisplay(getSelectedViewText());
        }
    }

    // Get a text version of the list based off selectedViewType
    // post: returns a string of the random list, in the format of the selectedViewType
    private String getSelectedViewText()
    {
        return list.getText(selectedViewType, showGroup);
    }

    // Toggles whether showGroup is checked or not
    // post: showGroup is set to the state that it is in on the UI
    public void showGroupChecked(Boolean checked)
    {
        showGroup = checked;

        // checks to make sure there is a list
        if(list != null)
        {
            ui.updateListDisplay(getSelectedViewText());
        }
    }

    // Open website URL
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
