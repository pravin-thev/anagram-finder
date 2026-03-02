package anagramfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AnagramServiceSorting implements AnagramService{
    
    @Override
    public List<List<String>> findAnagramGroups(List<String> words) {
        Map<String, List<String>> groups = new HashMap<>();

        // Iterate through each word in the list and process each word before collecting their signatures
        for (String line : words) {
            if (line == null || line.isBlank()) continue;

            String word = line.trim().toLowerCase(Locale.ROOT);
            String signature = signature(word);

            // Group words by their signature
            groups.computeIfAbsent(signature, k -> new ArrayList<>()).add(word);
        }

        // Collect the final results 
        // Only add anagrams/groups with more than 1 word
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            if (group.size() > 1) {
                Collections.sort(group);
                result.add(group);
            }
        }

        // Sort the final result (the groups) alphabetically
        result.sort(Comparator.comparing(g -> g.get(0)));
        return result;
    }

    // helper function for generating signatures by sorting the letters in a word
    private String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        List<String> words = List.of(
            "akte", "teak", "kate", "hello", "world", "listen", "silent", "rat", "tar", "art"
        );

        AnagramServiceSorting anagramService = new AnagramServiceSorting();

        List<List<String>> anagramGroups = anagramService.findAnagramGroups(words);
        for (List<String> group : anagramGroups) {
            System.out.println(String.join(" ", group));
        }

    }
}
