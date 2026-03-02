package anagramfinder;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AnagramServiceSortingTest {

    @Test
    public void testFindAnagramGroups() {
        AnagramServiceSorting anagramService = new AnagramServiceSorting();
        
        // Sample input: "akte", "teak", "kate", "bat", "tab"
        List<String> words = List.of("akte", "teak", "kate", "bat", "tab");
        
        List<List<String>> anagramGroups = anagramService.findAnagramGroups(words);
        
        // We expect two groups: ["akte", "teak", "kate"] and ["bat", "tab"]
        assertEquals(2, anagramGroups.size());
        
        // Check the content of the first group
        List<String> firstGroup = anagramGroups.get(0);
        assertTrue(firstGroup.contains("akte"));
        assertTrue(firstGroup.contains("teak"));
        assertTrue(firstGroup.contains("kate"));
        
        // Check the content of the second group
        List<String> secondGroup = anagramGroups.get(1);
        assertTrue(secondGroup.contains("bat"));
        assertTrue(secondGroup.contains("tab"));
    }

    @Test
    public void testFindAnagramGroupsNoAnagrams() {
        AnagramServiceSorting anagramService = new AnagramServiceSorting();
        
        // Sample input: no anagrams
        List<String> words = List.of("cat", "dog", "fish");
        
        List<List<String>> anagramGroups = anagramService.findAnagramGroups(words);
        
        // We expect no groups since none of the words have anagrams
        assertEquals(0, anagramGroups.size());
    }
}