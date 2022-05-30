package readability;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Getter
@ToString
@EqualsAndHashCode
public class TextStatistic {

    private int numOfWords;
    private int numOfSentences;
    private int numOfCharacters;
    private int numOfSyllables;
    private int numOfPolysyllables;
    private final String text;

    public TextStatistic(String text) {
        this.text = text;
        setWords();
        setSentences();
        setCharacters();
        setSyllablesAndPolysyllables();
    }

    public void printStatistic() {
        System.out.printf("Words: %d%n" +
                        "Sentences: %d%n" +
                        "Characters: %d%n" +
                        "Syllables: %d%n" +
                        "Polysyllables: %d%n",
                numOfWords,
                numOfSentences,
                numOfCharacters,
                numOfSyllables,
                numOfPolysyllables);
    }


    private void setWords() {
        if (text.length() == 0) {
            return;
        }
        this.numOfWords = text.split("\\s+").length;
    }

    private void setSentences() {
        if (text.length() == 0) {
            return;
        }
        this.numOfSentences = text.split("\\.|\\?|!").length;
    }

    private void setCharacters() {
        if (text.length() == 0) {
            return;
        }
        this.numOfCharacters = text.replaceAll("\\s+", "").toCharArray().length;
    }

    private void setSyllablesAndPolysyllables() {
        if (text.length() == 0) {
            return;
        }
        int syllablesTotal = 0;
        int polySyllablesTotal = 0;
        String[] words = text.split("\\s+");
        for (String w : words) {
            String current = w.replaceAll("\\.|\\?|!", "");
            int syllables = syllablesCounter(current);
            if (syllables > 2) {
                polySyllablesTotal++;
            }
            syllablesTotal += syllables;
        }
        this.numOfSyllables = syllablesTotal;
        this.numOfPolysyllables = polySyllablesTotal;
    }

    private static int syllablesCounter(String word) {
        final Pattern pattern = Pattern.compile("(?i)[aeiouy]+");
        final Matcher matcher = pattern.matcher(word);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        if (word.charAt(word.length() - 1) == 'e') {
            count--;
        }

        return count == 0 ? 1 : count;
    }

    public String calculateAge(int score) {
        if (score >= 14 ) {
            return "22";
        }
        return String.valueOf(score + 5);
    }

}


