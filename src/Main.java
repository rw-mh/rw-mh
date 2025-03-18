import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        Map<String, String> params = parseArgs(args);
        if (params.containsKey("-n") && params.containsKey("-r")) {
            int n = Integer.parseInt(params.get("-n"));
            int r = Integer.parseInt(params.get("-r"));
            generateProblems(n, r);
        } else if (params.containsKey("-e") && params.containsKey("-a")) {
            String exerciseFile = params.get("-e");
            String answerFile = params.get("-a");
            checkAnswers(exerciseFile, answerFile);
        } else {
            printHelp();
        }
    }

    private static void generateProblems(int n, int r) {
        ExpressionGenerator generator = new ExpressionGenerator(r);
        List<ExpressionGenerator.Problem> problems = generator.generate(n);
        // Write to Exercises.txt and Answers.txt
    }

    private static void checkAnswers(String exerciseFile, String answerFile) {
        // Read files and check answers
    }

    private static Map<String, String> parseArgs(String[] args) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    params.put(args[i], args[i + 1]);
                    i++;
                } else {
                    params.put(args[i], "");
                }
            }
        }
        return params;
    }

    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("Generate problems:java Main -n <number> -r <range>");
        System.out.println("Check answers:java Main -e <exercisefile> -a <answerfile>");
    }
}