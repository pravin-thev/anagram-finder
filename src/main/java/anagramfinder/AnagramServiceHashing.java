package anagramfinder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramServiceHashing implements AnagramService{

    @Override
    // Method to find anagram groups
    public List<List<String>> findAnagramGroups(List<String> words) {
        Map<Map<Character, Integer>, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            // Generate frequency map for each word
            Map<Character, Integer> frequencyMap = getFrequencyMap(word);
            
            // Group words by their frequency map
            anagramGroups.computeIfAbsent(frequencyMap, k -> new ArrayList<>()).add(word);
        }

        // Collect the results
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : anagramGroups.values()) {
            if (group.size() > 1) {
                // Only added if there are more than one anagram
                result.add(group);  
            }
        }

        // Sort anagram groups alphabetically
        result.sort(Comparator.comparing(g -> g.get(0)));  
        return result;
    }

    // Helper method to generate a frequency map from a word
    // Key is the character and value is the count
    private Map<Character, Integer> getFrequencyMap(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = List.of(
            "akte", "teak", "kate", "hello", "world", "listen", "silent", "rat", "tar", "art"
        );

        AnagramServiceHashing anagramService = new AnagramServiceHashing();

        List<List<String>> anagramGroups = anagramService.findAnagramGroups(words);
        for (List<String> group : anagramGroups) {
            System.out.println(String.join(" ", group));
        }
    }
}