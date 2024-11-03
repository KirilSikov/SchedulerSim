// Enrik Rushiti & Kiril Sikov
package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulator {

    static List<Process> createProcList(Settings usrRules) {
        List<Process> ls = new ArrayList<>();
        Process proc = new Process();

        ArrayList priorities = new ArrayList<>();
        // fill up the priorities array with to match number of processes
        for (int j = 0; j < usrRules.getMaxProcesses(); j++) {
            priorities.add(j + 1);
        }

        // shuffle the priorities array so each process has a random priority
        Collections.shuffle(priorities);

        for (int i = 0; i < usrRules.getMaxProcesses(); i++) {
            proc = createProc(usrRules.getMaxBurstTime());
            proc.setPid(i + 1);
            proc.setPriority((int) priorities.get(i));

            ls.add(proc);
        }

        return ls;
    }

    @SuppressWarnings("unused")
    private static Settings getSettings() {
        Settings usrinp = new Settings();
        Scanner inp = new Scanner(System.in);

        System.out.println("What is the maximum processes in the Simulation?");
        usrinp.setMaxProcesses(inp.nextInt());

        System.out.println("What is the maximum burst time for a process?");
        usrinp.setMaxBurstTime(inp.nextInt());

        inp.close();
        return usrinp;
    }

    // generate a random process with a random burst time
    public static Process createProc(int maxBurstTime) {
        int burstTime = new Random().nextInt(maxBurstTime) + 1; // between 1 and 10
        Process proc = new Process(burstTime);
        return proc;
    }

    /*
     * First Come First Serve Scheduling Algorithm
     * - Processes are executed in the order they arrive in the ready queue
     */
    public static void FCFS(List<Process> listOfProcesses) {
        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }
    }

    /*
     * Shortest Job First Scheduling Algorithm
     * - Processes are executed in order of their burst time
     */
    public static void SJF(List<Process> listOfProcesses) {
        // Sort the list of processes by burst time
        Collections.sort(listOfProcesses, new BurstTimeComparator());

        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }
    }

    /*
     * Priority Scheduling Algorithm
     * - Processes are executed in order of their priority
     */
    public static void Priority(List<Process> listOfProcesses) {
        // Sort the list of processes by priority
        Collections.sort(listOfProcesses, new PriorityComparator());

        for (int i = 0; i < listOfProcesses.size(); i++) {
            Process currentProc = listOfProcesses.get(i);

            // For processes with a pid > 1
            if (i != 0) {
                Process prevProc = listOfProcesses.get(i - 1);
                currentProc.setWaitingTime(prevProc.getWaitingTime() + prevProc.getBurstTime());
                currentProc.setTurnaroundTime(currentProc.getWaitingTime() + currentProc.getBurstTime());
            }
            // For the first process
            else {
                currentProc.setWaitingTime(0);
                currentProc.setTurnaroundTime(currentProc.getBurstTime());
            }
        }
    }

    /*
     * Round Robin Scheduling Algorithm
     * - Processes are executed in order of their arrival
     * - Each process is given a time quantum of 4ms
     * - If a process is not finished after its time quantum, it is moved to the end of the ready queue
     */
    public static void RR(List<Process> listOfProcesses) {
        int timeQuantum = 4;
        int time = 0;
        int numOfProcesses = listOfProcesses.size();
        int[] remainingBurstTime = new int[numOfProcesses];
        int[] waitingTime = new int[numOfProcesses];
        int[] turnaroundTime = new int[numOfProcesses];

        // Copy the burst times of each process into the remainingBurstTime array
        for (int i = 0; i < numOfProcesses; i++) {
            remainingBurstTime[i] = listOfProcesses.get(i).getBurstTime();
        }

        // While there are still processes in the ready queue
        while (true) {
            boolean done = true;

            // For each process in the ready queue
            for (int i = 0; i < numOfProcesses; i++) {
                // If the process has not finished
                if (remainingBurstTime[i] > 0) {
                    done = false;

                    // If the process has a burst time greater than the time quantum
                    if (remainingBurstTime[i] > timeQuantum) {
                        // Add the time quantum to the time
                        time += timeQuantum;
                        // Subtract the time quantum from the process' remaining burst time
                        remainingBurstTime[i] -= timeQuantum;
                    }
                    // If the process has a burst time less than or equal to the time quantum
                    else {
                        // Add the process' remaining burst time to the time
                        time += remainingBurstTime[i];
                        // Set the process' remaining burst time to 0
                        remainingBurstTime[i] = 0;

                        // Calculate the process' waiting time
                        waitingTime[i] = time - listOfProcesses.get(i).getBurstTime();
                        // Calculate the process' turnaround time
                        turnaroundTime[i] = time;
                    }
                }
            }

            // If all processes have finished
            if (done == true) {
                break;
            }
        }

        // Set the waiting time and turnaround time of each process
        for (int i = 0; i < numOfProcesses; i++) {
            listOfProcesses.get(i).setWaitingTime(waitingTime[i]);
            listOfProcesses.get(i).setTurnaroundTime(turnaroundTime[i]);
        }
    }
}