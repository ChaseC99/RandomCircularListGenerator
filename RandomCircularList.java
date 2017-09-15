/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  Creates a circular list of players.
 *  The list is essentially a linked list. Each person is a node.
 *  Each person class is assigned a target, so it knows who the next node is
 *
 *  The program will try to make it so that no two players on the same group will be directly next to eachother on the list
 *  If this cannot be done, a normal randomized list will be made instead
 *
 *  INSTANCE VARIABLES
 *      List<Group> groups              // list groups that will included in the circular list
 *      Person firstPeron               // considered the "starting" point for the circular list
 *      Person lastPerson               // considered the "ending" point for the circular list
 *      int attempts                    // represents the amount of times createList() has been attempted
 *      boolean hasSameGroupConflict    // represents whether the list has a same group conflict
 *
 *  METHODS
 *      // Methods for creating the list
 *      createList()                                    // creates the circlular linked list, telling each person who its next target is
 *      copyListOfGroups(List<Group>) -> List<Group>    // return copy of a list of Group objects
 *      copyListFromGroup(Group) -> List<Person>        // return copy of list of Person objects
 *      randomlySelectGroup(List<Group>)                // randomly selects group form a list of groups
 *      removeRandomPerson(Group)                       // randomly selects, removes, and returns a person from a group
 *      removeRandomPerson(List<Group>)                 // randomly selects, removes, and returns a person from a random group in a list of groups
 *      getLastPerson() -> Person                       // returns last person in the list
 *
 *      // Methods for displaying the list
 *      getText(ListViewType, boolean) -> String        // returns a string of the list in the requested viewType
 *      getTargetViewText(boolean) -> String            // returns a list of everyone's first target with option to show people's group
 *                                                              Ex: One "Person -> Target" per line
 *      getListViewText(boolean) -> String              // returns a list of everyone and who they are targeting with option to show people's group
 *                                                              Ex: "x --> y --> z --> a --> b --> c --> x"
 *      getNumberViewText(boolean) -> String            // returns a numbered list of everyone's name with option to show people's group
 *                                                              Ex: 1. Person Name /n 2. Next Name
 *      printFirstTargets()                             // prints to console a list of everyone's first target.
 *                                                              Ex: One "Person -> Target" per line
 *      printList()                                     // prints to console a list of everyone and who they are targeting
 *                                                              Ex: "x --> y --> z --> a --> b --> c --> x"
 *      printGroup(Group)                               // prints to console a list of the group's players
 *                                                              Ex: "GroupName/n - name1 /n -name2 /n" etc
 *      printAllGroups()                                // runs printGroup(Group) method for all groups in the list
 *
 *      // Other informational methods
 *      getNumPeople() -> int                           // returns number of people in the game
 *      getNumPeopleInList() -> int                     // returns number of people in the list
 *      sameGroupConflicts() -> int                     // returns number of times people on the same group are next to eachother
 *      hasSameGroupConflict() -> boolean               // returns hasSameGroupConflict
 */

import java.util.*;     // Import List
public class RandomCircularList
{
    // instance variables
    public List<Group> groups;                      // list groups that will included in the circular list
    public Person firstPerson;                      // considered the "starting" point for the circular list
    public Person lastPerson;                       // considered the "ending" point for the circular list
    private int attempts = 0;                       // represents the amount of times createList() has been attempted
    private boolean hasSameGroupConflict = false;   // represents whether the list has a same group conflict

    /**
     * Constructor for objects of class RandomCircularList
     */
    public RandomCircularList(List<Group> groups)
    {
        this.groups = groups;                   // sets groups variable
        firstPerson = groups.get(0).get(0);     // establishes first player on the first group as first player
        createList();                           // creates the random circular linked list and instantiates lastPerson
    }

    /**
     *  This method creates the circlular linked list, telling each person who its next target is
     *
     *  pre: the groups have players loaded onto them
     *  post: each player is assigned a target, lastPerson = lastPerson in the list
     */
    public void createList(){
        // Create a list with no same group conflicts
        // If it cannot do this after 200 attempts, it will create a normal randomized list
        if(groups.size() >= 3 && attempts < 200){
            // Make a copy of groups
            List<Group> groupsCopy = copyListOfGroups(groups);

            // Establish start of loop
            firstPerson = removeRandomPerson(groupsCopy);

            // Set up for while loop
            Person player = firstPerson;                        // variable for the while loop representing the player getting assigned a target
            Group lastTargetGroup = firstPerson.getGroup();     // sets lastTargetGroup as the first players group
            Group targetGroup;                                  // declares targetGroup
            Person target;                                      // declares target

            // Randomly assign player targets
            while(groupsCopy.size() > 1){
                // Randomly gives the Person a group that is different from his own
                // post: targetGroup is a group different that the previous player's
                do{
                    targetGroup = randomlySelectGroup(groupsCopy);
                } while(targetGroup == lastTargetGroup);

                // Give player a random target from his/her targetGroup
                target = removeRandomPerson(targetGroup);       // randomly removes a person from the target group
                player.setTarget(target);                       // set player's target

                // If the targetGroup is now empty, take the group out of the groupsCopy List
                if(targetGroup.size() == 0){
                    // remove group from list
                    int index = groupsCopy.indexOf(targetGroup);
                    groupsCopy.remove(index);
                }

                lastTargetGroup = targetGroup;      // updates last group
                player = target;                    // target now gets assigned their target
            }

            /*
             *  After the while loop there is usually one group left
             *  The remaining players must be inserted into the list
             *  It runs through the linked list until it finds a pair of people who are different groups
             *  The player is inserted inbetween the two people
             */

            // Establishes which group is left
            Group groupLeft = groupsCopy.get(0);                   // get group List
            List<Person> peopleLeft = groupLeft.getRoster();       // get list of remaining people from groupLeft

            // Assign targets to remaining players on groupLeft
            for(Person thisPerson: peopleLeft)
            {
                // Starts search at the beginning of the list
                Person player1 = firstPerson;               // sets firstPerson as starting point for the loop
                Person player2 = player1.getTarget();       // sets player2 based off of firstPerson's target
                boolean inserted = false;                   // false until the player is added into the list

                // runs until player inserted
                while(!inserted)
                    {
                        if(player1.getGroup().equals(groupLeft) || player2.getGroup().equals(groupLeft))    // if player is on same group as target
                        {
                            // move to next player
                            player1 = player2;
                            player2 = player1.getTarget();
                        } else  // if player is on different group as target
                        {
                            // insert player
                            player1.setTarget(thisPerson);  // set previous player target as thisPerson
                            thisPerson.setTarget(player2);  // set thisPerson's target to previous player's target
                            inserted = true;
                        }
                }
            }

            // get last person in the list
            lastPerson = getLastPerson();

            // check to make sure lastPerson and firstPerson aren't on the same group
            if(!lastPerson.getGroup().equals(firstPerson.getGroup())){
                lastPerson.setTarget(firstPerson);  // sets last person's target as first person
            } else {
                // if they are on the same group, rerun createList and try again
                createList();
            }

            attempts++;

            // check to make sure no people next to eachother are on the same group
            if(sameGroupConflicts() != 0){
                // if people are on the same group, rerun creatList and try again
                createList();
            }
        } else {
            /**
             *  If it cannot create a list with no same group conflicts,
             *  it will create a normal randomized list
             */

            // Make a copy of groups
            List<Group> groupsCopy = copyListOfGroups(groups);

            // Establish start of loop
            firstPerson = removeRandomPerson(groupsCopy);
            // Remove firstPerson's group from groups
            // if they were the only person in the group
            if(firstPerson.getGroup().size() == 0){
                int index = groupsCopy.indexOf(firstPerson.getGroup());
                groupsCopy.remove(index);
            }

            // Set up for while loop
            Person player = firstPerson;                        // variable for the while loop representing the player getting assigned a target
            Group lastTargetGroup = firstPerson.getGroup();     // sets lastTargetGroup as the first players group
            Group targetGroup;                                  // declares targetGroup
            Person target;                                      // declares target

            // Randomly assign player targets
            while(groupsCopy.size() > 0){

                targetGroup = randomlySelectGroup(groupsCopy);

                // Give player a random target from his/her targetGroup
                target = removeRandomPerson(targetGroup);   // randomly removes a person from the target group
                player.setTarget(target);                   // set player's target

                // If the targetGroup is now empty, take the group out of the groupsCopy List
                if(targetGroup.size() == 0){
                    // remove group from list
                    int index = groupsCopy.indexOf(targetGroup);
                    groupsCopy.remove(index);
                }

                lastTargetGroup = targetGroup;      // updates last group
                player = target;                    // target now gets assigned their target
            }

            player.setTarget(firstPerson);
        }

        // If there is any same group conflicts, set hasSameGroupConflict to true
        if(sameGroupConflicts() != 0){
            hasSameGroupConflict = true;
        }
    }

    /**
     *  This method takes a list of groups and returns a copy of that list
     *  The copy is a new object, seperate from the original
     *
     *  post: return copy of a list of groups
     */
    private List<Group> copyListOfGroups(List<Group> original){
        // Create list
        List<Group> copy = new ArrayList<Group>();

        // Create new group and add group to the list
        for(Group group: groups){
            List<Person> groupListCopy = copyListFromGroup(group);
            Group groupCopy = new Group(group.getGroupName(), groupListCopy);
            copy.add(groupCopy);
        }

        // Return list
        return copy;
    }

    /**
     *  This method takes a list Person objects and returns a copy of that list
     *  The copy is a new object, seperate from the original
     *
     *  post: return copy of a list of Person objects
     */
    private List<Person> copyListFromGroup(Group group){
        List<Person> newList = new ArrayList<Person>();
        List<Person> oldList = group.getRoster();

        for(Person i: oldList){
            newList.add(new Person(i.getName(), i.getGroup()));
        }

        return newList;
    }

    /**
     *  This method randomly selects a group from a list of groups.
     *
     *  pre: listOfGroup.size() >= 1
     *  post: return random group
     */
    private Group randomlySelectGroup(List<Group> listOfGroups){
        Group group;        // Group to be returned

        Random rand = new Random();
        int groupIndex = rand.nextInt(listOfGroups.size());     // random index in listOfGroups to pick random group
        group = listOfGroups.get(groupIndex);                   // get group from list based off groupIndex

        return group;       // return group
    }

    /**
     *  This method randomly selects a player from a group.
     *  The player is removed from the group and returned
     *
     *  pre: group.size() >= 1
     *  post: random player is removed and returned
     */
    private Person removeRandomPerson(Group group){
        Person target;          // Person to be returned

        Random r = new Random();
        int i = r.nextInt(group.size());         // random index in the targetGroup List to pick random person in the group
        target = group.getRoster().remove(i);    // set target as player at random index of targetGroup and takes them out of the list

        return target;          // return target
    }

    /**
     *  This method randomly selects a player from a group from a list of groups.
     *  The player is removed from the group and returned.
     *
     *  pre: groups.size() >= 1 && group.size() >= 1
     *  post: random player is removed and returned
     */
    private Person removeRandomPerson(List<Group> groups){
        Group targetGroup = randomlySelectGroup(groups);        // Group from which person is selected

        Person target = removeRandomPerson(targetGroup);        // Person to be returned

        // Remove firstPerson's group from groups
        // if they were the only person in the group
        if(targetGroup.size() == 0){
            int index = groups.indexOf(targetGroup);
            groups.remove(index);
        }

        return target;          // return target
    }

    /**
     *  Parse through the list to find the person at the end
     *
     *  pre: circular list has been created, firstPerson != null
     *  post: last person in the list is returned
     */
    private Person getLastPerson(){
        // parse the list to get the lastPerson
        Person lastPerson = firstPerson;        // starts loop at firstPerson

        // post: lastPerson is now the last player in the linked list
        while(lastPerson.getTarget() != null) {
            lastPerson = lastPerson.getTarget();
        }

        // return lastPerson
        return lastPerson;
    }

    // Message for when there is a same group conflict
    private String sameGroupConflictMessage =
        "Warning: Two or more people from the same group are placed next to each other.";

    /**
     *  This method is called by the controller
     *  The viewType is passed through along with whether or not withGroup should be displayed
     *  It runs through a switch statement of viewTypes, returning a string of the right viewType
     *  Then, if there is a same group conflict, a warning message is thrown on the end
     *
     *  post: returns a string of the list in the requested viewType
     */
    public String getText(ListViewType viewType, boolean withGroup){
        String listText = "";

        switch(viewType){
            case TARGET:
                listText = getTargetViewText(withGroup);
                break;
            case LIST:
                listText = getListViewText(withGroup);
                break;
            case NUMBER:
                listText = getNumberViewText(withGroup);
                break;
        }

        // If there is a same group conflict add on the warning message
        if(hasSameGroupConflict){
            listText += "\n\n" + sameGroupConflictMessage;
        }

        return listText;
    }

    /**
     *  returns a list of everyone's first target
     *  example:
     *      x --> y
     *      y --> z
     *      z --> a
     */
    private String getTargetViewText(boolean withGroup){
        String listText = "";
        Person hunter = firstPerson;
        Person target = hunter.getTarget();

        do{
            listText += hunter.getName();
            if(withGroup){
                listText += " ( " + hunter.getGroup().getGroupName().substring(0,1) + " )";
            }

            listText += " --> " + target.getName();
            if(withGroup){
                listText += " ( " + target.getGroupName().substring(0,1) + " )";
            }

            listText += "\n";
            hunter = target;
            target = hunter.getTarget();
        }while(!hunter.equals(firstPerson));

        return listText;
    }

    /**
     *  returns a list of everyone and who they are targeting
     *  example:
     *      x --> y --> z --> a --> b --> c --> x
     */
    private String getListViewText(boolean withGroup){
        String listText = "";

        Person temp = firstPerson;
        do{
            listText += temp.getName();
            if(withGroup){
                listText += " ( " + temp.getGroupName().substring(0,1) + " )";
            }
            listText += " --> ";
            temp = temp.getTarget();
        } while (!temp.equals(firstPerson));
        listText += firstPerson.getName();
        if(withGroup){
            listText += " ( " + firstPerson.getGroupName().substring(0,1) + " )";
        }

        return listText;
    }

    /**
     *  returns a numbered list of everyone's name
     *  example:
     *      1. x
     *      2. y
     *      3. z
     */
    private String getNumberViewText(boolean withGroup){
        String listText = "";

        Person temp = firstPerson;
        int i = 1;
        do{
            listText += i + ". " + temp.getName();
            if(withGroup){
                listText += " ( " + temp.getGroupName().substring(0,1) + " )";
            }
            listText += "\n";
            temp = temp.getTarget();
            i++;
        } while(!temp.equals(firstPerson));

        return listText;
    }

    /**
     *  prints a list of everyone's first target
     *  example:
     *      x --> y
     *      y --> z
     *      z --> a
     */
    public void printFirstTargets(){
        System.out.println("FIRST TARGETS");
        System.out.println();

        Person hunter = firstPerson;
        Person target = hunter.getTarget();

        do{
            System.out.println(hunter.getName() + " ( " + hunter.getGroup().getGroupName().substring(0,1) + " )" + " --> " + target.getName() + " ( " + target.getGroupName().substring(0,1) + " )");
            hunter = target;
            target = hunter.getTarget();
        }while(!hunter.equals(firstPerson));

        System.out.println();
    }

    /**
     *  prints a list of everyone and who they are targeting
     *  example:
     *      x --> y --> z --> a --> b --> c --> x
     */
    public void printList(){
        System.out.println("ORIGINAL TARGETS");
        System.out.println();
        Person temp = firstPerson;
        do{
            System.out.print(temp.getName() + " --> ");
            temp = temp.getTarget();
        } while (!temp.equals(firstPerson));
        System.out.print(firstPerson.getName());
        System.out.println();
    }

    /**
     *  prints a list of the group's players
     *  example:
     *      group
     *       - a
     *       - b
     *       - c
     */
    public void printGroup(Group group){
        System.out.println(group.getGroupName());
        List<Person> people = group.getRoster();
        for(Person person: people){
            System.out.println(" - " + person.getName());
        }
        System.out.println();   // gap for readability
    }

    /**
     *  prints all group rosters using printGroup method
     */
    public void printAllGroups(){
        for(Group group: groups){
            printGroup(group);
        }
    }

    /**
     *  post: returns number of players in the game
     */
    public int getNumPeople(){
        int sum = 0;

        for(Group group: groups){
            sum += group.size();
        }

        return sum;
    }

    /**
     *  post: returns number of players in the list
     */
    public int getNumPeopleInList(){
        int sum = 0;

        Person i = firstPerson;

        do{
            sum++;
            i = i.getTarget();
        }while(i != firstPerson);

        return sum;
    }

    /**
     *  Counts and returns the number of times people on the same group are next to eachother
     *
     *  pre: circular linked list is created
     *  post: returns number of times people on the same group are next to eachother
     */
    public int sameGroupConflicts(){
        int count = 0;

        Person i = firstPerson.getTarget();
        Group previousGroup = firstPerson.getGroup();
        do{
            if(i.getGroup().equals(previousGroup)){
                count++;
            }

            previousGroup = i.getGroup();
            i = i.getTarget();
        }while(i != firstPerson);

        return count;
    }

    /**
     *  post: returns hasSameGroupConflict
     */
    public boolean hasSameGroupConflict(){
        return hasSameGroupConflict;
    }
}
