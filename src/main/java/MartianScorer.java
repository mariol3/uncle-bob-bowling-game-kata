public class MartianScorer extends Scorer {

    protected MartianScorer() {
        super(36);
    }

    @Override
    public int framesNumber() {
        return 12;
    }

    @Override
    public int rollsPerFrame() {
        return 3;
    }

}
