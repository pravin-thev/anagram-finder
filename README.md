# Anagram Finder

## Overview
**Anagram Finder** is a Java-based program that reads a list of words from a file (`words-utf-8.txt`), identifies anagrams, and groups them together. The program is designed to be efficient, scalable, and easy to use, with a focus on simplicity and clarity.

## Features
- **Anagram Grouping**: The program identifies words that are anagrams of each other and groups them together.
- **Efficient Algorithm**: An efficient approach using sorting to identify anagrams ensures both simplicity and performance.
- **Output**: The program prints the groups of anagrams to the console, with each group on a new line, sorted alphabetically.
- **Scalability**: The solution can handle large datasets with minimal performance impact.

## Approach
1. **Input**: 
    - The program reads words from a `.txt` file (`words-utf-8.txt`), where each word is on a new line.
    
2. **Anagram Identification**:
    - Each word is converted into a **signature** by sorting its characters alphabetically.
    - Words with the same signature are considered anagrams.
    
3. **Grouping**:
    - Words are grouped using a `HashMap<String, List<String>>`, where each key is a word's signature and the value is a list of words sharing that signature (i.e., anagrams).
    
4. **Efficiency**:
    - The solution uses a `HashMap` to store and group words, ensuring an efficient lookup and grouping process, making the identification of anagrams scalable for large datasets.

## Design Decisions
- **Data Structure**: A `HashMap` is used to map the sorted word signature (e.g., "akte" → "aekt") to a list of words with that signature. This allows for fast grouping and ensures scalability with large datasets.
  
- **Sorting vs Hashing**: 
  - **Sorting**: Sorting the characters of each word ensures that anagrams (e.g., "akte" and "teak") have the same key, making grouping simple and intuitive. However, sorting comes with a higher time complexity.
  - **Hashing**: The hashing approach uses a frequency count of characters in the word, which can improve performance for larger datasets since it avoids sorting.

- **File Handling**: The program uses `FileReaderService` to read the input file and handle edge cases such as missing or empty files.

## Project Structure
anagram-finder/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── anagramfinder/
│   │   │        ├── App.java
│   │   │        ├── AnagramService.java         # Interface for anagram services
│   │   │        ├── AnagramServiceSorting.java  # Sorting-based anagram service implementation
│   │   │        ├── AnagramServiceHashing.java  # Hashing-based anagram service implementation
│   │   │        └── FileReaderService.java      # File reading service
│   │   └── resources/
│   │        └── words-utf8.txt                 # Input file containing the words
│   └── test/
│       └── java/
│            └── anagramfinder/
│                 └── AnagramServiceSortingTest.java  # Tests for sorting implementation
│                 └── AnagramServiceHashingTest.java  # Tests for hashing implementation
│                 └── FileReaderServiceTest.java      # Tests for file reading
├── pom.xml
└── README.md
└── AI_USAGE.md

## How to Run the Program

### 1. Clone the Repository
```bash
git clone <repository-url>
cd anagram-finder
```
### 2. Compile and Run the Program Using Maven
```bash
mvn clean compile exec:java
```
Or just simply run App.java

## Files in this project
- **App.java:** Main entry point of the program. It reads the input file and invokes the AnagramService to process the words.
- **AnagramService.java**: An interface that defines the method findAnagramGroups for identifying anagram groups from a list of words.
- **AnagramServiceHashing.java:** Implements the AnagramService interface using hashing-based logic to group anagrams.
- **FileReaderService.java:** Handles the reading of the words-utf-8.txt file, returning a list of words to be processed.
- **words-utf8.txt:** Input file containing a list of words (one word per line) to be processed.

## Edge Cases Considered
- **Empty Words:** Words with no characters (empty strings) are handled by sorting and hashing methods.
- **Case Sensitivity:** The program is case-sensitive.
- **Duplicate Words:** The program can handle duplicate words and groups them correctly.
- **Empty File:** If the words-utf-8.txt file is empty, the program will output no groups.
- **Missing File:** If the input file is missing, the program will throw an error or handle the exception gracefully.

 