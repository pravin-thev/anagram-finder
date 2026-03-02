package anagramfinder;

import java.util.List;

public interface AnagramService {
    List<List<String>> findAnagramGroups(List<String> words);
}
