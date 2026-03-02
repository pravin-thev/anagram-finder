# anagram-finder

## Overview
Anagram Finder is a java-based program that reads a list of words from a file (words-utf-8.txt), identifies anagrams, and prints groups of anagrams found in the list. The program is implemented with the intent to be efficient, scalable, and easy to run, with focus on simplicity and clarity. 

## features
* Find anagram groups: The program identifies words that are anagram of each other and groups them together
* Efficient algorithm: The program uses sorting of word letters as the key to identify anagrams, making sure that the solution is both simple and fast.
* Output: The program prints the groups of anagrams to the console, with each group on a new line, sorted alphabetically.
Scalable: The solution is designed to handle a large number of words with minimal performance impact.

## Approach
1. Input: The program reads words from a .txt file, where each word is on a new line.
2. Sorting approach:
* Each word is converted to a signature, which is done by sorting the characters in the word
* Then words with the same signature are considered as anagrams
3. Grouping: Anagrams are then grouped using a Map<String, List<String>>, where each key is the signature and the value is a list of all the corresponding words. 
4. Efficiency: I use a HashMap to store and group words efficiently, ensuring that finding anagrams takes linear time in the number of words.

##Design decisions
* Data structure: 


# How to run the program
## 1. Clone the repo
git clone <repository-url>
cd anagram-finder

## 2. Compile and run the program using Maven
mvn clean compile exec:java
The program will read the words-utf8.txt file (ensure the file is in the src/main/resources directory) and output the anagram groups to the console.


## 3. Project Structure
anagram-finder/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── anagramfinder/
│   │   │        ├── App.java
│   │   │        └── AnagramService.java
│   │   └── resources/
│   │        └── words-utf8.txt
│   └── test/
│       └── java/
│            └── anagramfinder/
│                 └── AnagramServiceTest.java
│
├── pom.xml
├── README.md
├── AI_USAGE.md
└── .gitignore
App.java: Main entry point that reads the input file and invokes the AnagramService to process the words.
AnagramService.java: Contains the logic for finding anagram groups by sorting word letters and grouping them.
words-utf8.txt: Input file containing words (one word per line) to be processed.


## 4. Dependencies
Java 20 or higher is required to run this project.
Maven is used as the build and dependency management tool.
You can install Java 20 using Homebrew on macOS:
brew install openjdk@20
Then configure the JAVA_HOME environment variable as needed.


AI Usage Documentation
The file AI_USAGE.md includes a detailed log of interactions with ChatGPT and AI tools used during the project development. It contains:
Complete conversation history related to the implementation.
Suggestions made by AI, what was implemented, and why it was chosen.
Reflections on where AI helped in making decisions or improving efficiency.
Git History
Throughout the project, meaningful commits have been made, reflecting significant steps in the development process. Here are some examples of commit messages:
"Initial project structure" - Setting up Maven project with a basic App.java and AnagramService.java.
"Group words by anagram signature" - Implemented anagram grouping using a HashMap.
"Added README and AI Usage Documentation" - Created a comprehensive README file with approach, design decisions, and AI usage.
"Fixed edge cases for empty words and duplicates" - Handled edge cases like empty lines and duplicate words in the input.
Future Improvements
Handling Special Characters: Extend the program to clean up special characters in words (e.g., punctuation or whitespace).
Multithreading: Consider parallelizing the process for very large word lists to improve performance.
GUI or Web Interface: Build a simple UI to upload word lists and display results graphically.
Conclusion
This Anagram Finder project is a simple yet effective implementation that demonstrates the power of Java’s collection frameworks and algorithms. By using a straightforward approach of sorting word characters and grouping them in a HashMap, we can efficiently identify and group anagrams, even for large word lists.
