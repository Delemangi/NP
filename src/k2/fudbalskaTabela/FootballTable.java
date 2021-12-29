package k2.fudbalskaTabela;

import java.util.*;
import java.util.stream.Collectors;

public class FootballTable {
    private final Map<String, Team> map;

    public FootballTable() {
        this.map = new HashMap<>();
    }

    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        map.putIfAbsent(homeTeam, new Team(homeTeam));
        map.get(homeTeam).update(homeGoals, awayGoals);

        map.putIfAbsent(awayTeam, new Team(awayTeam));
        map.get(awayTeam).update(awayGoals, homeGoals);
    }

    public void printTable() {
        List<Team> list = map.values().stream().sorted(Comparator.comparing(Team::getPoints).thenComparing(Team::getDifference).reversed().thenComparing(Team::getName)).collect(Collectors.toList());

        list.forEach(i -> System.out.printf("%2d. %s%n", list.indexOf(i) + 1, i.toString()));
    }
}