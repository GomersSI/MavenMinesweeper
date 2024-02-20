import org.example.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testGetFlipped(){
        Cell testCell = new Cell();
        Assertions.assertFalse(testCell.getFlipped());
    }

}
