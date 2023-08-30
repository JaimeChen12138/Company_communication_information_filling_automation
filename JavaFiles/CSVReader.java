package JavaFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class for reading CSV files.
 */
public class CSVReader {
  private static final int ZERO = 0;

  private String filePath;

  /**
   * Constructs a CSVReader with the specified file path.
   *
   * @param filePath the path of the CSV file to read
   */
  public CSVReader(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Reads the CSV file and returns a list of String arrays, where each array represents a row in the CSV file.
   *
   * @return a list of String arrays, where each array represents a row- a client's info in the CSV file
   * @throws IOException if there is an error reading the CSV file
   */
  public List<String[]> readCSVFile() throws IOException {
    List<String[]> dataList = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
      String line = reader.readLine();
      while (line != null) {
        String[] cur = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (int i = ZERO; i < cur.length; i++) {
          cur[i] = cur[i].replace("\"", "");
        }
        dataList.add(cur);
        line = reader.readLine();
      }
      reader.close();
    } catch (FileNotFoundException nf) {
      throw new FileNotFoundException();
    }
    return dataList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVReader csvReader = (CSVReader) o;
    return Objects.equals(filePath, csvReader.filePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filePath);
  }

  @Override
  public String toString() {
    return "CSVReader{" +
        "filePath='" + filePath + '\'' +
        '}';
  }
}
