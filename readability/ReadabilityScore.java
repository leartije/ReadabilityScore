package readability;

public interface ReadabilityScore {
    void calculateScore();
    void printResults();
    default int intScore(double score) {
        return (int) Math.ceil(score);
    }

}
