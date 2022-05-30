package readability;

import readability.approaches.AutomatedReadabilityIndex;
import readability.approaches.ColemanLiauIndex;
import readability.approaches.FleshKincaidReadabilityTest;
import readability.approaches.SimpleMeasureOfGobbledygook;

import java.util.Locale;
import java.util.Scanner;

public class Start {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void startProgram(TextStatistic statistic) {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Options options = isValid(SCANNER.nextLine().toUpperCase(Locale.ROOT));
        switch (options) {
            case ARI:
                new Context(new AutomatedReadabilityIndex(statistic)).execute();
                break;
            case FK:
                new Context(new FleshKincaidReadabilityTest(statistic)).execute();
                break;
            case SMOG:
                new Context(new SimpleMeasureOfGobbledygook(statistic)).execute();
                break;
            case CL:
                new Context(new ColemanLiauIndex(statistic)).execute();
                break;
            case ALL:
                all(statistic);
                break;
            default:
                System.out.println("Wrong input, try: ARI, FK, SMOG, CL or all");
                break;
        }

    }
    private Options isValid(String input) {
        try {
            return Options.valueOf(input);
        } catch (IllegalArgumentException e) {
            return Options.UNKNOWN;
        }
    }

    private void all(TextStatistic statistic) {
        new Context(new AutomatedReadabilityIndex(statistic)).execute();
        new Context(new FleshKincaidReadabilityTest(statistic)).execute();
        new Context(new SimpleMeasureOfGobbledygook(statistic)).execute();
        new Context(new ColemanLiauIndex(statistic)).execute();
    }

}


