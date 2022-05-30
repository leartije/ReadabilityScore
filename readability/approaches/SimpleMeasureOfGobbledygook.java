package readability.approaches;

import readability.ReadabilityScore;
import readability.TextStatistic;

public class SimpleMeasureOfGobbledygook implements ReadabilityScore {

    private final TextStatistic tS;
    private double score;

    public SimpleMeasureOfGobbledygook(TextStatistic tS) {
        this.tS = tS;
        calculateScore();
    }

    @Override
    public void calculateScore() {
        this.score = 1.043 * Math.sqrt(tS.getNumOfPolysyllables() * (30.0 / (double) tS.getNumOfSentences())) + 3.1291;
    }

    @Override
    public void printResults() {
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).%n",
                score, tS.calculateAge(intScore(score)));
    }
}
