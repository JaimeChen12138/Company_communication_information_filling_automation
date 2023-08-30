package JavaFiles;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * CsvDataProcessor class processes a CSV file(String[]) and converts it into a list of maps. Each map represents a row
 * in the CSV file, where the keys of the map are the header names and the values are the corresponding values of that
 * clients row.
 */
public class CsvDataProcessor {
  private static final int ZERO = 0;
  private static final int ONE = 1;

  private List<String[]> CSVFile;

  /**
   * Creates a new CsvDataProcessor instance with the given processed CSV file.
   *
   * @param CSVFile the CSV file to process
   */
  public CsvDataProcessor(List<String[]> CSVFile) {
    this.CSVFile = CSVFile;
  }

  /**
   * Processes the CSV file and returns a list of maps representing the CSV data.
   *
   * @return a list of maps representing the CSV data
   * @throws InvalidCSVException if the CSV file is empty or the format is invalid
   */
  public List<Map<String, String>> getData() throws InvalidCSVException {
    List<Map<String, String>> data = new ArrayList<>();
    if (CSVFile.size() == ZERO) {
      throw new InvalidCSVException("Empty CSV file");
    }
    String[] headers = CSVFile.get(ZERO);
    for (int i = ONE; i < CSVFile.size(); i++) {
      Map<String, String> map = createRow(headers, CSVFile.get(i));
      data.add(map);
    }
    return data;
  }

  /**
   * Creates a map representing a row in the CSV file with the given headers and values.
   *
   * @param headers the headers of the CSV file
   * @param curRow  the values of the row to create a map for
   * @return a map representing the row with the given headers and values
   */
  private Map<String, String> createRow(String[] headers, String[] curRow){
    Map<String, String> curMap = new LinkedHashMap<>();
    if (headers.length == curRow.length) {
      for (int i = ZERO; i < headers.length; i++) {
        curMap.put(headers[i], curRow[i]);
      }
    }
    return curMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CsvDataProcessor that = (CsvDataProcessor) o;
    return Objects.equals(CSVFile, that.CSVFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(CSVFile);
  }

  @Override
  public String toString() {
    return "CsvDataProcessor{" +
        "CSVFile=" + CSVFile +
        '}';
  }
}
