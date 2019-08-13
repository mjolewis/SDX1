import java.util.Arrays;

/**
 * Describes a LightCruiser. A ship that occupies 5 squares.
 */
public class LightCruiser extends Ship {

    public LightCruiser() {
        this.setLength(5);
        this.setHit(new boolean[5]);
        Arrays.fill(getHit(), false);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "light cruiser";
    }
}
