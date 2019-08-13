/**
 * Descbribes a Cruiser. A ship that occupies 6 squares.
 */
public class Cruiser extends Ship {

    public Cruiser() {
        super.setLength(6);
        super.setHit(new boolean[6]);
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
