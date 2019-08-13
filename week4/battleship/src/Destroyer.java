/**
 * Describes a Destroyer. A ship that occupies 4 squares.
 */
public class Destroyer extends Ship {

    public Destroyer() {
        super.setLength(4);
        super.setHit(new boolean[4]);
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
