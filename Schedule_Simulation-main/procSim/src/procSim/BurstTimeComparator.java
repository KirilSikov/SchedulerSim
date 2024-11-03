package application;
import java.util.Comparator;

public class BurstTimeComparator implements Comparator<Process> {

    @Override
    public int compare(Process p1, Process p2) {
        if(p1.getBurstTime() == p2.getBurstTime()) {
            return 0;
        }
        else if(p1.getBurstTime() > p2.getBurstTime()) {
            return 1;
        }
        else {
            return -1;
        }

    }


}