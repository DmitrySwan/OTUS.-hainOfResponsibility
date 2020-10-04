import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
   /* static final String INSERTION = "insertion";
    static final String MERGE = "merge";
    static final String SELECTION = "selection";

    *//**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     *//*
    private static SortApplication configureApplication(CommandLine cl) {
        String sortType = cl.getOptionValue(ParserCommandLineParser.SORT);
        SortApplication app;
        if (INSERTION.equalsIgnoreCase(sortType)) {
            app = new SortApplication(new InsertionSortFactory());
        } else if (MERGE.equalsIgnoreCase(sortType)) {
            app = new SortApplication(new MergeSortFactory());
        } else {
            app = new SortApplication(new SelectionSortFactory());
        }
        app.setInputFile(new File(cl.getOptionValue(ParserCommandLineParser.INPUT)));
        app.setOutputFile(new File(cl.getOptionValue(ParserCommandLineParser.OUTPUT)));
        return app;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SortApplication app = configureApplication(ParserCommandLineParser.parseCMDArgs(args));
        app.sort();
    }*/
}
