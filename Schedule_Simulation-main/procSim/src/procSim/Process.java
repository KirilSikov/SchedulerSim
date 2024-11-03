// Enrik Rushiti & Kiril Sikov
package application;
// Enrik Rushiti & Kiril Sikov
/**
 * The following is the implementation of the
 * "processes" within the scheduling simulator.
 * Processes contain burst time, which decrement
 * down by one as long as it stays within the processing
 * of the "cpu".
 *
 */
public class Process {
    private Integer burstTime;
    private Integer pid;
    private Integer priority;
    private Integer waitingTime;
    private Integer turnaroundTime;

    public Process(int burst) {
        this.burstTime = burst;
        this.pid = 0;
        this.priority = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    public Process() {
        this.burstTime = 0;
        this.pid = 0;
        this.priority = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    public void decrementBurstTime() {
        this.burstTime = this.burstTime -1;
    }

    public Integer getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Integer getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
}