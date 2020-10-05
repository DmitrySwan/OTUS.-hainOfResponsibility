import org.apache.commons.cli.CommandLine;

import java.io.File;

public class Main {
    private static ParserApplication configureApplication(CommandLine cl) {
        ParserApplication app = new ParserApplication();
        app.setInputFile(new File(cl.getOptionValue(ParserCommandLineParser.INPUT)));
        app.setOutputFile(new File(cl.getOptionValue(ParserCommandLineParser.OUTPUT)));
        return app;
    }

    public static void main(String[] args) {
        ParserApplication parserApplication = configureApplication(ParserCommandLineParser.parseCMDArgs(args));
        parserApplication.parse();
    }
}
