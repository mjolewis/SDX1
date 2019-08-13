/**
 * Descbribes a battlecruiser. A ship that occupies 7 squares.
 */
public class BattleCruiser extends Ship {

    public BattleCruiser() {
        super.setLength(7);
        super.setHit(new boolean[7]);
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
