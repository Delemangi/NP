package k2.fudbalskaTabela;

public class Team {
    private final String name;
    private int games;
    private int wins;
    private int draws;
    private int losses;
    private int difference;

    public Team(String name) {
        this.name = name;
    }

    public int getPoints() {
        return 3 * wins + draws;
    }

    public int getDifference() {
        return difference;
    }

    public String getName(){
        return name;
    }

    public void update(int home, int away) {
        games++;
        difference += home - away;

        if (home - away > 0) {
            wins++;
        } else if (home - away == 0) {
            draws++;
        } else {
            losses++;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s%5d%5d%5d%5d%5d", name, games, wins, draws, losses, getPoints());
    }
}