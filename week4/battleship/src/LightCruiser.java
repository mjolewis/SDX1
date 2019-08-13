/**
 * Describes a LightCruiser. A ship that occupies 5 squares.
 */
public class LightCruiser extends Ship {

    public LightCruiser() {
        super.setLength(5);
        super.setHit(new boolean[5]);
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
