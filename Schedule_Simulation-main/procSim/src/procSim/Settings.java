// Enrik Rushiti & Kiril Sikov
package application;

public class Settings {
    private int maxProcesses;
    private int maxBurstTime;

    public Settings() {
        this.maxProcesses = 0;
        this.maxBurstTime = 0;
    }

    public Settings(int maxProcesses, int maxBurstTime) {
        this.maxProcesses = maxProcesses;
        this.maxBurstTime = maxBurstTime;
    }

    public int getMaxProcesses() {
        return maxProcesses;
    }

    public void setMaxProcesses(int maxProcesses) {
        this.maxProcesses = maxProcesses;
    }

    public int getMaxBurstTime() {
        return maxBurstTime;
    }

    public void setMaxBurstTime(int maxBurstTime) {
        this.maxBurstTime = maxBurstTime;
    }
}