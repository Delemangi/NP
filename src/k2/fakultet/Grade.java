package k2.fakultet;

public class Grade {
    private final int term;
    private final String course;
    private final int grade;

    public Grade(int term, String course, int grade) {
        this.term = term;
        this.course = course;
        this.grade = grade;
    }

    public int getTerm() {
        return term;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }
}