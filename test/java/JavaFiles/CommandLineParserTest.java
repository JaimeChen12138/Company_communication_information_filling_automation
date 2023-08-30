package JavaFiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {

  CommandLineParser testCommandLineParser;
  CommandLineParser testCommandLineParser2;

  @BeforeEach
  void setUp() throws InvalidTextMessageException {
    String[] args = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    testCommandLineParser = new CommandLineParser(args);

    String[] letter = "--letter --letter-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    testCommandLineParser2 = new CommandLineParser(letter);

  }


  @Test
  void invalidCases() throws InvalidTextMessageException {
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(new String[0]));

    String[] args1 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args1));

    String[] args2 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory".split(
        " ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args2));

    String[] args3 = "--email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args3));

    String[] args4 = "--email --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args4));

    String[] args5 = "--asdf".split(" ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args5));

    String[] args6 = "--email-template".split(" ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args6));

    String[] args7 = "--letter-template".split(" ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args7));

    String[] args8 = "--output-dir".split(" ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args8));

    String[] args9 = "--csv-file".split(" ");
    assertThrows(InvalidTextMessageException.class, () -> new CommandLineParser(args9));

  }

  @Test
  void shouldGenerateEmails() {
    assertTrue(testCommandLineParser.shouldGenerateEmails());
  }

  @Test
  void getEmailTemplate() {
    assertEquals(testCommandLineParser.getEmailTemplate(),
        "/Users/joycelyu/Desktop/testOutput/test.txt");

  }

  @Test
  void shouldGenerateLetters() {
    assertTrue(testCommandLineParser2.shouldGenerateLetters());
  }

  @Test
  void getLetterTemplate() {
    assertEquals(testCommandLineParser2.getLetterTemplate(),
        "/Users/joycelyu/Desktop/testOutput/test.txt");
  }

  @Test
  void getOutputDir() {
    assertEquals(testCommandLineParser.getOutputDir(),
        "/Users/joycelyu/Desktop/testOutput/outputDirectory");

  }

  @Test
  void getCSVFile() {
    assertEquals(testCommandLineParser.getCSVFile(), "/Users/joycelyu/Desktop/testOutput/test.csv");

  }

  @Test
  void testEquals() throws InvalidTextMessageException {
    assertTrue(testCommandLineParser.equals(testCommandLineParser));
    assertFalse(testCommandLineParser.equals(null));
    assertFalse(testCommandLineParser.equals("null"));

    String[] args6 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    CommandLineParser test1 = new CommandLineParser(args6);
    assertTrue(testCommandLineParser.equals(test1));

    String[] args7 = "--letter --letter-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    CommandLineParser test3 = new CommandLineParser(args7);
    assertFalse(testCommandLineParser.equals(test3));

    String[] args8 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test1.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    CommandLineParser test4 = new CommandLineParser(args8);
    assertFalse(testCommandLineParser.equals(test4));

    String[] args9 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput --csv-file /Users/joycelyu/Desktop/testOutput/test.csv".split(
        " ");
    CommandLineParser test5 = new CommandLineParser(args9);
    assertFalse(testCommandLineParser.equals(test5));

    String[] args10 = "--email --email-template /Users/joycelyu/Desktop/testOutput/test.txt --output-dir /Users/joycelyu/Desktop/testOutput/outputDirectory --csv-file /Users/joycelyu/Desktop/testOutput/test3.csv".split(
        " ");
    CommandLineParser test6 = new CommandLineParser(args10);
    assertFalse(testCommandLineParser.equals(test6));


  }

  @Test
  void testHashCode() {
    assertNotEquals(0, testCommandLineParser.hashCode());
  }

  @Test
  void testToString() {
    assertNotNull(testCommandLineParser.toString());

  }
}