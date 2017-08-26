
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ChaseCarnaroli
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        addNameTextFieldListener();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewButtonGroup = new javax.swing.ButtonGroup();
        textField1 = new java.awt.TextField();
        groupsPanel = new javax.swing.JPanel();
        groupComboBox = new javax.swing.JComboBox<>();
        addGroupButton = new javax.swing.JButton();
        renameGroupButton = new javax.swing.JButton();
        removeGroupButton = new javax.swing.JButton();
        editRosterButton = new javax.swing.JButton();
        rosterDisplayPane = new javax.swing.JScrollPane();
        rosterDisplay = new javax.swing.JList<>();
        addPersonPane = new javax.swing.JPanel();
        addPersonButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        listPanel = new javax.swing.JPanel();
        listDisplayPane = new javax.swing.JScrollPane();
        listDisplay = new javax.swing.JTextArea();
        listWarningLabel = new javax.swing.JLabel();
        generateListButton = new javax.swing.JButton();
        listRadioButton = new javax.swing.JRadioButton();
        singleNextRadioButton = new javax.swing.JRadioButton();
        viewTypeLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        restartItem = new javax.swing.JMenuItem();
        helpItem = new javax.swing.JMenu();
        howToUseItem = new javax.swing.JMenuItem();
        reportIssueItem = new javax.swing.JMenuItem();
        sourceCodeItem = new javax.swing.JMenuItem();

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random List Generator");
        setMinimumSize(new java.awt.Dimension(860, 535));
        setSize(getMinimumSize());

        groupsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Group Manager"));

        groupComboBox.setEnabled(false);
        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });

        addGroupButton.setText("Add Group");
        addGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupButtonActionPerformed(evt);
            }
        });

        renameGroupButton.setText("Rename Group");
        renameGroupButton.setEnabled(false);

        removeGroupButton.setText("Remove Group");
        removeGroupButton.setEnabled(false);
        removeGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGroupButtonActionPerformed(evt);
            }
        });

        editRosterButton.setText("Edit Roster");
        editRosterButton.setEnabled(false);

        rosterDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder("Group Roster"));
        rosterDisplay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rosterDisplay.setEnabled(false);
        rosterDisplayPane.setViewportView(rosterDisplay);

        addPersonPane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        addPersonButton.setText("Add Person");
        addPersonButton.setEnabled(false);
        addPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonButtonActionPerformed(evt);
            }
        });

        nameTextField.setForeground(new java.awt.Color(153, 153, 153));
        nameTextField.setText("Enter Name");
        nameTextField.setEnabled(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPersonPaneLayout = new javax.swing.GroupLayout(addPersonPane);
        addPersonPane.setLayout(addPersonPaneLayout);
        addPersonPaneLayout.setHorizontalGroup(
            addPersonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPersonPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        addPersonPaneLayout.setVerticalGroup(
            addPersonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPersonPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addPersonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPersonButton)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout groupsPanelLayout = new javax.swing.GroupLayout(groupsPanel);
        groupsPanel.setLayout(groupsPanelLayout);
        groupsPanelLayout.setHorizontalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addPersonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rosterDisplayPane)
                    .addGroup(groupsPanelLayout.createSequentialGroup()
                        .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupsPanelLayout.createSequentialGroup()
                                .addComponent(editRosterButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(renameGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        groupsPanelLayout.setVerticalGroup(
            groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addGroupButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeGroupButton)
                    .addComponent(editRosterButton)
                    .addComponent(renameGroupButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rosterDisplayPane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPersonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        listPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        listDisplay.setEditable(false);
        listDisplay.setColumns(20);
        listDisplay.setRows(5);
        listDisplayPane.setViewportView(listDisplay);

        listWarningLabel.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        listWarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listWarningLabel.setText("<html>\n* If there are only 2 groups or less, the list will be randomized,\n<BR>  but 2 people from the same group may be placed next to eachother.\n</html>");

        generateListButton.setText("Generate Random List");
        generateListButton.setEnabled(false);

        viewButtonGroup.add(listRadioButton);
        listRadioButton.setText("List View");
        listRadioButton.setEnabled(false);
        listRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRadioButtonActionPerformed(evt);
            }
        });

        viewButtonGroup.add(singleNextRadioButton);
        singleNextRadioButton.setSelected(true);
        singleNextRadioButton.setText("Single-Next View");
        singleNextRadioButton.setEnabled(false);
        singleNextRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleNextRadioButtonActionPerformed(evt);
            }
        });

        viewTypeLabel.setText("View Type:");

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listDisplayPane)
                            .addComponent(listWarningLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                    .addGroup(listPanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(generateListButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(listPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(singleNextRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewTypeLabel)
                    .addComponent(listRadioButton)
                    .addComponent(singleNextRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listDisplayPane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listWarningLabel)
                .addContainerGap())
        );

        fileMenu.setText("File");

        restartItem.setText("Restart");
        fileMenu.add(restartItem);

        jMenuBar.add(fileMenu);

        helpItem.setText("Help");

        howToUseItem.setText("How to Use");
        helpItem.add(howToUseItem);

        reportIssueItem.setText("Report Issue");
        reportIssueItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportIssueItemActionPerformed(evt);
            }
        });
        helpItem.add(reportIssueItem);

        sourceCodeItem.setText("Source Code");
        sourceCodeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceCodeItemActionPerformed(evt);
            }
        });
        helpItem.add(sourceCodeItem);

        jMenuBar.add(helpItem);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(860, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removeGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGroupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeGroupButtonActionPerformed

    private void addPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonButtonActionPerformed
        controller.addPerson(nameTextField.getText());
        resetNameTextField();
    }//GEN-LAST:event_addPersonButtonActionPerformed

    private void listRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRadioButtonActionPerformed
        controller.setSelectedViewType(ListViewType.LIST);
    }//GEN-LAST:event_listRadioButtonActionPerformed

    private void singleNextRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleNextRadioButtonActionPerformed
        controller.setSelectedViewType(ListViewType.SINGLE_NEXT);
    }//GEN-LAST:event_singleNextRadioButtonActionPerformed

    private void reportIssueItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportIssueItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportIssueItemActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void addGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupButtonActionPerformed
        enableComponents(true);
        createAddGroupJDialog();
    }//GEN-LAST:event_addGroupButtonActionPerformed

    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        // I tried to use .getSelectedItem() but that returned an Obj, not Group
        // So instead I had to use .getItemAt(.getSelectedIndex()) because that returned Group
        controller.setSelectedGroup(groupComboBox.getItemAt(groupComboBox.getSelectedIndex()));
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void sourceCodeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceCodeItemActionPerformed
        controller.openWebsite("https://github.com/ChaseC99/RandomCircularListGenerator");
    }//GEN-LAST:event_sourceCodeItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupButton;
    private javax.swing.JButton addPersonButton;
    private javax.swing.JPanel addPersonPane;
    private javax.swing.JButton editRosterButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton generateListButton;
    private javax.swing.JComboBox<Group> groupComboBox;
    private javax.swing.JPanel groupsPanel;
    private javax.swing.JMenu helpItem;
    private javax.swing.JMenuItem howToUseItem;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JTextArea listDisplay;
    private javax.swing.JScrollPane listDisplayPane;
    private javax.swing.JPanel listPanel;
    private javax.swing.JRadioButton listRadioButton;
    private javax.swing.JLabel listWarningLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton removeGroupButton;
    private javax.swing.JButton renameGroupButton;
    private javax.swing.JMenuItem reportIssueItem;
    private javax.swing.JMenuItem restartItem;
    private javax.swing.JList<Person> rosterDisplay;
    private javax.swing.JScrollPane rosterDisplayPane;
    private javax.swing.JRadioButton singleNextRadioButton;
    private javax.swing.JMenuItem sourceCodeItem;
    private java.awt.TextField textField1;
    private javax.swing.ButtonGroup viewButtonGroup;
    private javax.swing.JLabel viewTypeLabel;
    // End of variables declaration//GEN-END:variables

    // MY ADDITIONAL CODE, NOT GENERATED BY NETBEANS //
    
    
    
    // Controller code //
    
    // Variable to represent the Controller
    private Controller controller;
    
    // Sets the controller for the Window
    public void setController(Controller controller){
        this.controller = controller;
    }
    
    
    
    // UI Buttons
    
    public void enableComponents(boolean enable){
        groupComboBox.setEnabled(enable);
        editRosterButton.setEnabled(enable);
        renameGroupButton.setEnabled(enable);
        removeGroupButton.setEnabled(enable);
        rosterDisplay.setEnabled(enable);
        nameTextField.setEnabled(enable);
        addPersonButton.setEnabled(enable);
        generateListButton.setEnabled(enable);
        singleNextRadioButton.setEnabled(enable);
        listRadioButton.setEnabled(enable);
    }
    
    // nameTextField code //
    /*  additional functionality is given to the nameTextField
     *      - hint text is added, which says "Enter Name"
     *      - when clicked on, hint text disapears
     *      - when resetNameTextField is called, hint text reappears
     */

    // Represents whether or not the hint text is displayed
    private boolean hintTextDisplayed = true;
    
    // Adds FocuseListener to the text field
    private void addNameTextFieldListener() {        
        nameTextField.addFocusListener(new FocusListener() {
          
            @Override
            public void focusGained(FocusEvent e) {
                /*  When the text field is selected,
                *   if the hint text is displayed,
                *   then the text field is cleared, the color is set to black
                *   and hintTextDisplayed is set to false
                */
                if(hintTextDisplayed){
                    nameTextField.setText("");
                    nameTextField.setForeground(Color.black);
                    hintTextDisplayed = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                /*  When the text field is deselected,
                *   if the text field is empty,
                *   the hint text is put back in the text field
                */
                if(nameTextField.getText().length() == 0){
                    resetNameTextField();
                }
            }
        });
    }
    
    // Resets the text field and displays hint text
    // post: hint text is displayed and hintTextDisplayed is set to true
    private void resetNameTextField() {
        nameTextField.setText("Enter Name");
        nameTextField.setForeground(new Color(153, 153, 153));
        hintTextDisplayed = true;
    }
    
    
    
    // 
    private void createAddGroupJDialog(){
        controller.addGroup("Test");
    }
    
    
    // groupComboBox code //
    public void addGroupToComboBox(Group group){
        groupComboBox.addItem(group);
        groupComboBox.setSelectedItem(group);
    }
    
    
    // add single name to display
    public void updateRosterDisplay(Person[] groupRoster)
    {
        rosterDisplay.setListData(groupRoster);
        
    }

    
  
}