package JavaFiles;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Objects;

/**
 * This class represents an output object used for printing lines to a file.
 */

public class FileOutput {

  private static final int ZERO = 0;
  private static final int ONE = 1;

  /**
   * The name of the file to write the output to.
   */
  private String outputDir;
  private String fileType;

  /**
   * Constructs a new Output object with the specified file name.
   *
   * @param outputDir the name of the file to write the output to
   */
  public FileOutput(String outputDir, String fileType) {
    this.outputDir = outputDir;
    this.fileType = fileType;
  }

  /**
   * Prints the lines in the specified ArrayList to the file specified in the constructor.
   *
   * @param messages the ArrayList of lines to print
   * @throws FileNotFoundException if the specified file cannot be found
   */
  public void writeFile(List<String> messages) throws IOException {
    try {
      for (int i = ZERO; i < messages.size(); i++) {
        String name = fileType + (i + ONE) + ".txt";
        String path = outputDir + '/' + name;
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(messages.get(i));
        writer.close();
      }
    } catch (Exception e) {
      throw new IOException();
    }
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    FileOutput that = (FileOutput) o;
    return Objects.equals(outputDir, that.outputDir) && Objects.equals(fileType, that.fileType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outputDir, fileType);
  }

  @Override
  public String toString() {
    return "FileOutput{" +
        "outputDir='" + outputDir + '\'' +
        ", fileType='" + fileType + '\'' +
        '}';
  }
}