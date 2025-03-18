import java.util.*;

public class ExpressionGenerator {
    private int range;
    private Set<String> generatedExpressions = new HashSet<>();
    private Random random = new Random();

    public ExpressionGenerator(int range) {
        this.range = range;
    }

    public List<Problem> generate(int count) {
        List<Problem> problems = new ArrayList<>();
        while (problems.size() < count) {
            Problem problem = generateProblem();
            String canonical = problem.getCanonicalForm();
            if (!generatedExpressions.contains(canonical)) {
                generatedExpressions.add(canonical);
                problems.add(problem);
            }
        }
        return problems;
    }

    private Problem generateProblem() {
        // Implementation to generate a valid expression
        // This is a simplified version; actual code should handle operators and numbers
        String expression = "3 + 2";
        Fraction answer = new Fraction(5, 1);
        return new Problem(expression, answer.toString());
    }

    public static class Problem {
        private String expression;
        private String answer;

        public Problem(String expression, String answer) {
            this.expression = expression;
            this.answer = answer;
        }

        public String getCanonicalForm() {
            return expression; // Simplified canonical form
        }

        public String getExpression() { return expression; }
        public String getAnswer() { return answer; }
    }
}