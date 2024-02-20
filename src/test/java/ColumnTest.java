import org.example.Cell;
import org.example.Column;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColumnTest {
    private Column testColumn;
    @Test
    void testGetCell(){
        testColumn = new Column(5);
        Assertions.assertFalse(testColumn.getCell(2).getFlipped(), "Failed get cell.");
        testColumn.getCell(2).setFlipped();
        Assertions.assertTrue(testColumn.getCell(2).getFlipped(), "Failed get cell.");
    }
}
