import org.example.Gameboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameboardTest {
    private Gameboard testGameboard;
    @Test
    void testGetTotalBombs(){
        beforeTest(10, 2);
        Assertions.assertEquals(testGameboard.getTotalBombs(), 2, "Failed get total bombs.");
        beforeTest(10, 4);
        Assertions.assertEquals(testGameboard.getTotalBombs(), 4, "Failed get total bombs.");
    }
    @Test
    void testGetColumn(){
        beforeTest(5, 2);
        Assertions.assertFalse(testGameboard.getColumn(2).getCell(2).getBomb(), "Failed get column.");
        Assertions.assertFalse(testGameboard.getColumn(1).getCell(1).getBomb(), "Failed get column.");
    }
    @Test
    void testFlipCell(){
        beforeTest(5, 2);
        testGameboard.flipCell(1, 1);
        Assertions.assertTrue(testGameboard.getColumn(1).getCell(1).getFlipped(), "Failed flip cell");
        testGameboard.flipCell(1, 1);
        Assertions.assertTrue(testGameboard.getColumn(1).getCell(1).getFlipped(), "Failed flip cell");
        beforeTest(5,2);
        testGameboard.flagCell(1,1);
        testGameboard.flipCell(1, 1);
        Assertions.assertFalse(testGameboard.getColumn(1).getCell(1).getFlipped(), "Failed flip cell");
        beforeTest(5,2);
        testGameboard.getColumn(1).getCell(1).setBomb();
        testGameboard.flipCell(1, 1);
        Assertions.assertTrue(testGameboard.getColumn(1).getCell(1).getFlipped(), "Failed flip cell");
    }
    @Test
    void testFlagCell(){
        beforeTest(5, 2);
        testGameboard.flagCell(1, 1);
        Assertions.assertTrue(testGameboard.getColumn(1).getCell(1).getFlagged(), "Failed flip cell");
        testGameboard.flagCell(1, 1);
        Assertions.assertFalse(testGameboard.getColumn(2).getCell(1).getFlagged(), "Failed flip cell");
        testGameboard.flipCell(1,1);
        testGameboard.flagCell(1,1);
        Assertions.assertFalse(testGameboard.getColumn(2).getCell(1).getFlagged(), "Failed flip cell");
    }
    @Test
    void testGetFlaggedCells(){
        beforeTest(5,1);
        Assertions.assertEquals(testGameboard.getFlaggedCells(), 0, "Failed get flagged cells.");
    }
    @Test
    void testSetFlaggedCells(){
        beforeTest(5,1);
        testGameboard.setFlaggedCells(3);
        Assertions.assertEquals(testGameboard.getFlaggedCells(), 3, "Failed set flagged cells.");
        testGameboard.setFlaggedCells(-1);
        Assertions.assertEquals(testGameboard.getFlaggedCells(), 2, "Failed set flagged cells.");
    }
    @Test
    void testPlaceBombs(){
        beforeTest(5, 2);
        testGameboard.flipCell(1, 1);
        int totalBomb = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (testGameboard.getColumn(i).getCell(j).getBomb()){
                    totalBomb++;
                }
            }
        }
        Assertions.assertEquals(totalBomb, 2, "Failed test place bombs");
        beforeTest(5, 3);
        testGameboard.flipCell(1, 1);
        totalBomb = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (testGameboard.getColumn(i).getCell(j).getBomb()){
                    totalBomb++;
                }
            }
        }
        Assertions.assertEquals(totalBomb, 3, "Failed test place bombs");
    }
    @Test
    void testGetFlippedAdjacent(){
        beforeTest(5, 1);
        Assertions.assertEquals(testGameboard.getFlippedAdjacent().size(), 0,"Failed get flipped adjacent.");
    }
    @Test
    void testSetFlippedAdjacent(){
        beforeTest(5, 1);
        testGameboard.setFlippedAdjacent();
        Assertions.assertEquals(testGameboard.getFlippedAdjacent().size(), 0,"Failed get flipped adjacent.");
    }
    private void beforeTest(int size, int bombs){
        testGameboard = new Gameboard(size, bombs);
    }
}
