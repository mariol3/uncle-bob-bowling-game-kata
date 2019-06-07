import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MartianBowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame(new MartianScorer());
    }

    @Test
    public void rollAllZeros() {
        roll(0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollAllOnes() {
        roll(1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1, 1,1,1);
        assertThat(game.score(), is(36));
    }

    @Test
    public void rollOpenScoreAndAllZeros() {
        roll(1,2,3, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is(6));
    }

    @Test
    public void rollASpare() {
        roll(1,2,7, 3,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is(16));
    }

    @Test
    public void rollAStrike() {
        roll(10, 2,3,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is(20));
    }

    @Test
    public void rollTwoStrikeAndSixAndTwo() {
        roll(10, 10, 6,2,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is((10+10+6) + (10+6+2) + (6+2)));
    }

    @Test
    public void rollStrikeSpareAndSix() {
        roll(10, 1,2,7, 6,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
        assertThat(game.score(), is((10+1+2) + (10+6) + 6));
    }

    @Test
    public void rollPerfectGame() {
        roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(game.score(), is(360));
    }

    private void roll(int...rolls) {
        for (int pinsDown : rolls) {
            game.roll(pinsDown);
        }
    }

}
