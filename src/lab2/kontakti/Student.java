package lab2.kontakti;

import java.util.Arrays;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String city;
    private final int age;
    private final long index;
    private Contact[] contacts;
    private int n;

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        this.contacts = new Contact[0];
        this.n = 0;
    }

    @Override
    public String toString() {
        return "{\"ime\":\"" +
                firstName +
                "\", \"prezime\":\"" +
                lastName +
                "\", \"vozrast\":" +
                age +
                ", \"grad\":\"" +
                city +
                "\", \"indeks\":" +
                index +
                ", \"telefonskiKontakti\":" +
                Arrays.toString(getPhoneContacts()) +
                ", \"emailKontakti\":" +
                Arrays.toString(getEmailContacts()) +
                "}";
    }

    public void addEmailContact(String date, String email) {
        contacts = Arrays.copyOf(contacts, n + 1);
        contacts[n] = new EmailContact(date, email);
        n++;
    }

    public void addPhoneContact(String date, String phone) {
        contacts = Arrays.copyOf(contacts, n + 1);
        contacts[n] = new PhoneContact(date, phone);
        n++;
    }

    public Contact[] getEmailContacts() {
        Contact[] array;
        int i = 0;

        for (Contact c : contacts) {
            if (c.getType().equals("Email")) {
                i++;
            }
        }

        array = new Contact[i];
        i = 0;

        for (Contact c : contacts) {
            if (c.getType().equals("Email")) {
                array[i] = c;
                i++;
            }
        }

        return array;
    }

    public Contact[] getPhoneContacts() {
        Contact[] array;
        int i = 0;

        for (Contact c : contacts) {
            if (c.getType().equals("Phone")) {
                i++;
            }
        }

        array = new Contact[i];
        i = 0;

        for (Contact c : contacts) {
            if (c.getType().equals("Phone")) {
                array[i] = c;
                i++;
            }
        }

        return array;
    }

    public Contact getLatestContact() {
        Contact contact = contacts[0];

        for (Contact c : contacts) {
            if (c.isNewerThan(contact)) {
                contact = c;
            }
        }

        return contact;
    }

    public int getContacts() {
        return contacts.length;
    }

    public String getCity() {
        return city;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public long getIndex() {
        return index;
    }
}