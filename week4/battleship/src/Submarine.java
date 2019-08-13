/**
 * Describes a Submarine. A ship that occupies 3 squares.
 */
public class Submarine extends Ship {

    public Submarine() {
        super.setLength(3);
        super.setHit(new boolean[3]);
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
