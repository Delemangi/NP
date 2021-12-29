package k2.audition;

import java.util.*;

public class Audition {
    private final Set<Participant> set;

    public Audition() {
        this.set = new HashSet<>();
    }

    public void addParticpant(String city, String code, String name, int age) {
        set.add(new Participant(city, code, name, age));
    }

    public void listByCity(String city) {
        set.stream().filter(i->i.getCity().equals(city)).sorted().forEach(System.out::println);
    }
}