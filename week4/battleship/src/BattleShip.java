import java.util.Arrays;

/**
 * Describes a battleship. A ship that occupies 8 squares.
 */
public class BattleShip extends Ship {

    public BattleShip() {
        this.setLength(8);
        this.setHit(new boolean[8]);
        Arrays.fill(this.getHit(), false);
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
