/**
 * Describes a part of the ocean that does not have a ship in it.
 */
public class EmptySea extends Ship {
    public EmptySea() {
        super.setLength(1);
    }

    /**
     * This method always returns false.
     * Indicates that no ship can be hit in this location because no ship exists at this location.
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * This method always returns false.
     * Indicates that no ship can be sunk in this location because no ship exists at this location.
     * @return
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * This method returns the symbol for an empty sea.
     * @return
     */
    @Override
    public String toString() {
        return "~";
    }

    /**
     * This method returns empty to indicate that an empty sea doesn't have a ship type.
     * @return
     */
    @Override
    public String getShipType() {
        return "empty";
    }
}
