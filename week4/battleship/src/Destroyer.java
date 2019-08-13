import java.util.Arrays;

/**
 * Describes a Destroyer. A ship that occupies 4 squares.
 */
public class Destroyer extends Ship {

    public Destroyer() {
        this.setLength(4);
        this.setHit(new boolean[4]);
        Arrays.fill(getHit(), false);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "destroyer";
    }
}
