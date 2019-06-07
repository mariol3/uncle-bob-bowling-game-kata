public class BowlingGame {
    private Scorer scorer;

    public BowlingGame(Scorer scorer) {
        this.scorer = scorer;
    }

    public void roll(int pinsDown) {
        scorer.scoreRoll(pinsDown);
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < scorer.framesNumber(); frame++) {
            if (scorer.isStrike(rollIndex)) {
                score += 10 + scorer.nextTwoRolls(rollIndex);
                rollIndex++;
            }
            else if (scorer.isSpare(rollIndex)) {
                score += 10 + scorer.nextFrameRoll(rollIndex);
                rollIndex += scorer.rollsPerFrame();
            } else {
                score += scorer.getOpenScore(rollIndex);
                rollIndex+= scorer.rollsPerFrame();
            }
        }

        return score;
    }

}
