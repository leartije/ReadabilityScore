package readability.approaches;

import readability.ReadabilityScore;
import readability.TextStatistic;

public class FleshKincaidReadabilityTest implements ReadabilityScore {

    private final TextStatistic tS;

    private double score;

    public FleshKincaidReadabilityTest(TextStatistic textStatistic) {
        this.tS = textStatistic;
        calculateScore();

    }

    @Override
    public void calculateScore() {
        this.score = 0.39 * ((double) tS.getNumOfWords() / (double) tS.getNumOfSentences())
                + 11.8 * ((double) tS.getNumOfSyllables() / (double) tS.getNumOfWords()) - 15.59;
    }

    @Override
    public void printResults() {
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).%n",
                score, tS.calculateAge(intScore(score)));
    }
}
