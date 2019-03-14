package info.vziks.homework2;


import info.vziks.utils.HomeWorkMain;

/**
 * Class HomeWork2
 *
 * @author Anton Prokhorov
 */
public class HomeWork2 extends HomeWorkMain {

    /**
     * @param args the input arguments
     */
    public static void main(String[] args) {
        getTasks().addCommand(new Task21Command());
        getTasks().addCommand(new Task22Command());
        getTasks().addCommand(new Task23Command());
        getTasks().addCommand(new Task24Command());
        getTasks().addCommand(new Task25Command());
        getTasks().addCommand(new Task26Command());
        getTasks().addCommand(new Task27Command());
        getTasks().addCommand(new Task28Command());
        getTasks().addCommand(new Task29Command());
        getTasks().runTasks();
    }
}
