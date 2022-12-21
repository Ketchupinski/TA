package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose there are n applications for classes in the same classroom.
 * Two different classes cannot overlap in time.
 * Each request contains the beginning and the end of the lesson (si and fi for the i-th request).
 * Different requests may overlap, and then only one of them can be satisfied.
 * The lesson lasts 90 minutes divided into 45 minutes for half pairs, a break for 10 minutes break.
 * There can be no more than 6 lessons per day.
 * Solve this problem using the Greedy algorithm.
 */
public class FirstApplicationTask {
    private final int maxApplications;
    private final int duration;
    private final int lessonsBreak;

    private final List<Application> applications = new ArrayList<>();

    public FirstApplicationTask(int maxApplications, int duration, int lessonsBreak) {
        this.maxApplications = maxApplications;
        this.duration = duration;
        this.lessonsBreak = lessonsBreak;
    }

    public void generateApplication() {
        applications.add(new Application(0, duration));
        applications.add(new Application(70, duration));
        applications.add(new Application(120, duration));
        applications.add(new Application(200, duration));
        applications.add(new Application(240, duration));
        applications.add(new Application(300, duration));
        applications.add(new Application(320, duration));
        applications.add(new Application(380, duration));
        applications.add(new Application(400, duration));
        applications.add(new Application(450, duration));
        applications.add(new Application(460, duration));
        applications.add(new Application(500, duration));
        applications.add(new Application(520, duration));
        applications.add(new Application(560, duration));
        applications.add(new Application(600, duration));
        applications.add(new Application(620, duration));
        applications.add(new Application(660, duration));
        applications.add(new Application(700, duration));
        applications.add(new Application(720, duration));
        applications.add(new Application(760, duration));
        applications.add(new Application(800, duration));
        applications.add(new Application(820, duration));
        applications.add(new Application(860, duration));
        applications.add(new Application(900, duration));
        applications.add(new Application(920, duration));
        applications.add(new Application(960, duration));
        applications.add(new Application(1000, duration));
    }

    public void printAllApplications() {
        for (Application application : applications) {
            System.out.println(application);
        }
    }

    /**
     * Problem solution using the Greedy algorithm.
     * Algorithm:
     * 1. Sort the applications by the end time.
     * 2. Select the first applications.
     * 3. Select the next application that does not overlap with the previous one.
     * 4. Repeat step 3 until there are no more applications or the maximum number of applications is reached.
     * 5. Return the selected applications.
     * Main idea:
     * The algorithm selects the applications that end first. If the next application does not overlap with the previous one,
     * then it is selected. If the next application overlaps with the previous one, then it is not selected.
     * @return List of selected applications.
     */
    public List<Application> solve() {
        List<Application> selectedApplications = new ArrayList<>();
        applications.sort(Comparator.comparingInt(Application::getEnd));
        int i = 0;
        while (i < applications.size() && selectedApplications.size() < maxApplications) {
            if (selectedApplications.isEmpty()) {
                selectedApplications.add(applications.get(i));
            } else {
                if (applications.get(i).getStart() >= selectedApplications.get(selectedApplications.size() - 1).getEnd() + lessonsBreak) {
                    selectedApplications.add(applications.get(i));
                }
            }
            i++;
        }
        return selectedApplications;
    }
}

