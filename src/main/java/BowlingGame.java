public class BowlingGame {
    private static final int MAX_POSSIBLE_ROLLS = 21;

    private int[] rolls = new int[MAX_POSSIBLE_ROLLS];
    private int currentRoll = 0;

    public void roll(int pinsDown) {
        rolls[currentRoll] = pinsDown;
        currentRoll++;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + nextTwoRolls(rollIndex);
                rollIndex++;
            }
            else if (isSpare(rollIndex)) {
                score += 10 + nextRoll(rollIndex);
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex+1];
                rollIndex+= 2;
            }
        }

        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollCursor) {
        return rolls[rollCursor] + rolls[rollCursor+1] == 10;
    }

    private int nextRoll(int rollCursor) {
        return rolls[rollCursor+2];
    }

    private int nextTwoRolls(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

}
