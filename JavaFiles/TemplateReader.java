package JavaFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * A class for reading the content of a template file.
 */
public class TemplateReader {

  /**
   * The file path of the template file.
   */
  private final String templatePath;

  /**
   * Constructs a new TemplateReader object with the specified template file path.
   *
   * @param templatePath the file path of the template file to be read
   */
  public TemplateReader(String templatePath) {
    this.templatePath = templatePath;
  }

  public String getTemplatePath() {
    return this.templatePath;
  }

  /**
   * Reads the content of the template file and returns it as a string.
   *
   * @return the content of the template file as a string
   * @throws IOException if an I/O error occurs while reading the file
   */
  public String getTemplate() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(this.templatePath));
    StringBuilder sb = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
      sb.append(line);
      sb.append(System.lineSeparator());
      line = reader.readLine();
    }
    reader.close();
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateReader that = (TemplateReader) o;
    return Objects.equals(getTemplatePath(), that.getTemplatePath());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTemplatePath());
  }

  @Override
  public String toString() {
    return "TemplateReader{" +
        "templatePath='" + templatePath + '\'' +
        '}';
  }
}
