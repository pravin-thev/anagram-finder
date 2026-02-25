package anagramfinder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String resourceName = "words-utf8.txt";

        List<String> words = readLinesFromResource(resourceName);

        AnagramService service = new AnagramService();
        List<List<String>> groups = service.findAnagramGroups(words);

        for (List<String> group : groups) {
            System.out.println(String.join(" ", group));
        }
    }

    private static List<String> readLinesFromResource(String resourceName) throws IOException {
        InputStream is = App.class.getClassLoader().getResourceAsStream(resourceName);
        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + resourceName);
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
