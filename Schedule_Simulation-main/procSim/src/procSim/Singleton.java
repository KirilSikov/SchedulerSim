package application;

import java.util.List;

/**
 * The following is a data preservation
 * structure meant to keep data persistent
 * through JavaFX scenes. In this instance,
 * the data being preserved is the processed
 * list of processes.
 * @author kiril
 *
 */
public class Singleton {
    private static final Singleton instance = new Singleton();

    private  List<Process> listOfProc;

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public List<Process> getList(){
        return listOfProc;
    }

    public void setList(List<Process> ls) {
        this.listOfProc = ls;
    }
}
