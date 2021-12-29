package k2.fakultet;

import java.util.*;

public class Faculty {
    private final Map<String, Student> students;
    private final Map<String, Course> courses;
    private final List<String> logs;

    public Faculty() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.logs = new ArrayList<>();
    }

    public void addStudent(String ID, int yearsOfStudies) {
        students.put(ID, new Student(ID, yearsOfStudies));
    }

    public void addGradeToStudent(String ID, int term, String courseName, int grade) throws OperationNotAllowedException {
        try {
            students.get(ID).addGrade(term, courseName, grade);
        } catch (OperationNotAllowedException e) {
            System.out.println(e.getMessage());
        }

        Student student = students.get(ID);

        courses.putIfAbsent(courseName, new Course(courseName));
        courses.get(courseName).addGrade(grade);

        if ((student.getYearsOfStudies() == 3 && student.getPassed() == 18) || (student.getYearsOfStudies() == 4 && student.getPassed() == 24)) {
            logs.add(String.format("Student with ID %s graduated with average grade %.2f in %d years.", student.getID(), student.getAverage(), student.getYearsOfStudies()));

            students.remove(ID);
        }
    }

    public String getFacultyLogs() {
        return String.join("\n", logs);
    }

    public String getDetailedReportForStudent(String ID) {
        return students.get(ID).toString();
    }

    public void printFirstNStudents(int i) {
        students
                .values()
                .stream()
                .sorted(Comparator.comparing(Student::getPassed).thenComparing(Student::getAverage).thenComparing(Student::getID).reversed())
                .limit(i)
                .forEach(s -> System.out.printf("Student: %s Courses passed: %d Average grade: %.2f%n", s.getID(), s.getPassed(), Math.max(5.0, s.getAverage())));
    }

    public void printCourses() {
        courses
                .values()
                .stream()
                .filter(c -> c.getStudents() > 0)
                .sorted(Comparator.comparing(Course::getStudents).thenComparing(Course::getAverage).thenComparing(Course::getName))
                .forEach(c -> System.out.printf("%s %d %.2f%n", c.getName(), c.getStudents(), Math.max(5.0, c.getAverage())));
    }
}