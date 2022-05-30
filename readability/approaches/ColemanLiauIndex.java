package readability.approaches;

import readability.ReadabilityScore;
import readability.TextStatistic;

public class ColemanLiauIndex implements ReadabilityScore {

    private final TextStatistic tS;
    private double score;
    private double averageNumOfCharPer100Words;
    private double averageNumOfSentencesPer100Words;

    public ColemanLiauIndex(TextStatistic tS) {
        this.tS = tS;
        setAverageNumOfCharactersPer100Words();
        setAverageNumOfSentencesPer100Words();
        calculateScore();
    }

    @Override
    public void calculateScore() {
        this.score = 0.0588 * averageNumOfCharPer100Words - 0.296 * averageNumOfSentencesPer100Words - 15.8;
    }

    @Override
    public void printResults() {
        System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).", score, tS.calculateAge(intScore(score)));
    }

    public void setAverageNumOfCharactersPer100Words() {
        this.averageNumOfCharPer100Words = ((double) tS.getNumOfCharacters() / (double) tS.getNumOfWords()) * 100;
    }

    public void setAverageNumOfSentencesPer100Words() {
        this.averageNumOfSentencesPer100Words = ((double) tS.getNumOfSentences() / (double) tS.getNumOfWords()) * 100;
    }
}
