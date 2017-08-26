/** RandomCircularListGenerator
 *  @author Chase Carnaroli
 *
 *  This is the main, which sets up the whole program.
 */

public class RandomCircularListGenerator
{
    // Instance Variables
    private static Window ui;
    private static Controller controller;

    // Constructor
    public static void main(String[] args)
    {
        ui = new Window();
        controller = new Controller(ui);
        ui.setController(controller);
    }
}
