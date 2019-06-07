public class Rules {
    private int maxPossibleRolls;
    private int framesNumber;
    private int rollsPerFrame;

    public Rules(int maxPossibleRolls, int framesNumber, int rollsPerFrame) {
        this.maxPossibleRolls = maxPossibleRolls;
        this.framesNumber = framesNumber;
        this.rollsPerFrame = rollsPerFrame;
    }

    public int maxPossibleRolls() {
        return maxPossibleRolls;
    }

    public int framesNumber() {
        return framesNumber;
    }

    public int rollsPerFrame() {
        return rollsPerFrame;
    }
}
