import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

public class AITest {
    @Test
    public void TestDefensiveAI1(){
        DefensiveAI ai = new DefensiveAI();
        GridTracker gridTracker = new GridTracker();
        gridTracker.putPlayerMove(0,0);
        gridTracker.putPlayerMove(1,0);
        Location l = ai.makeMove(gridTracker);
        Assert.assertEquals(2, l.x);
        Assert.assertEquals(0, l.y);
    }

    @Test
    public void TestDefensiveAI2(){
        DefensiveAI ai = new DefensiveAI();
        GridTracker gridTracker = new GridTracker();
        gridTracker.putPlayerMove(0,0);
        gridTracker.putPlayerMove(1,1);
        Location l = ai.makeMove(gridTracker);
        Assert.assertEquals(2, l.x);
        Assert.assertEquals(2, l.y);
    }

    @Test
    public void TestDefensiveAI3(){
        DefensiveAI ai = new DefensiveAI();
        GridTracker gridTracker = new GridTracker();
        gridTracker.putPlayerMove(0,2);
        gridTracker.putPlayerMove(1,1);
        Location l = ai.makeMove(gridTracker);
        Assert.assertEquals(2, l.x);
        Assert.assertEquals(0, l.y);
    }

    @Test
    public void TestDefensiveAI4(){
        DefensiveAI ai = new DefensiveAI();
        GridTracker gridTracker = new GridTracker();
        gridTracker.putPlayerMove(0,0);
        gridTracker.putPlayerMove(1,0);
        Location l = ai.makeMove(gridTracker);
        Assert.assertEquals(2, l.x);
        Assert.assertEquals(0, l.y);
    }
}
