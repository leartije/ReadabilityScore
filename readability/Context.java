package readability;

public class Context {

    private final ReadabilityScore score;

    public Context(ReadabilityScore score) {
        this.score = score;
    }

    public void execute() {
        this.score.printResults();
    }

}
