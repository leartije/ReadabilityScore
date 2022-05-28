package readability;

public class Score {

    private int words;
    private int sentences;
    private int characters;
    private double score;
    private int scoreInt;
    private final String text;

    public Score(String text) {
        this.text = text;
        setWords();
        setSentences();
        setCharacters();
        setScore();
        setScoreInt();
    }

    public void statistics() {
        System.out.printf("Words: %d%nSentences: %d%nCharacters: %d%nThe score is: %.2f%n",
                words, sentences, characters, score);
        System.out.printf("This text should be understood by %s-year-olds.%n", automatedReadabilityIndex());
    }

    private void setWords() {
        if (text.length() == 0) {
            return;
        }
        this.words = text.split("\\s").length;
    }

    private void setSentences() {
        if (text.length() == 0) {
            return;
        }
        String trim = text.strip();
        this.sentences = trim.split("\\.|\\?|!").length;
    }

    private void setCharacters() {
        if (text.length() == 0) {
            return;
        }
        this.characters = text.replaceAll("\\s","").toCharArray().length;
    }

    private void setScore() {
        if (words == 0 || sentences == 0) {
            return;
        }
        this.score = 4.71 * ((double) characters / (double) words) + 0.5 * ((double) words / (double) sentences) - 21.43;
    }

    private void setScoreInt() {
        double temp = Math.ceil(this.score);
        this.scoreInt = (int) temp;
    }

    private String automatedReadabilityIndex() {
        switch (scoreInt) {
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "16-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            case 14:
                return "24+";
            default:
                return "unknown";

        }
    }



}
