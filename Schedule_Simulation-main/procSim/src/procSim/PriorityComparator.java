package application;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Process> {

    @Override
    public int compare(Process p1, Process p2) {
        if(p1.getPriority() == p2.getPriority()) {
            return 0;
        }
        else if(p1.getPriority() > p2.getPriority()) {
            return 1;
        }
        else {
            return -1;
        }

    }


}