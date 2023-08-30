package JavaFiles;

/**
 * This exception is thrown when a CSV file is not as expected.
 */
public class InvalidCSVException extends Exception {

  /**
   * Constructs a new InvalidCSVException with the specified detail message.
   *
   * @param message the detail message
   */
  public InvalidCSVException(String message) {
    super(message);
  }
}
