package JavaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneratorTest {

  String template = """
      To:[[email]]
      Subject: Insurance company – information about recent data breach
      Dear [[first_name]] [[last_name]],
      As you may have heard or read.\n""";
  Generator testGenerator;
  List<Map<String, String>> data;
  List<String[]> testData = new ArrayList<>();
  String[] header, testClient1, testClient2;
  CsvDataProcessor testProcessor;

  @BeforeEach
  void setUp() throws InvalidCSVException {
    testGenerator = new Generator(template);
    header = new String[]{"first_name", "last_name", "email"};
    testClient1 = new String[]{"James", "Butt", "james1213.com"};
    testClient2 = new String[]{"Amy", "Swift", "amy1103.com"};
    testData.add(header);
    testData.add(testClient1);
    testData.add(testClient2);
    testProcessor = new CsvDataProcessor(testData);
    data = testProcessor.getData();
  }

  @Test
  void getTemplate() {
    assertEquals(template, testGenerator.getTemplate());
  }

  @Test
  void generateMessages() {
    List<String> messages = new ArrayList<>();
    String firstClient = """
        To:james1213.com
        Subject: Insurance company – information about recent data breach
        Dear James Butt,
        As you may have heard or read.\n""";
    String secondClient = """
        To:amy1103.com
        Subject: Insurance company – information about recent data breach
        Dear Amy Swift,
        As you may have heard or read.\n""";
    messages.add(firstClient);
    messages.add(secondClient);

    List<String> expectedMessages = testGenerator.generateMessages(data);

    assertEquals(messages, expectedMessages);
  }

  @Test
  void testEquals() {
    assertTrue(testGenerator.equals(testGenerator));
    assertFalse(testGenerator.equals(null));
    assertFalse(testGenerator.equals("null"));

    Generator otherGenerator1 = new Generator(template);
    Generator otherGenerator2 = new Generator("Hello [[name]]!");

    assertTrue(testGenerator.equals(otherGenerator1));

    assertFalse(testGenerator.equals(otherGenerator2));
  }

  @Test
  void testHashCode() {
    int expectedCode = Objects.hash(testGenerator.getTemplate());
    assertEquals(expectedCode, testGenerator.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Generator{" +
        "template='" + testGenerator.getTemplate() + '\'' +
        '}';
    assertEquals(expected, testGenerator.toString());
  }
}