import org.example.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {
    private Cell testCell;
    @Test
    public void testGetFlipped(){
        beforeTest();
        Assertions.assertFalse(testCell.getFlipped(), "Failed get flipped.");
    }
    @Test
    public void testSetFlipped(){
        beforeTest();
        testCell.setFlipped();
        Assertions.assertTrue(testCell.getFlipped(), "Failed set flipped.");
    }
    @Test
    public void testGetFlagged(){
        beforeTest();
        Assertions.assertFalse(testCell.getFlagged(), "Failed get flagged.");
    }
    @Test
    public void testSetFlagged(){
        beforeTest();
        testCell.setFlagged();
        Assertions.assertTrue(testCell.getFlagged(), "Failed set flagged.");
        testCell.setFlagged();
        Assertions.assertFalse(testCell.getFlagged(), "Failed set flagged.");
    }
    @Test
    public void testGetBomb(){
        beforeTest();
        Assertions.assertFalse(testCell.getBomb(), "Failed get bomb.");
    }
    @Test
    public void testSetBomb(){
        beforeTest();
        testCell.setBomb();
        Assertions.assertTrue(testCell.getBomb(), "Failed set bomb.");
        testCell.setBomb();
        Assertions.assertFalse(testCell.getBomb(), "Failed set bomb.");
    }
    @Test
    public void testGetAdjacentBombs(){
        beforeTest();
        Assertions.assertEquals(testCell.getAdjacentBombs(), 0 ,"Failed get adjacent bombs.");
    }
    @Test
    public void testSetAdjacentBombs(){
        beforeTest();
        testCell.setAdjacentBombs(4);
        Assertions.assertEquals(testCell.getAdjacentBombs(), 4 ,"Failed set adjacent bombs.");
        testCell.setAdjacentBombs(3);
        Assertions.assertEquals(testCell.getAdjacentBombs(), 3 ,"Failed set adjacent bombs.");
    }

    private void beforeTest(){
        testCell = new Cell();
    }
}
