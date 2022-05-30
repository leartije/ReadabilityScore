package readability.approaches;

import readability.ReadabilityScore;
import readability.TextStatistic;

public class AutomatedReadabilityIndex implements ReadabilityScore {

    private final TextStatistic tS;
    private double score;

    public AutomatedReadabilityIndex(TextStatistic tS) {
        this.tS = tS;
        calculateScore();
    }

    @Override
    public void calculateScore() {
        this.score = 4.71 * ((double) tS.getNumOfCharacters() / (double) tS.getNumOfWords()) +
                0.5 * ((double) tS.getNumOfWords() / (double) tS.getNumOfSentences()) - 21.43;
    }

    @Override
    public void printResults() {
        System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).%n",
                score, tS.calculateAge(intScore(score)));

    }

}
