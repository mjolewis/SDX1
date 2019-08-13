import java.util.Arrays;

/**
 * Descbribes a battlecruiser. A ship that occupies 7 squares.
 */
public class BattleCruiser extends Ship {

    public BattleCruiser() {
        this.setLength(7);
        this.setHit(new boolean[7]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "battlecruiser";
    }
}
