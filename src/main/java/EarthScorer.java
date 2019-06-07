public class EarthScorer extends Scorer {

    protected EarthScorer() {
        super(21);
    }

    @Override
    public int framesNumber() {
        return 10;
    }

    @Override
    public int rollsPerFrame() {
        return 2;
    }

}
