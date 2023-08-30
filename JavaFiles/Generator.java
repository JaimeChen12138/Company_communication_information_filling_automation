package JavaFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A class that generates messages from a template by replacing placeholders with actual data.
 * Implements the MessageGenerator interface.
 */
public class Generator implements MessageGenerator {

  /**
   * The message template to use for generating messages.
   */
  private final String template;

  /**
   * Constructs a Generator with the specified message template.
   *
   * @param template the message template to use for generating messages
   */
  public Generator(String template) {
    this.template = template;
  }

  /**
   * Returns the message template used by this Generator.
   *
   * @return the message template used by this Generator
   */
  public String getTemplate() {
    return this.template;
  }

  /**
   * Generates messages for each record in the input data by replacing placeholders with actual
   * data.
   *
   * @param data a list of maps, where each map represents a record and its keys represent column
   *             headers and values represent corresponding values for that record
   * @return a list of generated messages
   */
  @Override
  public List<String> generateMessages(List<Map<String, String>> data) {
    List<String> messages = new ArrayList<>();
    for (Map<String, String> record : data) {
      String message = replacePlaceholders(record);
      messages.add(message);
    }
    return messages;
  }

  /**
   * Replaces placeholders in the message template with actual data from the input record.
   *
   * @param data a map representing a record, where keys represent column headers and values
   *             represent corresponding values for that record
   * @return the message with placeholders replaced by actual data
   */
  private String replacePlaceholders(Map<String, String> data) {
    String message = this.template;
    for (Map.Entry<String, String> entry : data.entrySet()) {
      String placeholder = "[[" + entry.getKey() + "]]";
      String replaceValue = entry.getValue();
      message = message.replace(placeholder, replaceValue);
    }
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Generator generator = (Generator) o;
    return Objects.equals(getTemplate(), generator.getTemplate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTemplate());
  }

  @Override
  public String toString() {
    return "Generator{" +
        "template='" + template + '\'' +
        '}';
  }
}
