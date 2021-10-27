package lab2.kontakti;

import java.util.Arrays;

public class Faculty {
    private final String name;
    private final Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = Arrays.copyOf(students, students.length);
    }

    @Override
    public String toString() {
        return "{\"fakultet\":\"" +
                name +
                "\", \"studenti\":" +
                Arrays.toString(students) +
                "}";
    }

    public int countStudentsFromCity(String city) {
        int s = 0;

        for (Student student : students) {
            if (student.getCity().equals(city)) {
                s++;
            }
        }

        return s;
    }

    Student getStudent(long index) {
        for (Student student : students) {
            if (student.getIndex() == index) {
                return student;
            }
        }

        return null;
    }

    public double getAverageNumberOfContacts() {
        double avg = 0;

        for (Student student : students) {
            avg += student.getContacts();
        }

        return avg / students.length;
    }

    public Student getStudentWithMostContacts() {
        int max = students[0].getContacts();
        Student s = students[0];

        for (Student student : students) {
            if (student.getContacts() > max || (student.getContacts() == max && s.getIndex() <= student.getIndex())) {
                max = student.getContacts();
                s = student;
            }
        }

        return s;
    }
}