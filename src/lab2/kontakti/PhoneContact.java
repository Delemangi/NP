package lab2.kontakti;

public class PhoneContact extends Contact {
    private final String phone;
    private final Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;

        char op = phone.charAt(2);

        if (op == '0' || op == '1' || op == '2') {
            operator = Operator.TMOBILE;
        } else if (op == '5' || op == '6') {
            operator = Operator.ONE;
        } else {
            operator = Operator.VIP;
        }
    }

    @Override
    public String toString() {
        return "\"" + phone + "\"";
    }

    @Override
    public String getType() {
        return "Phone";
    }

    public String getPhone() {
        return phone;
    }

    public Operator getOperator() {
        return operator;
    }
}