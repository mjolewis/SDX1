import java.util.Arrays;

/**
 * Descbribes a Cruiser. A ship that occupies 6 squares.
 */
public class Cruiser extends Ship {

    public Cruiser() {
        this.setLength(6);
        this.setHit(new boolean[6]);
        Arrays.fill(getHit(), false);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "cruiser";
    }
}
