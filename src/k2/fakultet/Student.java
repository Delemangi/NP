package k2.fakultet;

import java.util.*;
import java.util.stream.*;

public class Student {
    private final String ID;
    private final int yearsOfStudies;
    private final Map<Integer, List<Grade>> grades;

    public Student(String ID, int yearsOfStudies) {
        this.ID = ID;
        this.yearsOfStudies = yearsOfStudies;
        this.grades = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Student: %s%n", ID));

        int terms = yearsOfStudies == 3 ? 6 : 8;

        for (int i = 1; i <= terms; i++) {
            sb.append(String.format("Term %d%n", i));

            List<Grade> list = grades.get(i);

            if (list != null) {
                sb.append(String.format("Courses: %d%n", list.size()));
                sb.append(String.format("Average grade for term: %.2f%n", list
                        .stream()
                        .mapToInt(Grade::getGrade)
                        .average()
                        .orElse(0)));
            } else {
                sb.append("Courses: 0\n");
                sb.append("Average grade for term: 5.00\n");
            }
        }

        sb.append(String.format("Average grade: %.2f%n", getAverage()));
        sb.append(String.format("Courses attended: %s", grades
                .values()
                .stream()
                .flatMap(list -> list
                        .stream()
                        .map(Grade::getCourse))
                .sorted(String::compareTo)
                .collect(Collectors.joining(","))));

        return sb.toString();
    }

    public void addGrade(int term, String course, int grade) throws OperationNotAllowedException {
        grades.putIfAbsent(term, new ArrayList<>());

        if (grades.get(term).size() == 3) {
            throw new OperationNotAllowedException(ID, term);
        }

        if ((yearsOfStudies == 3 && term > 6) || (yearsOfStudies == 4 && term > 8)) {
            throw new OperationNotAllowedException(term, ID);
        }

        grades.get(term).add(new Grade(term, course, grade));
    }

    public double getAverage() {
        return grades
                .values()
                .stream()
                .flatMapToDouble(list -> list
                        .stream()
                        .mapToDouble(Grade::getGrade))
                .average()
                .orElse(0);
    }

    public int getPassed() {
        return grades
                .values()
                .stream()
                .mapToInt(List::size)
                .sum();
    }

    public String getID() {
        return ID;
    }

    public int getYearsOfStudies() {
        return yearsOfStudies;
    }
}