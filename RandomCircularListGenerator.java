/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  This is the main, which sets up the whole program.
 */

 import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RandomCircularListGenerator
{
    // Instance Variables
    private static Window ui;
    private static Controller controller;

    // Constructor
    public static void main(String[] args)
    {
        // Set Look and Feel of Program
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }



        // Start the program up
        ui = new Window();                  // Create Window
        controller = new Controller(ui);    // Create controller
        ui.setController(controller);       // Set window's controller
    }
}
