package lab3.telefonskiImenik;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Contact implements Comparable<Contact> {
    private final String name;
    private String[] numbers;

    Contact(String name, String... numbers) throws InvalidNameException, InvalidNumberException, MaximumSizeExceddedException {
        if (nameCheck(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException(name);
        }

        if (!Arrays.stream(numbers).allMatch(this::numberCheck)) {
            throw new InvalidNumberException();
        }

        if (numbers.length > 5) {
            throw new MaximumSizeExceddedException();
        }

        this.numbers = new String[numbers.length];
        IntStream.range(0, numbers.length).forEach(i -> this.numbers[i] = numbers[i]);
    }

    private boolean nameCheck(String str) {
        return str.matches("[a-zA-Z0-9]{5,10}");
    }

    private boolean numberCheck(String str) {
        return str.matches("07[0125678][0-9]{6}");
    }

    public void addNumber(String number) throws InvalidNumberException {
        if (!numberCheck(number)) {
            throw new InvalidNumberException();
        }

        numbers = Arrays.copyOf(numbers, numbers.length + 1);
        numbers[numbers.length - 1] = number;
    }

    public String[] getNumbers() {
        return Arrays.stream(numbers).sorted().toArray(String[]::new);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(name)
                .append("\n")
                .append(numbers.length)
                .append("\n");

        Arrays.stream(numbers).sorted().forEach(i -> sb.append(i).append("\n"));

        return sb.toString();
    }

    public static Contact valueOf(String s) throws InvalidFormatException {
        try {
            return new Contact(s);
        } catch (Exception e) {
            throw new InvalidFormatException();
        }
    }

    public boolean hasNumber(String s) {
        return Arrays.stream(numbers).anyMatch(i -> i.startsWith(s));
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
}