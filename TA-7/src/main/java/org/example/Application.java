package org.example;

/**
 * Suppose there are n applications for classes in the same classroom.
 * Two different classes cannot overlap in time.
 * Each request contains the beginning and the end of the lesson (si and fi for the i-th request).
 * Different requests may overlap, and then only one of them can be satisfied.
 * The lesson lasts 90 minutes divided into 45 minutes for half pairs, a break for 10 minutes break.
 * There can be no more than 6 lessons per day.
 * Solve this problem using the Greedy algorithm.
 */
public class Application {
    private int start;
    private int duration;
    private int end;

    public Application(int start, int duration) {
        this.start = start;
        this.duration = duration;
        this.end = start + duration;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Application{" +
                "start=" + start +
                ", duration=" + duration +
                ", end=" + end +
                '}';
    }
}
