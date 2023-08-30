package JavaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvDataProcessorTest {

  List<String[]> expected = new ArrayList<>();
  List<String[]> csvData = new ArrayList<>();
  CsvDataProcessor cv;
  CsvDataProcessor cv2;
  CsvDataProcessor cv3;
  String[] first;
  String[] second;

  @BeforeEach
  void setUp() {
    first = new String[]{"first_name", "last_name", "company_name"};
    second = new String[]{"James", "Butt", "Benton, John B Jr"};
    expected.add(first);
    expected.add(second);
    cv = new CsvDataProcessor(expected);
    cv2 = new CsvDataProcessor(csvData);
  }

  @Test
  void test() throws InvalidCSVException {
    List<Map<String, String>> ans = cv.getData();
    Map<String, String> map = new HashMap<>();
    map.put("first_name", "James");
    map.put("last_name", "Butt");
    map.put("company_name", "Benton, John B Jr");

    for (String key : map.keySet()) {
      System.out.println(ans.get(0).get(key));
      assertTrue(ans.get(0).get(key).equals(map.get(key)));
    }

  }

  @Test
  void testException() {
    assertThrows(InvalidCSVException.class, () -> {
      cv2.getData();
    });
    expected.add(new String[]{"Tom"});
    cv3 = new CsvDataProcessor(expected);
    assertThrows(InvalidCSVException.class, () -> {
      cv3.getData();
    });
  }

  @Test
  void testEquals() {
    assertTrue(cv.equals(cv));
    assertFalse(cv.equals(null));
    assertFalse(cv.equals(cv2));

    String expected = "CsvDataProcessor{" +
        "CSVFile=" + csvData +
        '}';
    assertEquals(expected, cv2.toString());
  }

}