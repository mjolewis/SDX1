/**
 * Describes a battleship. A ship that occupies 8 squares.
 */
public class BattleShip extends Ship {

    public BattleShip() {
        super.setLength(8);
        super.setHit(new boolean[8]);
    }

    /**
     * This method returns the type of ship.
     * @return
     */
    @Override
    public String getShipType() {
        return "battleship";
    }
}
