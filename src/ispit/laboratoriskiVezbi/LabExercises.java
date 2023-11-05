package ispit.laboratoriskiVezbi;

import java.util.*;
import java.util.stream.Collectors;

public class LabExercises {
    private final List<Student> students;

    public LabExercises() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printByAveragePoints(boolean ascending, int n) {
        Comparator<Student> comparator = Comparator
                .comparing(Student::getAveragePoints)
                .thenComparing(Student::getIndex);

        if (!ascending) {
            comparator = comparator.reversed();
        }

        students
                .stream()
                .sorted(comparator)
                .limit(n)
                .forEach(System.out::println);
    }

    public List<Student> failedStudents() {
        return students
                .stream()
                .filter(Student::isFailed)
                .sorted(Comparator
                        .comparing(Student::getIndex)
                        .thenComparing(Student::getAveragePoints))
                .collect(Collectors.toList());
    }

    public Map<Integer, Double> getStatisticsByYear() {
        List<Student> passedStudents = students.stream().filter(s -> !s.isFailed()).collect(Collectors.toList());

        return passedStudents.stream().collect(Collectors.groupingBy(Student::getYear, Collectors.averagingDouble(Student::getAveragePoints)));
    }
}