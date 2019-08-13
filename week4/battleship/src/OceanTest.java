import org.junit.jupiter.api.Test;

public class OceanTest {

    @Test
    public void oceanTest() {
        Ocean ocean = new Ocean();
        Ship[][] shipArray = ocean.getShipArray();

        for (int i = 0; i < ocean.ships.length; i++) {
            for (int j = 0; j < ocean.ships.length; j++) {
                System.out.print(shipArray[i][j]);
            }
            System.out.println();
        }
    }
}
