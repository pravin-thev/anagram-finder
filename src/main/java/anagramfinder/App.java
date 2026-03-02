package anagramfinder;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        // FileReaderService to read words from the file
        FileReaderService fileReaderService = new FileReaderService();
        List<String> words = fileReaderService.readWordsFromFile("src/main/resources/words-utf8.txt");

        // either Sorting or Hashing
        AnagramService anagramService = new AnagramServiceSorting();  // AnagramServiceHashing()

        // Step 3: Find anagram groups
        List<List<String>> anagramGroups = anagramService.findAnagramGroups(words);

        // Step 4: Print the anagram groups
        for (List<String> group : anagramGroups) {
            System.out.println(String.join(" ", group));
        }
    }
}