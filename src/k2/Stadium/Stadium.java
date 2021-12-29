package k2.Stadium;

import java.util.*;

public class Stadium {
    private final String name;
    private final Map<String, Sector> map;

    public Stadium(String name) {
        this.name = name;
        this.map = new HashMap<>();
    }

    public void createSectors(String[] sectorNames, int[] sectorSizes) {
        for (int i = 0; i < sectorNames.length; i++) {
            map.put(sectorNames[i], new Sector(sectorNames[i], sectorSizes[i]));
        }
    }

    public void buyTicket(String sectorName, int seat, int type) throws SeatTakenException, SeatNotAllowedException {
        Map<Integer, Boolean> seats = map.get(sectorName).getMap();

        if (seats.containsKey(seat)) {
            throw new SeatTakenException();
        }

        int sectorType = map.get(sectorName).getType();

        if ((type == 1 && sectorType == 2) || (type == 2 && sectorType == 1)) {
            throw new SeatNotAllowedException();
        }

        if (type != 0 && sectorType == 0) {
            map.get(sectorName).setType(type);
        }

        seats.put(seat, true);
    }

    public void showSectors() {
        map.values().stream().sorted(Comparator.comparing(Sector::getFreeSeats).reversed().thenComparing(Sector::getCode)).forEach(System.out::println);
    }
}