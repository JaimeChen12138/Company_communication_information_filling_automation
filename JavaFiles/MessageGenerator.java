package JavaFiles;

import java.util.List;
import java.util.Map;

/**
 * A MessageGenerator is an interface class responsible for generating messages based on input
 * data.
 */
public interface MessageGenerator {

  /**
   * Generates messages for each record in the input data by replacing placeholders with actual
   * data.
   *
   * @param data a list of maps, where each map represents a record and its keys represent column
   *             headers and values represent corresponding values for that record
   * @return a list of generated messages
   */
  List<String> generateMessages(List<Map<String, String>> data);
}
