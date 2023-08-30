package JavaFiles;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    try {
      CommandLineParser parser = new CommandLineParser(args);
      String csvFilePath = parser.getCSVFile();
      String outputDir = parser.getOutputDir();

      CSVReader csvReader = new CSVReader(csvFilePath);
      List<String[]> csvData = csvReader.readCSVFile();
      CsvDataProcessor csvProcessor = new CsvDataProcessor(csvData);
      List<Map<String, String>> clientData = csvProcessor.getData();

      if (parser.shouldGenerateEmails()) {
        String emailTemplatePath = parser.getEmailTemplate();
        TemplateReader templateReader = new TemplateReader(emailTemplatePath);
        String emailTemplate = templateReader.getTemplate();

        Generator emailGenerator = new Generator(emailTemplate);
        List<String> emails = emailGenerator.generateMessages(clientData);

        FileOutput emailFileOutput = new FileOutput(outputDir, "email");
        emailFileOutput.writeFile(emails);
      }

      if (parser.shouldGenerateLetters()) {
        String letterTemplatePath = parser.getLetterTemplate();
        TemplateReader templateReader = new TemplateReader(letterTemplatePath);
        String letterTemplate = templateReader.getTemplate();

        Generator letterGenerator = new Generator(letterTemplate);
        List<String> letters = letterGenerator.generateMessages(clientData);

        FileOutput letterFileOutput = new FileOutput(outputDir, "letter");
        letterFileOutput.writeFile(letters);
      }
    } catch (IllegalArgumentException | IOException | InvalidCSVException e) {
      System.out.println(e.getMessage());
    } catch (InvalidTextMessageException e) {
      throw new RuntimeException(e);
    }
  }
}
