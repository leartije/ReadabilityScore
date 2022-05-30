package readability;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String EMPTY = "empty";

    public static void main(String[] args) {

        String file = getFileName(args);
        String text = getText(file);
        if (!Objects.equals(text, EMPTY)) {

            TextStatistic textStatistic = new TextStatistic(text);
            textStatistic.printStatistic();

            Start start = new Start();
            start.startProgram(textStatistic);
            return;
        }

        System.out.println("File is empty");


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
            if (scanner.hasNext()) {
                text.append(scanner.next());
                while (scanner.hasNext()) {
                    text.append(" ").append(scanner.next());
                }
            } else {
                return EMPTY;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

}
