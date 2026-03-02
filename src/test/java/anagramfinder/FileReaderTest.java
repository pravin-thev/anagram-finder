package anagramfinder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void testReadWordsFromFile() throws IOException {
        // Prepare a temporary test file
        String fileName = "testWords.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("akte\n");
            writer.write("teak\n");
            writer.write("kate\n");
            writer.write("bat\n");
            writer.write("tab\n");
        }
        
        // Create a FileReaderService instance and read the file
        FileReaderService fileReaderService = new FileReaderService();
        List<String> words = fileReaderService.readWordsFromFile(fileName);
        
        // Verify that the file contents were read correctly
        assertEquals(5, words.size());
        assertTrue(words.contains("akte"));
        assertTrue(words.contains("teak"));
        assertTrue(words.contains("kate"));
        assertTrue(words.contains("bat"));
        assertTrue(words.contains("tab"));
        
        // Clean up the test file
        new File(fileName).delete();
    }

    @Test
    public void testReadWordsFromEmptyFile() throws IOException {
        // Prepare an empty test file
        String fileName = "emptyTestWords.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Empty file
        }
        
        // Create a FileReaderService instance and read the file
        FileReaderService fileReaderService = new FileReaderService();
        List<String> words = fileReaderService.readWordsFromFile(fileName);
        
        // Verify that the list is empty
        assertTrue(words.isEmpty());
        
        // Clean up the test file
        new File(fileName).delete();
    }
}