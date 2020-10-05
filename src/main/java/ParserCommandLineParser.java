import org.apache.commons.cli.*;

class ParserCommandLineParser {
    static final String INPUT = "input";
    static final String OUTPUT = "output";

    private static Options options = new Options();

    /*$> java -jar target/my-utility.jar -i asd
    Missing required option: o

    usage: utility-name
    -i,--input <arg>    input file path
    -o,--output <arg>   output file*/
    static CommandLine parseCMDArgs(String[] args) {
        configureOption("i", INPUT, "input file path");
        configureOption("o", OUTPUT, "output file");

        CommandLine cmd = null;
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        return cmd;
    }

    private static void configureOption(String opt, String longOpt, String description) {
        Option option = new Option(opt, longOpt, true, description);
        option.setRequired(true);
        options.addOption(option);
    }
}
