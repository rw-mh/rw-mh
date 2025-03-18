import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void writeToFile(List<String> lines, String filename) {
        try (java.io.PrintWriter out = new java.io.PrintWriter(filename)) {
            for (String line : lines) {
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File(filename))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}