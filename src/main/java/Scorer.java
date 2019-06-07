public abstract class Scorer {
    private int[] rolls;
    private int currentRoll;

    protected Scorer(int maxPossibleRolls) {
        this.rolls = new int[maxPossibleRolls];
        this.currentRoll = 0;
    }

    public void scoreRoll(int pinsDown) {
        rolls[currentRoll] = pinsDown;
        currentRoll++;
    }

    public int nextFrameRoll(int rollIndex) {
        return rolls[rollIndex+rollsPerFrame()];
    }

    public int nextTwoRolls(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    protected int[] rolls() {
        return rolls;
    }

    public int getOpenScore(int rollIndex) {
        int openScore = 0;
        for (int i = 0; i < rollsPerFrame(); i++) {
            openScore += rolls()[rollIndex+i];
        }
        return openScore;
    };

    public boolean isStrike(int rollIndex) {
        return rolls()[rollIndex] == 10;
    };

    public boolean isSpare(int rollIndex) {
        return getOpenScore(rollIndex) == 10;
    };

    public abstract int framesNumber();

    public abstract int rollsPerFrame();
}
