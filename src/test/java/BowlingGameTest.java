import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void rollAllZeros() {
        roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollAllOnes() {
        roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void rollSpareAndSix() {
        roll(3,7, 6,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(22));
    }

    @Test
    public void rollStrikeAndSixAndTwo() {
        roll(10, 3,2, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(20));
    }

    @Test
    public void rollTwoStrikeAndSixAndTwo() {
        roll(10, 10, 6,2, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(52));
    }

    @Test
    public void rollStrikeSpareAndSix() {
        roll(10, 3,7, 6,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(42));
    }

    @Test
    public void rollPerfectGame() {
        roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(game.score(), is(300));
    }

    @Test
    public void rollAlmostPerfectGame() {
        roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 3,7, 10);
        assertThat(game.score(), is(273));
    }

    private void roll(int...rolls) {
        for (int pinsDown : rolls) {
            game.roll(pinsDown);
        }
    }

}
