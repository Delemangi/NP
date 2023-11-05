package ispit.imenik;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, Contact> contactsByNumber;
    private final Map<String, Set<Contact>> contactsByName;

    public PhoneBook() {
        this.contactsByNumber = new HashMap<>();
        this.contactsByName = new HashMap<>();
    }

    public void addContact(String name, String number) throws DuplicateNumberException {
        if (contactsByNumber.containsKey(name)) {
            throw new DuplicateNumberException(number);
        }

        Contact contact = new Contact(name, number);

        contactsByNumber.put(number, contact);

        contactsByName.putIfAbsent(name, new TreeSet<>());
        contactsByName.computeIfPresent(name, (k, v) -> {
            v.add(contact);

            return v;
        });
    }

    public void contactsByNumber(String number) {
        List<Contact> list = contactsByNumber
                .values()
                .stream()
                .filter(c -> c.getNumber().contains(number))
                .sorted()
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            list.forEach(System.out::println);
        }
    }

    public void contactsByName(String name) {
        Set<Contact> set = contactsByName.get(name);

        if (set == null) {
            System.out.println("NOT FOUND");
        } else {
            set.forEach(System.out::println);
        }
    }
}