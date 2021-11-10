package k1.arhiva;

public class SpecialArchive extends Archive {
    private final int maxOpen;
    private int currentOpen;

    public SpecialArchive(int ID, int maxOpen) {
        super(ID);
        this.maxOpen = maxOpen;
        this.currentOpen = 0;
    }

    public void increaseCurrentOpen() {
        this.currentOpen++;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public int getCurrentOpen() {
        return currentOpen;
    }
}