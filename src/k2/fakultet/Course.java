package k2.fakultet;

import java.util.*;

public class Course {
    private final String name;
    private final IntSummaryStatistics summary;

    public Course(String name) {
        this.name = name;
        this.summary = new IntSummaryStatistics();
    }

    public void addGrade(int grade) {
        summary.accept(grade);
    }

    public String getName() {
        return name;
    }

    public long getStudents() {
        return summary.getCount();
    }

    public double getAverage() {
        return summary.getAverage();
    }
}