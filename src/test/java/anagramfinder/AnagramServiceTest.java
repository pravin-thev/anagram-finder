package anagramfinder;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AnagramServiceTest {

    @Test
    public void groupsWordsWithSameLetters() {
        AnagramService service = new AnagramService();

        List<List<String>> groups = service.findAnagramGroups(List.of(
                "akte", "teak", "kate", "abc", "cba", "alone"
        ));

        assertTrue(groups.stream().anyMatch(g -> g.containsAll(List.of("akte", "teak", "kate"))));
        assertTrue(groups.stream().anyMatch(g -> g.containsAll(List.of("abc", "cba"))));
        assertFalse(groups.stream().anyMatch(g -> g.contains("alone")));
    }
}