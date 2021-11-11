package lab3.telefonskiImenik;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PhoneBook implements Serializable {
    private Contact[] contacts;

    public PhoneBook() {
        this.contacts = new Contact[0];
    }

    public void addContact(Contact c) throws MaximumSizeExceddedException, InvalidNameException {
        if (contacts.length >= 250) {
            throw new MaximumSizeExceddedException();
        }

        if (hasContact(c)) {
            throw new InvalidNameException(c.getName());
        }

        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = c;
    }

    private boolean hasContact(Contact c) {
        return Arrays.stream(contacts).anyMatch(i -> i.getName().equals(c.getName()));
    }

    public Contact getContactForName(String name) {
        return Arrays.stream(contacts).filter(i -> i.getName().equals(name)).findFirst().orElse(null);
    }

    public int numberOfContacts() {
        return contacts.length;
    }

    public Contact[] getContacts() {
        return Arrays.stream(contacts).sorted(Comparator.comparing(Contact::getName)).toArray(Contact[]::new);
    }

    public boolean removeContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                contacts = IntStream.range(0, contacts.length).filter(i -> !contacts[i].getName().equals(name)).mapToObj(i -> contacts[i]).toArray(Contact[]::new);
                return true;
            }
        }

        return false;
    }

    public static boolean saveAsTextFile(PhoneBook pb, String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(pb);
            oos.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static PhoneBook loadFromTextFile(String file) throws InvalidFormatException {
        PhoneBook pb = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            pb = (PhoneBook) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new InvalidFormatException();
        }

        return pb;
    }

    public Contact[] getContactsForNumber(String number) {
        return Arrays.stream(contacts).filter(i -> i.hasNumber(number)).toArray(Contact[]::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(contacts).sorted().forEach(i -> sb.append(i).append("\n"));

        return sb.toString();
    }
}