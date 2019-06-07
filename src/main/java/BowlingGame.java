public class BowlingGame {
    private Rules rules;

    private int[] rolls;
    private int currentRoll = 0;

    public BowlingGame(Rules rules) {
        this.rules = rules;
        this.rolls = new int[rules.maxPossibleRolls()];
    }

    public void roll(int pinsDown) {
        rolls[currentRoll] = pinsDown;
        currentRoll++;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < rules.framesNumber(); frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + nextTwoRolls(rollIndex);
                rollIndex++;
            }
            else if (isSpare(rollIndex)) {
                score += 10 + nextFrameRoll(rollIndex);
                rollIndex += rules.rollsPerFrame();
            } else {
                score += getOpenScore(rollIndex);
                rollIndex+= rules.rollsPerFrame();
            }
        }

        return score;
    }

    public int nextFrameRoll(int rollIndex) {
        return rolls[rollIndex + rules.rollsPerFrame()];
    }

    public int nextTwoRolls(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    public int getOpenScore(int rollIndex) {
        int openScore = 0;
        for (int i = 0; i < rules.rollsPerFrame(); i++) {
            openScore += rolls[rollIndex+i];
        }
        return openScore;
    }

    public boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    };

    public boolean isSpare(int rollIndex) {
        return getOpenScore(rollIndex) == 10;
    };

}
