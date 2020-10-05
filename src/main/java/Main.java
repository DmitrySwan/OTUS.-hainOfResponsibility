import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
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
