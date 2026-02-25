package anagramfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AnagramService {
    
    public List<List<String>> findAnagramGroups(List<String> words) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String line : words) {
            if (line == null || line.isBlank()) continue;

            String word = line.trim().toLowerCase(Locale.ROOT);
            String signature = signature(word);

            groups.computeIfAbsent(signature, k -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            if (group.size() > 1) {
                Collections.sort(group);
                result.add(group);
            }
        }

        result.sort(Comparator.comparing(g -> g.get(0)));
        return result;
    }

    private String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
