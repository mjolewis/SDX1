import java.util.Arrays;

/**
 * Describes a Submarine. A ship that occupies 3 squares.
 */
public class Submarine extends Ship {

    public Submarine() {
        this.setLength(3);
        this.setHit(new boolean[3]);
        Arrays.fill(getHit(), false);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "submarine";
    }
}
