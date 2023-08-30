package JavaFiles;

/**
 * This exception is thrown when a text message is invalid.
 */
public class InvalidTextMessageException extends Exception {

  /**
   * Constructs a new InvalidTextMessageException with the specified detail message.
   *
   * @param message the detail message
   */
  public InvalidTextMessageException(String message) {
    super(message);
  }
}
