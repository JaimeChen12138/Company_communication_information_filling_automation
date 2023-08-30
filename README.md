# Company_communication_information_filling_automation
 Northeastern University group work. automate the process that the insurance company will use to communicate with its customers. 
The insurance company would like you to create a program that they can run on the command line. The program should take a CSV file and a template (or two) as input, and generate files that will contain the email messages and letters to send to their clients. When the program is run, it should output a new text file per row in the CSV file, with all placeholders replaced with the appropriate value for that row. See the “Example input and output” section of this specification for examples.
Your program should accept the following command line arguments1 in any order:

--email Generate email messages. If this option is provided, then --email-
                                    template must also be provided.
--email-template <path/to/file> A filename for the email template.

--letter   (Generate letters. If this option is provided, then --letter- template must also be provided.)

--letter-template <path/to/file> (A filename for the letter
template.)

--output-dir <path/to/folder>  (The folder to store all generated files. This option is required.)
--csv-file <path/to/file> (The CSV file to process. This option is required.)


