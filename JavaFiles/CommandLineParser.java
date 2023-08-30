package JavaFiles;

import java.util.Objects;

/**
 * A command-line parser that takes in arguments and sets fields accordingly. This class is designed
 * to parse command line arguments for generating text messages, such as emails and letters. It sets
 * fields based on the arguments provided and throws an exception if there are any missing or
 * incorrect arguments.
 */
public class CommandLineParser {

  /**
   * Constant representing the command line argument for email flag.
   */
  public static final String EMAIL = "--email";

  /**
   * Constant representing the command line argument for email template.
   */
  public static final String EMAIL_TEMPLATE = "--email-template";

  /**
   * Constant representing the command line argument for letter flag.
   */
  public static final String LETTER = "--letter";

  /**
   * Constant representing the command line argument for letter template.
   */
  public static final String LETTER_TEMPLATE = "--letter-template";

  /**
   * Constant representing the command line argument for output directory.
   */
  public static final String OUTPUT_DIR = "--output-dir";

  /**
   * Constant representing the command line argument for CSV file.
   */
  public static final String CSV_FILE = "--csv-file";

  /**
   * Constant representing the 0 number.
   */
  private static final int ZERO = 0;

  private boolean shouldGenerateEmails = false;
  private boolean shouldGenerateLetters = false;
  private String emailTemplate = null;
  private String letterTemplate = null;
  private String outputDir = null;
  private String CSVFile = null;

  /**
   * Constructs a new instance of CommandLineParser and processes the command line arguments.
   *
   * @param args The command line arguments to be processed.
   * @throws InvalidTextMessageException if the command line arguments are not in the correct
   *                                     format.
   */
  public CommandLineParser(String[] args) throws InvalidTextMessageException {
    this.textProcessor(args);
  }

  /**
   * Processes the command line arguments and extracts relevant data.
   *
   * @param args The command line arguments to be processed.
   * @throws InvalidTextMessageException if the command line arguments are not in the correct
   *                                     format.
   */
  private void textProcessor(String[] args) throws InvalidTextMessageException {
    for (int i = ZERO; i < args.length; i++) {
      switch (args[i]) {
        case EMAIL:
          this.shouldGenerateEmails = true;
          break;
        case EMAIL_TEMPLATE:
          i++;
          if (i >= args.length) {
            throw new InvalidTextMessageException("Missing argument for --email-template");
          }
          this.emailTemplate = args[i];
          break;
        case LETTER:
          this.shouldGenerateLetters = true;
          break;
        case LETTER_TEMPLATE:
          i++;
          if (i >= args.length) {
            throw new InvalidTextMessageException("Missing argument for --letter-template");
          }
          this.letterTemplate = args[i];
          break;
        case OUTPUT_DIR:
          i++;
          if (i >= args.length) {
            throw new InvalidTextMessageException("Missing argument for --output-dir");
          }
          this.outputDir = args[i];
          break;
        case CSV_FILE:
          i++;
          if (i >= args.length) {
            throw new InvalidTextMessageException("Missing argument for --csv-file");
          }
          this.CSVFile = args[i];
          break;
        default:
          throw new InvalidTextMessageException("Unknown argument: " + args[i]);
      }
    }

    if (args.length == ZERO) {
      throw new InvalidTextMessageException(
          "Must type in email/letter, email/letter template, output directory, and CSV file");
    }
    if (this.outputDir == null) {
      throw new InvalidTextMessageException("Must have an output directory");
    }
    if (this.CSVFile == null) {
      throw new InvalidTextMessageException("Must have a CSV file");
    }
    if (!this.shouldGenerateEmails && !this.shouldGenerateLetters) {
      throw new InvalidTextMessageException(
          "No action specified. Please provide either --email or --letter");
    }
    if (this.shouldGenerateEmails && this.emailTemplate == null) {
      throw new InvalidTextMessageException("Must have an email template");
    }
    if (this.shouldGenerateLetters && this.letterTemplate == null) {
      throw new InvalidTextMessageException("Must have a letter template");
    }
  }

  /**
   * Returns a boolean value indicating if emails are enabled or not.
   *
   * @return true if emails are enabled, false otherwise
   */
  public boolean shouldGenerateEmails() {
    return this.shouldGenerateEmails;
  }

  /**
   * Returns the email template to be used for generating emails.
   *
   * @return the email template
   */
  public String getEmailTemplate() {
    return this.emailTemplate;
  }

  /**
   * Returns a boolean value indicating if letters are enabled or not.
   *
   * @return true if letters are enabled, false otherwise
   */
  public boolean shouldGenerateLetters() {
    return this.shouldGenerateLetters;
  }

  /**
   * Returns the letter template to be used for generating letters.
   *
   * @return the letter template
   */
  public String getLetterTemplate() {
    return this.letterTemplate;
  }

  /**
   * Returns the output directory where the generated communication materials will be stored.
   *
   * @return the output directory
   */
  public String getOutputDir() {
    return this.outputDir;
  }

  /**
   * Returns the CSV file containing the data needed for generating communication materials.
   *
   * @return the CSV file
   */
  public String getCSVFile() {
    return this.CSVFile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return shouldGenerateEmails == that.shouldGenerateEmails
        && shouldGenerateLetters == that.shouldGenerateLetters && Objects.equals(emailTemplate,
        that.emailTemplate) && Objects.equals(letterTemplate, that.letterTemplate)
        && Objects.equals(outputDir, that.outputDir) && Objects.equals(CSVFile, that.CSVFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shouldGenerateEmails, shouldGenerateLetters, emailTemplate, letterTemplate,
        outputDir, CSVFile);
  }

  @Override
  public String toString() {
    return "CommandLineParser{" +
        "shouldGenerateEmails=" + shouldGenerateEmails +
        ", shouldGenerateLetters=" + shouldGenerateLetters +
        ", emailTemplate='" + emailTemplate + '\'' +
        ", letterTemplate='" + letterTemplate + '\'' +
        ", outputDir='" + outputDir + '\'' +
        ", CSVFile='" + CSVFile + '\'' +
        '}';
  }
}