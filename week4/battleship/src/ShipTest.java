import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing class
 */
public class ShipTest {

    @Test
    public void testBattleShip() {
        Ship battleShip = new BattleShip();
        System.out.println(battleShip.getShipType() + " Is sunk: " + battleShip.isSunk());
        assertEquals("battleship", battleShip.getShipType());
        assertEquals(8, battleShip.getLength());
    }

    @Test
    public void testBattleCruiser() {
        Ship battleCruiser = new BattleCruiser();
        System.out.println(battleCruiser.getShipType() + " Is sunk: " + battleCruiser.isSunk());
        assertEquals("battlecruiser", battleCruiser.getShipType());
        assertEquals(7, battleCruiser.getLength());
    }

    @Test
    public void testCrusier() {
        Ship cruiser = new Cruiser();
        System.out.println(cruiser.getShipType() + " Is sunk: " + cruiser.isSunk());
        assertEquals("cruiser", cruiser.getShipType());
        assertEquals(6, cruiser.getLength());
    }

    @Test
    public void testLightCruiser() {
        Ship lightCruiser = new LightCruiser();
        System.out.println(lightCruiser.getShipType() + " Is sunk: " + lightCruiser.isSunk());
        assertEquals("light cruiser", lightCruiser.getShipType());
        assertEquals(5, lightCruiser.getLength());
    }

    @Test
    public void testDestroyer() {
        Ship destroyer = new Destroyer();
        System.out.println(destroyer.getShipType() + " Is sunk: " + destroyer.isSunk());
        assertEquals("destroyer", destroyer.getShipType());
        assertEquals(4, destroyer.getLength());
    }
}
