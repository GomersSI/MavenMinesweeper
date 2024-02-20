import org.example.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testGetFlipped(){
        Cell testCell = new Cell();
        Assertions.assertFalse(testCell.getFlipped());
    }

    @Test
    public void testSetFlipped(){
        Cell testCell = new Cell();
        testCell.setFlipped();
        Assertions.assertTrue(testCell.getFlipped());
    }
}
