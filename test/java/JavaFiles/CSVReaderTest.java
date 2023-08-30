package JavaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVReaderTest {

  CSVReader reader;
  CSVReader reader2;
  List<String[]> expected;

  @BeforeEach
  void setUp() {
    reader = new CSVReader(
        "/Users/yizhouchen/Desktop/hw08/src/main/java/InputFiles/test-information.csv");
    reader2 = new CSVReader("/sa?sda/s");
  }

  @Test
  void readCSVfile() throws IOException {
    List<String[]> expected = new ArrayList<>();
    String[] first = new String[]{"first_name", "last_name", "company_name", "address", "city"};
    String[] second = new String[]{"James", "Butt", "Benton, John B Jr", "6649 N Blue Gum St",
        "New Orleans"};
    expected.add(first);
    expected.add(second);
    List<String[]> actual = reader.readCSVFile();

    assertEquals(expected.size(), actual.size());

    for (int i = 0; i < expected.size(); i++) {
      assertArrayEquals(expected.get(i), reader.readCSVFile().get(i));
    }
  }


  @Test
  void testException() {
    assertThrows(FileNotFoundException.class, () -> {
      reader2.readCSVFile();
    });
    assertThrows(IOException.class, () -> {
      reader2.readCSVFile();
    });
  }

  @Test
  void test() {
    assertTrue(reader.equals(reader));
    assertFalse(reader.equals(null));
    assertFalse(reader.equals(reader2));

    String expected = "CSVReader{" +
        "filePath='"
        + "/Users/yizhouchen/Desktop/hw08/src/main/java/InputFiles/test-information.csv" + '\'' +
        '}';
    assertEquals(expected, reader.toString());
  }


}