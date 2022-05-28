package readability;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filename = getFileName(args);
        String getText = getText(filename);
        if (getText == null) {
            return;
        }

        Score score = new Score(getText);
        score.statistics();

    }

    private static String getFileName(String[] args) {
        if (args.length == 0) {
            return null;
        }
        return args[0];
    }

    private static String getText(String fileName) {
        if (fileName == null) {
            return null;
        }
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {

            while (scanner.hasNext()) {
                text.append(scanner.next()).append(" ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

}
