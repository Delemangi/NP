package k2.fakultet;

public class OperationNotAllowedException extends Exception {
    public OperationNotAllowedException(String ID, int term) {
        super(String.format("Student %s already has 3 grades in term %d", ID, term));
    }

    public OperationNotAllowedException(int term, String ID) {
        super(String.format("Term %d is not possible for student with ID %s", term, ID));
    }
}