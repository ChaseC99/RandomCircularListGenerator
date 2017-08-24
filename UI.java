import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame
{
    // constructor
    public UI() {
        super("Random List Generator");

        // JPanels
        JPanel playerView = new JPanel();
        playerView.setBackground(Color.BLACK);
        add(playerView);

        //add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);

        JPanel listView = new JPanel();
        listView.setBackground(Color.BLUE);
        add(listView);

        // DON'T FORGET TO INCLUDE THIS CODE - otherwise you will not
        // be able to close your application!!!
        addWindowListener(new java.awt.event.WindowAdapter()
            {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            }
        );

        // Set window size and show window
        Dimension screenSize = new Dimension(700,500);
        setMinimumSize(screenSize);     // width=500, height=400
        setVisible(true);
    }
}
