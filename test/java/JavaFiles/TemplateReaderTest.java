package JavaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateReaderTest {

  TemplateReader testReader;

  @BeforeEach
  void setUp() {
    testReader = new TemplateReader(
        "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main/java/InputFiles/test-template.txt");
  }

  @Test
  void testGetTemplatePath() {
    String expectedPath = "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main/java/InputFiles/test-template.txt";
    assertEquals(testReader.getTemplatePath(), expectedPath);
  }

  @Test
  void testGetTemplate() throws IOException {
    String testTemplate = testReader.getTemplate();
    String expected = """
        To:[[email]]
        Subject: Insurance company – information about recent data breach
        Dear [[first_name]] [[last_name]],
        As you may have heard or read.\n""";
    assertEquals(testTemplate, expected);
  }

  @Test
  void testEquals() {
    assertTrue(testReader.equals(testReader));
    assertFalse(testReader.equals(null));
    assertFalse(testReader.equals("null"));

    TemplateReader otherReader1 = new TemplateReader(
        "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main/java/InputFiles/test-template.txt");
    TemplateReader otherReader2 = new TemplateReader(
        "/Users/hw08/src/main/java/InputFiles/test-template.txt");

    assertTrue(testReader.equals(otherReader1));

    assertFalse(testReader.equals(otherReader2));
  }

  @Test
  void testHashCode() {
    int expectedCode = Objects.hash(testReader.getTemplatePath());
    assertEquals(expectedCode, testReader.hashCode());
  }

  @Test
  void testToString() {
    String expected = "TemplateReader{" +
        "templatePath='" + testReader.getTemplatePath() + '\'' +
        '}';
    assertEquals(expected, testReader.toString());
  }
}