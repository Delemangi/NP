package lab2.kontakti;

public class EmailContact extends Contact {
    private final String email;

    public EmailContact(String date, String email) {
        super(date);
        this.email = email;
    }

    @Override
    public String toString() {
        return "\"" + email + "\"";
    }

    @Override
    public String getType() {
        return "Email";
    }

    public String getEmail() {
        return email;
    }
}